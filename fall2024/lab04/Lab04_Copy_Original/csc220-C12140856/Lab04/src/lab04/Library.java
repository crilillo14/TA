package lab04;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * A Library is a collection of LibraryBooks where each book can be checked in and out.
 * The type of the holder is generic to allow flexibility in holder representation.
 *
 * @param <Type> The type of the holder (e.g., String for names, PhoneNumber for phone numbers)
 */
public class Library<Type> {
    private ArrayList<LibraryBook<Type>> library;

    /**
     * Constructs an empty library.
     */
    public Library() {
        library = new ArrayList<>();
    }

    /**
     * Adds a new book to the library.
     *
     * @param isbn   The ISBN number of the book.
     * @param author The author of the book.
     * @param title  The title of the book.
     */
    public void add(long isbn, String author, String title) {
        library.add(new LibraryBook<Type>(isbn, author, title));
    }

    /**
     * Adds books specified by the input file. One book per line with ISBN, author,
     * and title separated by tabs.
     * 
     * @param filename The name of the file to load the books from.
     */
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

                toBeAdded.add(new LibraryBook<Type>(isbn, author, title));

                lineNum++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        } catch (ParseException e) {
            System.err.println(e.getLocalizedMessage() + " formatted incorrectly at line " + e.getErrorOffset());
        }

        library.addAll(toBeAdded);
    }

    /**
     * Returns the holder of the library book with the specified ISBN.
     * If no book with the specified ISBN is in the library, returns null.
     *
     * @param isbn The ISBN of the book to look up.
     * @return The holder of the book, or null if no book is found or the book is not checked out.
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
     * @param holder The holder whose checked-out books are returned.
     * @return A list of books checked out by the specified holder, or an empty list if none are checked out.
     */
    public ArrayList<LibraryBook<Type>> lookup(Type holder) {
        ArrayList<LibraryBook<Type>> booksCheckedOut = new ArrayList<>();
        for (LibraryBook<Type> book : library) {
            if (holder.equals(book.getHolder())) {
                booksCheckedOut.add(book);
            }
        }
        return booksCheckedOut;
    }

    /**
     * Checks out the library book with the specified ISBN to the specified holder and due date.
     * If the book is already checked out or the ISBN is not found, returns false.
     *
     * @param isbn   The ISBN of the book to check out.
     * @param holder The holder checking out the book.
     * @param month  The month of the due date.
     * @param day    The day of the due date.
     * @param year   The year of the due date.
     * @return True if the book was successfully checked out, false otherwise.
     */
    public boolean checkout(long isbn, Type holder, int month, int day, int year) {
        for (LibraryBook<Type> book : library) {
            if (book.getIsbn() == isbn) {
                if (book.getHolder() == null) {
                    book.checkout(holder, new GregorianCalendar(year, month, day));
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks in the library book with the specified ISBN.
     * If the book is not found or already checked in, returns false.
     *
     * @param isbn The ISBN of the book to check in.
     * @return True if the book was successfully checked in, false otherwise.
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
     * Checks in all books checked out by the specified holder.
     * If no books are found, returns false. Otherwise, returns true.
     *
     * @param holder The holder of the books to check in.
     * @return True if any books were checked in, false otherwise.
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

    /**
     * Returns the list of library books, sorted by ISBN (smallest ISBN first).
     */
    public ArrayList<LibraryBook<Type>> getInventoryList() {
        ArrayList<LibraryBook<Type>> libraryCopy = new ArrayList<>(library);
        IsbnComparator comparator = new IsbnComparator();
        sort(libraryCopy, comparator);
        return libraryCopy;
    }

    /**
     * Returns the list of library books, sorted by author (alphabetical order).
     * If two books have the same author, the tie is broken by the book title.
     */
    public ArrayList<LibraryBook<Type>> getOrderedByAuthor() {
        ArrayList<LibraryBook<Type>> libraryCopy = new ArrayList<>(library);
        AuthorComparator comparator = new AuthorComparator();
        sort(libraryCopy, comparator);
        return libraryCopy;
    }

    /**
     * Returns the list of overdue library books, sorted by due date (earliest first).
     * 
     * @param currentDate The current date for determining overdue books.
     * @return A list of overdue books.
     */
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

    /**
     * Performs a SELECTION SORT on the input ArrayList.
     */
    private static <ListType> void sort(ArrayList<ListType> list, Comparator<ListType> c) {
        for (int i = 0; i < list.size() - 1; i++) {
            int j, minIndex;
            for (j = i + 1, minIndex = i; j < list.size(); j++) {
                if (c.compare(list.get(j), list.get(minIndex)) < 0)
                    minIndex = j;
            }
            ListType temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }

    // Comparators
    protected class IsbnComparator implements Comparator<LibraryBook<Type>> {
        @Override
        public int compare(LibraryBook<Type> book1, LibraryBook<Type> book2) {
            return Long.compare(book1.getIsbn(), book2.getIsbn());
        }
    }

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

    protected class DueDateComparator implements Comparator<LibraryBook<Type>> {
        @Override
        public int compare(LibraryBook<Type> book1, LibraryBook<Type> book2) {
            return book1.getDueDate().compareTo(book2.getDueDate());
        }
    }
}
