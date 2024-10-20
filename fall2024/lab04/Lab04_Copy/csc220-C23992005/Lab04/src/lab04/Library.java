package lab04;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Comparator;
import java.util.List;

// Ask the TA to make sure if it is okay to use java.util.Comparator and java.util.List

/**
 * Class representation of a library (a collection of library books).
 * 
 */
public class Library<T> 
{ //TODO: Lab Part 2 Make the Library class generic (don't forget to update the holder)

  private ArrayList<LibraryBook<T>> library;

  public Library() 
  {
    library = new ArrayList<>();
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
  
  public void add(long isbn, String author, String title) 
  {
    library.add(new LibraryBook<>(isbn, author, title));
  }
  

  /**
   * Add the list of library books to the library, assume no duplicates.
   * 
   * @param list --
   *          list of library books to be added
   */
  public void addAll(ArrayList<LibraryBook<T>> list) 
  {
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
  public void addAll(String filename) 
  {
    ArrayList<LibraryBook<T>> toBeAdded = new ArrayList<>();

    try (Scanner fileIn = new Scanner(new File(filename)))
    {
      //Scanner fileIn = new Scanner(new File(filename));
      int lineNum = 1;

      while (fileIn.hasNextLine()) 
      {
        String line = fileIn.nextLine();
        try(Scanner lineIn = new Scanner(line))
        {
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

        }
        lineNum++;
      }
    } 
    catch (FileNotFoundException e) 
    {
      System.err.println(e.getMessage() + " Nothing added to the library.");
      return;
    } 
    catch (ParseException e) 
    {
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
  public T lookup(long isbn) 
  {
    // *FILL IN -- do not return null unless appropriate
	for (LibraryBook<T> book : library)
	{
		if (book.getIsbn() == isbn)
		{
			return book.getHolder();
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
  public ArrayList<LibraryBook<T>> lookup(T holder) 
  {
    // *FILL IN -- do not return null
	  ArrayList<LibraryBook<T>>  CheckedOutList = new ArrayList<>();
	  for (LibraryBook<T> book : library)
	  {
		  if (holder.equals(book.getHolder()))
		  {
			  CheckedOutList.add(book);
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
  public boolean checkout(long isbn, T holder, int month, int day, int year) 
  {
    // *FILL IN -- do not return false unless appropriate
	for (LibraryBook<T> book : library)
	{
		if (book.getIsbn() == isbn)
		{
			if (book.getHolder() != null)
			{
				return false;
			}
			else
			{
				GregorianCalendar dueDate = new GregorianCalendar(year, month, day);
				 
				book.checkout(holder, dueDate);
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
  public boolean checkin(long isbn) 
  {
    // *FILL IN -- do not return false unless appropriate
	  for (LibraryBook<T> book : library)
	  {
		  if (book.getIsbn() == isbn)
		  {
			  if (book.getHolder() == null)
			  {
				  return false;
			  }
			  else
			  {
				  book.checkin();
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
  public boolean checkin(T holder) 
  {
	    // *FILL IN -- do not return false unless appropriate	  
	boolean found = false;
	for (LibraryBook<T> book : library)
	{
		if (holder.equals(book.getHolder()))
		{
			book.checkin();
			found = true;
		}
	}
	return found;
  }


  // // TODO: Uncomment the code below for Lab part 4
    
  //  * Returns the list of library books, sorted by ISBN (smallest ISBN first).
 
       public ArrayList<LibraryBook<T>> getInventoryList() 
       {
    	   ArrayList<LibraryBook<T>> libraryCopy = new ArrayList<>(library);
    	   Collections.sort(libraryCopy, new IsbnComparator());
    	   return libraryCopy;
       }
    
  // /**
  //  * Performs a SELECTION SORT on the input ArrayList. 
  //  *    1. Find the smallest item in the list. 
  //  *    2. Swap the smallest item with the first item in the list. 
  //  *    3. Now let the list be the remaining unsorted portion 
  //  *       (second item to Nth item) and repeat steps 1, 2, and 3.
  //  */
       private static <ListType> void sort(ArrayList<ListType> list, Comparator<ListType> c) 
       {
    	   for (int i = 0; i < list.size() - 1; i++) 
    	   {
    		   int minIndex = i;
    		   for(int j = i + 1; j < list.size(); j++)
    		   {
    			   if(c.compare(list.get(j), list.get(minIndex)) < 0)
    			   {
    				   minIndex = j;
    			   }
    		   }
    		   
    		   if(minIndex != i)
    		   {
    			   ListType temp = list.get(i);
    			   list.set(i, list.get(minIndex));
    			   list.set(minIndex, temp);
    		   }
    	   }
       }



  // /**
  //  * Comparator that defines an ordering among library books using the ISBN.
  //  */
  // protected class IsbnComparator implements Comparator<LibraryBook<Type>> {

  // // TODO: Lab Part 4 - write the compare method
  // }
       
       protected class IsbnComparator implements Comparator<LibraryBook<T>>
       {
    	   public int compare(LibraryBook<T> book1, LibraryBook<T> book2)
    	   {
    		   return Long.compare(book1.getIsbn(), book2.getIsbn());
    	   }
       }

  //*********************************************************************
  // * you will implement the rest of the methods for your assignment    *
  // * don't touch them before finishing the lab portion                 *
  // *********************************************************************

  // /**
  //  * Retrieves a list of library books sorted by the author's full name.
  //  * If two books have the same author, the tie is broken by the book title.
  //  * 
  //  * The sorting is performed using the AuthorComparator class, which compares
  //  * the full author strings and then compares titles if the authors are the same.
  //  * 
  //  * @return a sorted list of library books by author and book title.
  //  */
       //public List<LibraryBook<T>> getOrderedByAuthor() 
       //{
    	   //ArrayList<LibraryBook<T>> libraryCopy = new ArrayList<>(library);
    	   //Collections.sort(libraryCopy, new AuthorComparator());
    	   //return libraryCopy;
       //}
       
       public List<LibraryBook<T>> getOrderedByAuthor() 
       {
    	    ArrayList<LibraryBook<T>> books = new ArrayList<>(library);
    	    sort(books, new Comparator<LibraryBook<T>>() 
    	    {
    	        public int compare(LibraryBook<T> book1, LibraryBook<T> book2) 
    	        {
    	            return book1.getAuthor().compareTo(book2.getAuthor());
    	        }
    	    });
    	    return books;
    	}



  // /**
  //  * Retrieves a list of overdue library books sorted by the due date, with the oldest due date first.
  //  * 
  //  * This method filters the library books to only include those that are overdue,
  //  * and then sorts them by the due date using the DueDateComparator class.
  //  * 
  //  * Be cautious of books with a null due date, as they may cause exceptions during comparison.
  //  * 
  //  * @return a sorted list of overdue library books by due date.
  //  */
      public List<LibraryBook<T>> getOverdueList() 
      {
         ArrayList<LibraryBook<T>> overdueBooks = new ArrayList<>();
         
         GregorianCalendar currentDate = new GregorianCalendar(); // Implementing current date for comparison
         
         // Checking for filtering overdue books, which are non-null due dates before the current date
         for(LibraryBook<T> book : library)
         {
        	 GregorianCalendar dueDate = book.getDueDate();
        	 if(dueDate != null && dueDate.before(currentDate))
        	 {
        		 overdueBooks.add(book);
        	 }
         }
         
         Collections.sort(overdueBooks,new DueDateComparator());
         return overdueBooks;
      }


  // /**
  //  * Comparator that defines an ordering among library books using the author, and book title as a tie-breaker.
  //  */
      protected class AuthorComparator implements Comparator<LibraryBook<T>> 
      {
    	  public int compare(LibraryBook<T> book1, LibraryBook<T> book2)
    	  {
    		  int authorComparison = book1.getAuthor().compareTo(book2.getAuthor()); // This is for comparing the authors first
    		  
    		  if(authorComparison == 0)
    		  {
    			  return book1.getTitle().compareTo(book2.getTitle());
    		  }
    		  
    		  return authorComparison;
    	  }
      }

  // /**
  //  * Comparator that defines an ordering among library books using the due date.
  //  */
      protected class DueDateComparator implements Comparator<LibraryBook<T>> 
      {
    	  public int compare(LibraryBook<T> book1, LibraryBook<T> book2)
    	  {
    		  // This just handles only null due dates (moving the books without a due date at the end of the list)
    		  if(book1.getDueDate() == null && book2.getDueDate() == null)
    		  {
    			  return 0;
    		  }
    		  if(book1.getDueDate() == null)
    		  {
    			  return 1;
    		  }
    		  if(book2.getDueDate() == null)
    		  {
    			  return -1;
    		  }
    		  
    		  // This is the last case in the method where you compare actual due dates
    		  return book1.getDueDate().compareTo(book2.getDueDate());
    		  
    	  }
      }


}
