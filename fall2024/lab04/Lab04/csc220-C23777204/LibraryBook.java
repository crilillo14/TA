package lab03;

import java.util.GregorianCalendar; // Import GregorianCalendar

/**
 * A LibraryBook is a subclass of Book that contains a holder (a String) and a due date
 * represented by a GregorianCalendar.
 */
public class LibraryBook extends Book { // Extend Book class

    // Fields for holder and due date
    private String holder;
    private GregorianCalendar dueDate;

    /**
     * Constructs a LibraryBook with the specified ISBN, author, and title.
     *
     * @param isbn   The ISBN number of the book.
     * @param author The author of the book.
     * @param title  The title of the book.
     */
    public LibraryBook(long isbn, String author, String title) {
        super(isbn, author, title); // Call superclass constructor
        this.holder = null; // Initially, no one is holding the book
        this.dueDate = null; // Initially, there is no due date
    }

    /**
     * Returns the holder of the library book.
     *
     * @return A String representing the holder of the book, or null if the book is not checked out.
     */
    public String getHolder() {
        return this.holder;
    }
    
    /**
     * Returns the due date of the library book.
     *
     * @return A GregorianCalendar object representing the due date of the book, or null if the book is not checked out.
     */
    public GregorianCalendar getDueDate() {
        return this.dueDate;
    }
    
    /**
     * Checks in the library book by setting the holder and due date to null.
     */
    public void checkin() {
        this.holder = null;
        this.dueDate = null;
    }
    
    /**
     * Checks out the library book by setting the holder and due date to the specified values.
     *
     * @param holder   The name of the person who is checking out the book.
     * @param dueDate  The due date for the book's return.
     */
    public void checkout(String holder, GregorianCalendar dueDate){
        this.holder = holder;
        this.dueDate = dueDate;
    }	
}