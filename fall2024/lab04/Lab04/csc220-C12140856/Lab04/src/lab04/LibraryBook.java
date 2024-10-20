package lab04;

import java.util.GregorianCalendar;

/**
 * A LibraryBook is a subclass of Book that contains a holder (a generic Type) and a due date
 * represented by a GregorianCalendar.
 *
 * @param <Type> The type of the holder (e.g., String for names, PhoneNumber for phone numbers)
 */
public class LibraryBook<Type> extends Book {
    private Type holder;  // Holder is now generic
    private GregorianCalendar dueDate;

    /**
     * Constructs a LibraryBook with the specified ISBN, author, and title.
     *
     * @param isbn   The ISBN number of the book.
     * @param author The author of the book.
     * @param title  The title of the book.
     */
    public LibraryBook(long isbn, String author, String title) {
        super(isbn, author, title);
        this.holder = null;
        this.dueDate = null;
    }

    /**
     * Returns the holder of the library book.
     *
     * @return The holder of the book, or null if the book is not checked out.
     */
    public Type getHolder() {
        return holder;
    }

    /**
     * Returns the due date of the library book.
     *
     * @return The due date of the book, or null if the book is not checked out.
     */
    public GregorianCalendar getDueDate() {
        return dueDate;
    }

    /**
     * Checks in the library book by setting the holder and due date to null.
     */
    public void checkin() {
        this.holder = null;
        this.dueDate = null;
    }

    /**
     * Checks out the library book by setting the holder and due date.
     *
     * @param holder  The new holder of the book (generic Type).
     * @param dueDate The new due date for the book's return.
     */
    public void checkout(Type holder, GregorianCalendar dueDate) {
        this.holder = holder;
        this.dueDate = new GregorianCalendar(
                dueDate.get(GregorianCalendar.YEAR),
                dueDate.get(GregorianCalendar.MONTH),
                dueDate.get(GregorianCalendar.DAY_OF_MONTH));
    }
}

