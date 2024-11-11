package lab04;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Class representation of a library (a collection of library books).
 */
public class Library<Type> {

    private ArrayList<LibraryBook<Type>> library;

    public Library() {
        library = new ArrayList<>();
    }

    /**
     * Add the specified book to the library, assume no duplicates.
     *
     * @param isbn    ISBN of the book to be added
     * @param author  author of the book to be added
     * @param title   title of the book to be added
     */
    public void add(long isbn, String author, String title) {
        library.add(new LibraryBook<Type>(isbn, author, title));
    }

    /**
     * Add the list of library books to the library, assume no duplicates.
     *
     * @param list list of library books to be added
     */
    public void addAll(ArrayList<LibraryBook<Type>> list) {
        library.addAll(list);
    }

    /**
     * Add books specified by the input file. One book per line with ISBN, author,
     * and title separated by tabs. If file does not exist or format is violated,
     * do nothing.
     *
     * @param filename the name of the file to be read
     */
    public void addAll(String filename) {
        ArrayList<LibraryBook<Type>> toBeAdded = new ArrayList<>();

        try {
            File file = new File(filename);
            if (!file.exists()) {
                System.err.println("Error: File not found");
                return;
            }

            Scanner fileIn = new Scanner(file);
            int lineNum = 1;

            while (fileIn.hasNextLine()) {
                String line = fileIn.nextLine();
                Scanner lineIn = new Scanner(line).useDelimiter("\\t");

                if (!lineIn.hasNextLong()) {
                    System.err.println("Error: ISBN not found" + lineNum);
                    continue; 
                }
                long isbn = lineIn.nextLong();

                if (!lineIn.hasNext()) {
                    System.err.println("Error: Author not found" + lineNum);
                    continue;
                }
                String author = lineIn.next();

                if (!lineIn.hasNext()) {
                    System.err.println("Error: Title not found" + lineNum);
                    continue;
                }
                String title = lineIn.next();

                toBeAdded.add(new LibraryBook<Type>(isbn, author, title));
                lineNum++;
            }

            library.addAll(toBeAdded);
            fileIn.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found");
        }
    }

    /**
     * Returns the holder of the library book with the specified ISBN.
     * If no book with the specified ISBN is in the library, returns null.
     *
     * @param isbn ISBN of the book to be looked up
     */
    public Type lookup(long isbn) {
        for (LibraryBook<Type> book : library) {
            if (book.getIsbn() == isbn) {
                return book.getHolder();
            }
        }
        return null;
    }

    /**
     * Returns the list of library books checked out to the specified holder.
     * If the specified holder has no books checked out, returns an empty list.
     *
     * @param holder holder whose checked out books are returned
     */
    public ArrayList<LibraryBook<Type>> lookup(Type holder) {
        ArrayList<LibraryBook<Type>> checkedOutBooks = new ArrayList<>();
        for (LibraryBook<Type> book : library) {
            if (holder.equals(book.getHolder())) {
                checkedOutBooks.add(book);
            }
        }
        return checkedOutBooks;
    }

    /**
     * Sets the holder and due date of the library book with the specified ISBN.
     * If no book with the specified ISBN is in the library, returns false.
     * If the book with the specified ISBN is already checked out, returns false.
     * Otherwise, returns true.
     *
     * @param isbn   ISBN of the library book to be checked out
     * @param holder new holder of the library book
     * @param month  month of the new due date of the library book
     * @param day    day of the new due date of the library book
     * @param year   year of the new due date of the library book
     */
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

    /**
     * Unsets the holder and due date of the library book.
     * If no book with the specified ISBN is in the library, returns false.
     * If the book with the specified ISBN is already checked in, returns false.
     * Otherwise, returns true.
     *
     * @param isbn ISBN of the library book to be checked in
     */
    public boolean checkin(long isbn) {
        for (LibraryBook<Type> book : library) {
            if (book.getIsbn() == isbn && book.getHolder() != null) {
                book.checkin();
                return true;
            }
        }
        return false;
    }

    /**
     * Unsets the holder and due date for all library books checked out by the
     * specified holder. If no books with the specified holder are in the library,
     * returns false; Otherwise, returns true.
     *
     * @param holder holder of the library books to be checked in
     */
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

    // Method to return the sorted list of books by ISBN
    public ArrayList<LibraryBook<Type>> getInventoryList() {
        ArrayList<LibraryBook<Type>> libraryCopy = new ArrayList<>(library);
        IsbnComparator comparator = new IsbnComparator();
        sort(libraryCopy, comparator);
        return libraryCopy;
    }

    // Method to return the sorted list of books by author and title
    public ArrayList<LibraryBook<Type>> getOrderedByAuthor() {
        ArrayList<LibraryBook<Type>> libraryCopy = new ArrayList<>(library);
        AuthorComparator comparator = new AuthorComparator();
        sort(libraryCopy, comparator);
        return libraryCopy;
    }

    // Method to return the list of overdue books ordered by due date (oldest first)
    public ArrayList<LibraryBook<Type>> getOverdueList(GregorianCalendar currentDate) {
        ArrayList<LibraryBook<Type>> overdueBooks = new ArrayList<>();
        for (LibraryBook<Type> book : library) {
            if (book.getDueDate() != null && book.getDueDate().before(currentDate)) {
                overdueBooks.add(book);
            }
        }
        DueDateComparator comparator = new DueDateComparator();
        sort(overdueBooks, comparator);
        return overdueBooks;
    }

    // Selection sort method
    private static <ListType> void sort(ArrayList<ListType> list, Comparator<ListType> c) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (c.compare(list.get(j), list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            ListType temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }

    // Comparator to compare LibraryBooks by ISBN
    protected class IsbnComparator implements Comparator<LibraryBook<Type>> {
        @Override
        public int compare(LibraryBook<Type> b1, LibraryBook<Type> b2) {
            return Long.compare(b1.getIsbn(), b2.getIsbn());
        }
    }

    // Comparator to compare LibraryBooks by Author (and Title to break ties)
    protected class AuthorComparator implements Comparator<LibraryBook<Type>> {
        @Override
        public int compare(LibraryBook<Type> b1, LibraryBook<Type> b2) {
            int authorCompare = b1.getAuthor().compareTo(b2.getAuthor());
            if (authorCompare != 0) {
                return authorCompare;
            } else {
                return b1.getTitle().compareTo(b2.getTitle());
            }
        }
    }

    // Comparator to compare LibraryBooks by Due Date
    protected class DueDateComparator implements Comparator<LibraryBook<Type>> {
        @Override
        public int compare(LibraryBook<Type> b1, LibraryBook<Type> b2) {
            if (b1.getDueDate() == null) return 1;
            if (b2.getDueDate() == null) return -1;
            return b1.getDueDate().compareTo(b2.getDueDate());
        }
    }
}
