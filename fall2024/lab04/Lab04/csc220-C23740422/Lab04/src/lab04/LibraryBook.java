package lab04;

import java.util.GregorianCalendar;

public class LibraryBook<Type> extends Book { // Lab Part 1: Make the LibraryBook class generic

	private Type holder; // Generic holder
	private GregorianCalendar dueDate;

	public LibraryBook(long isbn, String author, String title) {
		super(isbn, author, title);
	}

	// Get the holder
	public Type getHolder() {
		return holder;
	}

	// Get the due date
	public GregorianCalendar getDueDate() {
		return dueDate;
	}

	// Check in the book, set holder and due date to null
	public void checkin() {
		this.holder = null;
		this.dueDate = null;
	}

	// Check out the book, setting the holder and due date
	public void checkout(Type holder, GregorianCalendar dueDate) {
		this.holder = holder;
		this.dueDate = new GregorianCalendar(
				dueDate.get(GregorianCalendar.YEAR),
				dueDate.get(GregorianCalendar.MONTH),
				dueDate.get(GregorianCalendar.DATE));
	}
	// No need to override equals, as instructed
}
