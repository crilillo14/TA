package lab04;

import java.util.GregorianCalendar;

public class LibraryBook<Type> extends Book { // Making the class generic with Type for the holder
    Type holder;  // holder is now of generic type
    GregorianCalendar dueDate;

    public LibraryBook(long isbn, String author, String title) {
        super(isbn, author, title);
    }

    public Type getHolder() {
        return holder;  // Return the generic type holder
    }

    public GregorianCalendar getDueDate() {
        return dueDate;
    }

    public void checkin() {
        // If a library book is checked in, its holder and due date should be set to null.
        this.holder = null;
        this.dueDate = null;
    }

    public void checkout(Type holder, GregorianCalendar dueDate) {
        this.holder = holder;  // Assign the holder of generic type
        this.dueDate = new GregorianCalendar(
            dueDate.get(GregorianCalendar.YEAR),
            dueDate.get(GregorianCalendar.MONTH),
            dueDate.get(GregorianCalendar.DATE)
        );
    }

    // Additional methods can still work with Strings where necessary.
}
