package lab04;

import java.util.GregorianCalendar;

public class LibraryBook<T> extends Book 
{ //TODO: Lab Part 1 Make the LibraryBook class generic (don't forget to update the holder)
	private T holder;
	private GregorianCalendar dueDate;
	
	public LibraryBook(long isbn, String author, String title)
	{
		super(isbn, author, title);
	}

	public T getHolder()
	{
		return holder;
	}
	
	public void setHolder(T holder)
	{
		this.holder = holder;
	}
	
	public GregorianCalendar getDueDate()
	{
		return dueDate;
	}
	
	public void setDueDate(GregorianCalendar dueDate)
	{
		this.dueDate = dueDate;
	}
	
	public void checkin()
	{
		// If a library book is checked in, its holder and due date should be set to null.		
		this.holder = null;
		this.dueDate = null;
	}
	
	public void checkout(T holder, GregorianCalendar dueDate)
	{
		this.holder = holder;
		this.dueDate = new GregorianCalendar(
				dueDate.get(GregorianCalendar.YEAR), 
				dueDate.get(GregorianCalendar.MONTH), 
				dueDate.get(GregorianCalendar.DATE));
		
	}	
	// Do not override the equals method in Book

}
