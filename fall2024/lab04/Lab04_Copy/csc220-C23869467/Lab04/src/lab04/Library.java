package lab04;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Scanner;

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
        ArrayList<LibraryBook<Type>> toBeAdded = new ArrayList<>();

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

                toBeAdded.add(new LibraryBook<>(isbn, author, title));

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
        ArrayList<LibraryBook<Type>> checkedOutList = new ArrayList<>();
        for (LibraryBook<Type> book : library) {
            if (holder.equals(book.getHolder())) {
                checkedOutList.add(book);
            }
        }
        return checkedOutList;
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
        boolean found = false;
        for (LibraryBook<Type> book : library) {
            if (holder.equals(book.getHolder())) {
                book.checkin();
                found = true;
            }
        }
        return found;
    }

    // Method to retrieve list of books sorted by ISBN
    public ArrayList<LibraryBook<Type>> getInventoryList() {
        ArrayList<LibraryBook<Type>> libraryCopy = new ArrayList<>(library);
        IsbnComparator comparator = new IsbnComparator();
        sort(libraryCopy, comparator);
        return libraryCopy;
    }

    // Method to retrieve list of books sorted by author
    public ArrayList<LibraryBook<Type>> getOrderedByAuthor() {
        ArrayList<LibraryBook<Type>> libraryCopy = new ArrayList<>(library);
        AuthorComparator comparator = new AuthorComparator();
        sort(libraryCopy, comparator);
        return libraryCopy;
    }

    // Method to retrieve list of overdue books sorted by due date
    public ArrayList<LibraryBook<Type>> getOverdueList() {
        ArrayList<LibraryBook<Type>> overdueBooks = new ArrayList<>();

        // Find all overdue books
        GregorianCalendar today = new GregorianCalendar();
        for (LibraryBook<Type> book : library) {
            if (book.getDueDate() != null && book.getDueDate().compareTo(today) < 0) {
                overdueBooks.add(book);
            }
        }

        // Sort overdue books by due date
        DueDateComparator comparator = new DueDateComparator();
        sort(overdueBooks, comparator);
        return overdueBooks;
    }

    // Generic sort method
    private static <ListType> void sort(ArrayList<ListType> list, Comparator<ListType> c) {
        for (int i = 0; i < list.size() - 1; i++) {
            int j, minIndex;
            for (j = i + 1, minIndex = i; j < list.size(); j++) {
                if (c.compare(list.get(j), list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            ListType temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }

    // Comparator to sort by ISBN
    protected class IsbnComparator implements Comparator<LibraryBook<Type>> {
        @Override
        public int compare(LibraryBook<Type> book1, LibraryBook<Type> book2) {
            return Long.compare(book1.getIsbn(), book2.getIsbn());
        }
    }

    // Comparator to sort by author and title
    protected class AuthorComparator implements Comparator<LibraryBook<Type>> {
        @Override
        public int compare(LibraryBook<Type> book1, LibraryBook<Type> book2) {
            int authorComparison = book1.getAuthor().compareTo(book2.getAuthor());
            if (authorComparison != 0) {
                return authorComparison;
            }
            // If authors are the same, compare by title
            return book1.getTitle().compareTo(book2.getTitle());
        }
    }

    // Comparator to sort by due date
    protected class DueDateComparator implements Comparator<LibraryBook<Type>> {
        @Override
        public int compare(LibraryBook<Type> book1, LibraryBook<Type> book2) {
            // Handle null due dates to prevent NullPointerException
            if (book1.getDueDate() == null && book2.getDueDate() == null) return 0;
            if (book1.getDueDate() == null) return 1; // Null dates are considered "later"
            if (book2.getDueDate() == null) return -1;
            // Compare by due date
            return book1.getDueDate().compareTo(book2.getDueDate());
        }
    }
}
