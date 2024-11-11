package lab04;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

/**
 * Class representation of a library (a collection of library books).
 */
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
            if (book.getIsbn() == isbn) {
                if (book.getHolder() != null) {
                    return false;
                } else {
                    GregorianCalendar dueDate = new GregorianCalendar(year, month - 1, day);
                    book.checkout(holder, dueDate);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkin(long isbn) {
        for (LibraryBook<Type> book : library) {
            if (book.getIsbn() == isbn) {
                if (book.getHolder() == null) {
                    return false;
                } else {
                    book.checkin();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkin(Type holder) {
        boolean anyCheckedIn = false;
        for (LibraryBook<Type> book : library) {
            if (holder.equals(book.getHolder())) {
                book.checkin();
                anyCheckedIn = true;
            }
        }
        return anyCheckedIn;
    }

    public ArrayList<LibraryBook<Type>> getInventoryList() {
        ArrayList<LibraryBook<Type>> libraryCopy = new ArrayList<>(library);
        IsbnComparator comparator = new IsbnComparator();
        sort(libraryCopy, comparator);
        return libraryCopy;
    }

    private static <ListType> void sort(ArrayList<ListType> list, Comparator<ListType> c) {
        for (int i = 0; i < list.size() - 1; i++) {
            int j, minIndex;
            for (j = i + 1, minIndex = i; j < list.size(); j++)
                if (c.compare(list.get(j), list.get(minIndex)) < 0)
                    minIndex = j;
            ListType temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }

    /**
     * Retrieves a list of library books sorted by the author's full name.
     * If two books have the same author, the tie is broken by the book title.
     * 
     * @return a sorted list of library books by author and book title.
     */
    public List<LibraryBook<Type>> getOrderedByAuthor() {
        ArrayList<LibraryBook<Type>> sortedList = new ArrayList<>(library);
        sortedList.sort(new AuthorComparator());
        return sortedList;
    }

    /**
     * Retrieves a list of overdue library books sorted by the due date, with the oldest due date first.
     * 
     * @return a sorted list of overdue library books by due date.
     */
    public List<LibraryBook<Type>> getOverdueList() {
        ArrayList<LibraryBook<Type>> overdueList = new ArrayList<>();

        for (LibraryBook<Type> book : library) { // Corrected to 'library'
            GregorianCalendar dueDate = book.getDueDate();
            if (dueDate != null && dueDate.before(new GregorianCalendar())) {
                overdueList.add(book);
            }
        }

        overdueList.sort(new DueDateComparator());
        return overdueList;
    }

    /**
     * Comparator that defines an ordering among library books using the author,
     * and book title as a tie-breaker.
     */
    protected class AuthorComparator implements Comparator<LibraryBook<Type>> {
        @Override
        public int compare(LibraryBook<Type> book1, LibraryBook<Type> book2) {
            int authorComparison = book1.getAuthor().compareTo(book2.getAuthor());
            if (authorComparison != 0) {
                return authorComparison;
            }
            return book1.getTitle().compareTo(book2.getTitle());
        }
    }

    /**
     * Comparator that defines an ordering among library books using the due date.
     */
    protected class DueDateComparator implements Comparator<LibraryBook<Type>> {
        @Override
        public int compare(LibraryBook<Type> book1, LibraryBook<Type> book2) {
            GregorianCalendar dueDate1 = book1.getDueDate();
            GregorianCalendar dueDate2 = book2.getDueDate();

            // Handle null due dates
            if (dueDate1 == null && dueDate2 == null) {
                return 0;
            }
            if (dueDate1 == null) {
                return 1; // Null due dates are considered "greater" (not overdue)
            }
            if (dueDate2 == null) {
                return -1; // Null due dates are considered "greater" (not overdue)
            }
            return dueDate1.compareTo(dueDate2);
        }
    }

    /**
     * Comparator that defines an ordering among library books using the ISBN.
     */
    protected class IsbnComparator implements Comparator<LibraryBook<Type>> {
        public int compare(LibraryBook<Type> book1, LibraryBook<Type> book2) {
            return Long.compare(book1.getIsbn(), book2.getIsbn());
        }
    }
}


