package lab04;

import java.util.GregorianCalendar;

public class LibraryBook<Type> extends Book { //TODO: Lab Part 1 Make the LibraryBook class generic (don't forget to update the holder)
	Type holder; // Updated to use the generic type for holder
	GregorianCalendar dueDate;
	
	public LibraryBook(long isbn, String author, String title){
		super(isbn, author, title);
	}

	public Type getHolder(){ // Updated to return the generic type holder
		return holder;
	}
	
	public GregorianCalendar getDueDate(){
		return dueDate;
	}
	
	public void checkin(){
		// no late late comparison required
		// If a library book is checked in, its holder and due date should be set to null.		
		this.holder = null; // Updated to set the generic type holder to null
		this.dueDate = null;
	}
	
	public void checkout(Type holder, GregorianCalendar dueDate){ // Updated to accept a generic type for holder
		this.holder = holder; // Assign the holder directly, as it's of type Type
		this.dueDate = new GregorianCalendar(
				dueDate.get(GregorianCalendar.YEAR), 
				dueDate.get(GregorianCalendar.MONTH), 
				dueDate.get(GregorianCalendar.DATE));
		
	}	
	// Do not override the equals method in Book

}
