package lab04;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

/**
 * Class representation of a library (a collection of library books).
 * 
 */
public class Library<Type> { //TODO: Lab Part 2 Make the Library class generic (don't forget to update the holder)

  private ArrayList<LibraryBook<Type>> library;

  public Library() {
    library = new ArrayList<LibraryBook<Type>>();
  }

  /**
   * Add the specified book to the library, assume no duplicates.
   * 
   * @param isbn --
   *          ISBN of the book to be added
   * @param author --
   *          author of the book to be added
   * @param title --
   *          title of the book to be added
   */
  public void add(long isbn, String author, String title) {
    library.add(new LibraryBook<Type>(isbn, author, title));
  }
  

  /**
   * Add the list of library books to the library, assume no duplicates.
   * 
   * @param list --
   *          list of library books to be added
   */
  public void addAll(ArrayList<LibraryBook<Type>> list) {
    library.addAll(list);
  }

  /**
   * Add books specified by the input file. One book per line with ISBN, author,
   * and title separated by tabs.
   * 
   * If file does not exist or format is violated, do nothing.
   * 
   * @param filename
   */
  public void addAll(String filename) {
    ArrayList<LibraryBook<Type>> toBeAdded = new ArrayList<LibraryBook<Type>>();

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

  /**
   * Returns the holder of the library book with the specified ISBN.
   * If no book with the specified ISBN is in the library, returns null.
   * 
   * @param isbn --
   *          ISBN of the book to be looked up
   */
  public Type lookup(long isbn) {
    // *FILL IN -- do not return null unless appropriate
	for (int i = 0; i < library.size(); i++){
		if (library.get(i).getIsbn() == isbn){
			return library.get(i).getHolder();
		}
	}
    return null;
  }

  /**
   * Returns the list of library books checked out to the specified holder.
   * 
   * If the specified holder has no books checked out, returns an empty list.
   * 
   * @param holder --
   *          holder whose checked out books are returned
   */
  public ArrayList<LibraryBook<Type>> lookup(Type holder) {
    // *FILL IN -- do not return null
	  ArrayList<LibraryBook<Type>>  CheckedOutList = new ArrayList<LibraryBook<Type>>();
	  if (library.size() == 0)
		  return CheckedOutList;
	  for (int i = 0; i < library.size(); i++){
		  Type BookHolder = library.get(i).getHolder();
		  if (holder.equals(BookHolder)){
			  CheckedOutList.add(library.get(i));
		  }
	  }
	  
     // ** according to javadoc, should never return null **
	 // if (CheckedOutList.size() == 0)
	 //	  return null;
    
	 return CheckedOutList;
  }

  /**
   * Sets the holder and due date of the library book with the specified ISBN.
   * If no book with the specified ISBN is in the library, returns false.
   * If the book with the specified ISBN is already checked out, returns false.
   * Otherwise, returns true.
   * 
   * @param isbn --
   *          ISBN of the library book to be checked out
   * @param holder --
   *          new holder of the library book
   * @param month --
   *          month of the new due date of the library book
   * @param day --
   *          day of the new due date of the library book
   * @param year --
   *          year of the new due date of the library book
   */
  public boolean checkout(long isbn, Type holder, int month, int day, int year) {
    // *FILL IN -- do not return false unless appropriate
	for (int i = 0; i < library.size(); i++){
		if (library.get(i).getIsbn() == isbn){
			if (library.get(i).getHolder() != null){
				return false;
			}else{
				GregorianCalendar dueDate = new GregorianCalendar(year, month, day);
				 
				library.get(i).checkout(holder, dueDate);
				return true;
			}
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
   * @param isbn --
   *          ISBN of the library book to be checked in
   */
  public boolean checkin(long isbn) {
    // *FILL IN -- do not return false unless appropriate
	  for (int i = 0; i < library.size(); i++){
		  if (library.get(i).getIsbn() == isbn){
			  if (library.get(i).getHolder() == null){
				  return false;
			  }else{
				  library.get(i).checkin();
				  return true;
			  }
		  }
	  }
    return false;
  }

  /**
   * Unsets the holder and due date for all library books checked out by the
   * specified holder.
   * If no books with the specified holder are in the library, returns false;
   * Otherwise, returns true.
   * 
   * @param holder --
   *          holder of the library books to be checked in
   */
  public boolean checkin(Type holder) {
	    // *FILL IN -- do not return false unless appropriate	  
	int counter = 0;
	for (int i = 0; i < library.size(); i++){
		if (holder.equals(library.get(i).getHolder())){
			counter++;
			library.get(i).checkin();
		}
	}
	
	if (counter > 0)
		return true;
	
    return false;
  }

  // TODO: Uncomment the code below for Lab part 4
    
  /**
  * Returns the list of library books, sorted by ISBN (smallest ISBN first).
  */
  	public ArrayList<LibraryBook<Type>> getInventoryList() {
	  ArrayList<LibraryBook<Type>> libraryCopy = new ArrayList<LibraryBook<Type>>();
	  libraryCopy.addAll(library);

	  IsbnComparator comparator = new IsbnComparator();

	  sort(libraryCopy, comparator);

	  return libraryCopy;
  	}
    
   /**
    * Performs a SELECTION SORT on the input ArrayList. 
    *    1. Find the smallest item in the list. 
    *    2. Swap the smallest item with the first item in the list. 
    *    3. Now let the list be the remaining unsorted portion 
    *       (second item to Nth item) and repeat steps 1, 2, and 3.
    */
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
    * Comparator that defines an ordering among library books using the ISBN.
    */
   protected class IsbnComparator implements Comparator<LibraryBook<Type>> {

	@Override
	public int compare(LibraryBook<Type> book1, LibraryBook<Type> book2) {
		
		return (int)(book1.getIsbn() - book2.getIsbn());
	}
	   
	   // TODO: Lab Part 4 - write the compare method
   }

  //*********************************************************************
  // * you will implement the rest of the methods for your assignment    *
  // * don't touch them before finishing the lab portion                 *
  // *********************************************************************

   /**
    * Retrieves a list of library books sorted by the author's full name.
    * If two books have the same author, the tie is broken by the book title.
    * 
    * The sorting is performed using the AuthorComparator class, which compares
    * the full author strings and then compares titles if the authors are the same.
    * 
    * @return a sorted list of library books by author and book title.
    */
   public List<LibraryBook<Type>> getOrderedByAuthor() {
	// TODO Assignment part 1
	   ArrayList<LibraryBook<Type>> libraryCopy = new ArrayList<LibraryBook<Type>>();
	   libraryCopy.addAll(library);

	   AuthorComparator comparator = new AuthorComparator();

	   sort(libraryCopy, comparator);

	   return libraryCopy;	   
   }


//   /**
//    * Retrieves a list of overdue library books sorted by the due date, with the oldest due date first.
//    * 
//    * This method filters the library books to only include those that are overdue,
//    * and then sorts them by the due date using the DueDateComparator class.
//    * 
//    * Be cautious of books with a null due date, as they may cause exceptions during comparison.
//    * 
//    * @return a sorted list of overdue library books by due date.
//    */
   public List<LibraryBook<Type>> getOverdueList() {
       // TODO Assignment part 2
	   ArrayList<LibraryBook<Type>> overdueBooks = new ArrayList<LibraryBook<Type>>();
	   
	   GregorianCalendar today = (GregorianCalendar) Calendar.getInstance();  
	   	   
	   for(int i = 0; i < library.size(); i++) {
		   if(library.get(i).getDueDate() != null && library.get(i).getDueDate().compareTo(today) < 0) {
			   overdueBooks.add(library.get(i));
		   }
	   }
	   
	   DueDateComparator comparator = new DueDateComparator();

	   sort(overdueBooks, comparator);

	   return overdueBooks;	      
   }


   /**
    * Comparator that defines an ordering among library books using the author,  and book title as a tie-breaker.
    */
   protected class AuthorComparator implements Comparator<LibraryBook<Type>> {

	@Override
		public int compare(LibraryBook<Type> book1, LibraryBook<Type> book2) {
			// TODO: Assignment Part 1
			if ((int)(book1.getAuthor().compareTo(book2.getAuthor())) == 0) {
				return (int)(book1.getTitle().compareTo(book2.getTitle()));
			}
			return (int)(book1.getAuthor().compareTo(book2.getAuthor())); 
		}
   	}

   /**
    * Comparator that defines an ordering among library books using the due date.
    */
   protected class DueDateComparator implements Comparator<LibraryBook<Type>> {
	   // TODO: Assignment Part 2
	   @Override
	   public int compare(LibraryBook<Type> book1, LibraryBook<Type> book2) {
		   // TODO Auto-generated method stub
		   return (int)(book1.getDueDate().compareTo(book2.getDueDate()));
	   }
   }
}
