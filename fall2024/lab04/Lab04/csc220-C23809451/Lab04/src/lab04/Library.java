package lab04;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

import java.util.*;

public class Library<Type> {
    private ArrayList<LibraryBook<Type>> library;

    public Library() {
        library = new ArrayList<>();
    }

    public void add(long isbn, String author, String title) {
        library.add(new LibraryBook<>(isbn, author, title));
    }

    public void addAll(ArrayList<LibraryBook<Type>> list) {
        library.addAll(list);
    }

    public void addAll(String filename) {
        ArrayList<LibraryBook<Type>> toBeAdded = new ArrayList<LibraryBook<Type>>();

        try {
            Scanner fileIn = new Scanner(new File(filename));
            int lineNum = 1;

            while (fileIn.hasNextLine()) {
                String line = fileIn.nextLine();

                Scanner lineIn = new Scanner(line);
                lineIn.useDelimiter("\\t");

                if (!lineIn.hasNextLong())
                    throw new ParseException("ISBN", lineNum);
                long isbn = lineIn.nextLong();

                if (!lineIn.hasNext())
                    throw new ParseException("Author", lineNum);
                String author = lineIn.next();

                if (!lineIn.hasNext())
                    throw new ParseException("Title", lineNum);
                String title = lineIn.next();

                toBeAdded.add(new LibraryBook(isbn, author, title));

                lineNum++;
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage() + " Nothing added to the library.");
            return;
        } catch (ParseException e) {
            System.err.println(e.getLocalizedMessage()
                    + " formatted incorrectly at line " + e.getErrorOffset()
                    + ". Nothing added to the library.");
            return;
        }

        library.addAll(toBeAdded);
    }


    public Type lookup(long isbn) {
        for (LibraryBook<Type> book : library) {
            if (book.getIsbn() == isbn) {
                return book.getHolder();
            }
        }
        return null;
    }

    public ArrayList<LibraryBook<Type>> lookup(Type holder) {
        ArrayList<LibraryBook<Type>> result = new ArrayList<>();
        for (LibraryBook<Type> book : library) {
            if (holder.equals(book.getHolder())) {
                result.add(book);
            }
        }
        return result;
    }

    public boolean checkout(long isbn, Type holder, int month, int day, int year) {
        for (LibraryBook<Type> book : library) {
            if (book.getIsbn() == isbn && book.getHolder() == null) {
                GregorianCalendar dueDate = new GregorianCalendar(year, month, day);
                book.checkout(holder, dueDate);
                return true;
            }
        }
        return false;
    }

    public boolean checkin(long isbn) {
        for (LibraryBook<Type> book : library) {
            if (book.getIsbn() == isbn && book.getHolder() != null) {
                book.checkin();
                return true;
            }
        }
        return false;
    }

    public boolean checkin(Type holder) {
        boolean anyBookCheckedIn = false;
        for (LibraryBook<Type> book : library) {
            if (holder.equals(book.getHolder())) {
                book.checkin();
                anyBookCheckedIn = true;
            }
        }
        return anyBookCheckedIn;
    }

    // Part 1: Retrieving a list of library books sorted by author
    public List<LibraryBook<Type>> getOrderedByAuthor() {
        ArrayList<LibraryBook<Type>> libraryCopy = new ArrayList<>(library);

        // Sort using AuthorComparator
        Collections.sort(libraryCopy, new AuthorComparator());

        return libraryCopy;
    }

    // Part 2: Retrieving a list of overdue books sorted by due date
    public List<LibraryBook<Type>> getOverdueList() {
        ArrayList<LibraryBook<Type>> overdueBooks = new ArrayList<>();
        GregorianCalendar today = new GregorianCalendar();

        // Filter only overdue books (those with due dates before today)
        for (LibraryBook<Type> book : library) {
            if (book.getDueDate() != null && book.getDueDate().compareTo(today) < 0) {
                overdueBooks.add(book);
            }
        }

        // Sort overdue books by due date using DueDateComparator
        Collections.sort(overdueBooks, new DueDateComparator());

        return overdueBooks;
    }
    /**
    //  * Comparator that defines an ordering among library books using the author,  and book title as a tie-breaker.
    //  */
     protected class AuthorComparator implements Comparator<LibraryBook<Type>> {

        public int compare(LibraryBook<Type> book1, LibraryBook<Type> book2) {
            // Compare authors first
            int authorComparison = book1.getAuthor().compareTo(book2.getAuthor());

            // If authors are the same, compare by title
            if (authorComparison == 0) {
                return book1.getTitle().compareTo(book2.getTitle());
            }

            return authorComparison;
        }
     }

     /**
      * Comparator that defines an ordering among library books using the due date.
      */
     protected class DueDateComparator implements Comparator<LibraryBook<Type>> {


         public int compare(LibraryBook<Type> book1, LibraryBook<Type> book2) {
             // Handle null due dates carefully
             if (book1.getDueDate() == null && book2.getDueDate() == null) {
                 return 0; // Both are null, considered equal
             }
             if (book1.getDueDate() == null) {
                 return 1; // Null due date means book1 is "greater"
             }
             if (book2.getDueDate() == null) {
                 return -1; // Null due date means book2 is "greater"
             }

             // Compare by due dates
             return book1.getDueDate().compareTo(book2.getDueDate());
         }
     }

     }


