package lab04;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Comparator;
import java.util.List;

/**
 * Class representation of a library (a collection of library books).
 * 
 */

public class Library<Type> { // Updated to make the class generic

  private ArrayList<LibraryBook<Type>> library; // Changed to ArrayList<LibraryBook<Type>>

  public Library() {
    library = new ArrayList<LibraryBook<Type>>(); // Changed to ArrayList<LibraryBook<Type>>
  }

  public void add(long isbn, String author, String title) {
    library.add(new LibraryBook<Type>(isbn, author, title)); // Changed to LibraryBook<Type>
  }
  
  public void addAll(ArrayList<LibraryBook<Type>> list) { // Changed to ArrayList<LibraryBook<Type>>
    library.addAll(list);
  }

  public void addAll(String filename) {
    ArrayList<LibraryBook<Type>> toBeAdded = new ArrayList<LibraryBook<Type>>(); // Changed to ArrayList<LibraryBook<Type>>

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

        toBeAdded.add(new LibraryBook<Type>(isbn, author, title)); // Changed to LibraryBook<Type>

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

  public Type lookup(long isbn) { // Changed return type from String to Type
    for (int i = 0; i < library.size(); i++){
      if (library.get(i).getIsbn() == isbn){
        return library.get(i).getHolder(); // Changed return type from String to Type
      }
    }
    return null;
  }

  public ArrayList<LibraryBook<Type>> lookup(Type holder) {
	    ArrayList<LibraryBook<Type>> checkedOutList = new ArrayList<>();
	    for (LibraryBook<Type> book : library) {
	        if (holder.equals(book.getHolder())) {
	            checkedOutList.add(book);
	        }
	    }
	    //System.out.println("Found " + checkedOutList.size() + " books checked out to " + holder);
	    return checkedOutList;
	}
  
  public boolean checkout(long isbn, Type holder, int month, int day, int year) {
	    //System.out.println("Attempting to checkout book with ISBN: " + isbn);
	    for (LibraryBook<Type> book : library) {
	        if (book.getIsbn() == isbn) {
	            if (book.getHolder() != null) {
	                //System.out.println("Book with ISBN " + isbn + " is already checked out.");
	                return false;
	            } else {
	                GregorianCalendar dueDate = new GregorianCalendar(year, month - 1, day);
	                book.checkout(holder, dueDate);
	                //System.out.println("Book with ISBN " + isbn + " checked out successfully to " + holder);
	                return true;
	            }
	        }
	    }
	    System.out.println("Book with ISBN " + isbn + " not found in the library");
	    return false;
	}

  public boolean checkin(long isbn) {
	    for (LibraryBook<Type> book : library) {
	        if (book.getIsbn() == isbn) {
	            if (book.getHolder() == null) {
	                return false;
	            } else {
	                book.checkin();
	                //System.out.println("Book with ISBN " + isbn + " checked in successfully");
	                return true;
	            }
	        }
	    }
	    return false;
	}

	public boolean checkin(Type holder) {
	    boolean anyCheckedIn = false;
	    for (LibraryBook<Type> book : library) {
	        if (holder.equals(book.getHolder())) {
	            book.checkin();
	            anyCheckedIn = true;
	            //System.out.println("Book with ISBN " + book.getIsbn() + " checked in successfully");
	        }
	    }
	    return anyCheckedIn;
	}
	
	
	public ArrayList<LibraryBook<Type>> getInventoryList() {
        ArrayList<LibraryBook<Type>> libraryCopy = new ArrayList<LibraryBook<Type>>(library);
        IsbnComparator comparator = new IsbnComparator();
        sort(libraryCopy, comparator);
        return libraryCopy;
    }

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

    protected class IsbnComparator implements Comparator<LibraryBook<Type>> {
        @Override
        public int compare(LibraryBook<Type> book1, LibraryBook<Type> book2) {
            return Long.compare(book1.getIsbn(), book2.getIsbn());
        }
    }

    public List<LibraryBook<Type>> getOrderedByAuthor() {
        ArrayList<LibraryBook<Type>> libraryCopy = new ArrayList<>(library);
        AuthorComparator comparator = new AuthorComparator();
        sort(libraryCopy, comparator);
        return libraryCopy;
    }
    
    public List<LibraryBook<Type>> getOverdueList() {
        ArrayList<LibraryBook<Type>> overdueBooks = new ArrayList<>();
        GregorianCalendar currentDate = new GregorianCalendar();

        for (LibraryBook<Type> book : library) {
            if (book.getDueDate() != null && book.getDueDate().compareTo(currentDate) < 0) {
                overdueBooks.add(book);
            }
        }

        DueDateComparator comparator = new DueDateComparator();
        sort(overdueBooks, comparator);
        return overdueBooks;
    }

    protected class AuthorComparator implements Comparator<LibraryBook<Type>> {
        @Override
        public int compare(LibraryBook<Type> book1, LibraryBook<Type> book2) {
            int authorComparison = book1.getAuthor().compareTo(book2.getAuthor());
            if (authorComparison == 0) {
                return book1.getTitle().compareTo(book2.getTitle());
            }
            return authorComparison;
        }
    }
    
    protected class DueDateComparator implements Comparator<LibraryBook<Type>> {
        @Override
        public int compare(LibraryBook<Type> book1, LibraryBook<Type> book2) {
            if (book1.getDueDate() == null && book2.getDueDate() == null) {
                return 0;
            } else if (book1.getDueDate() == null) {
                return 1;
            } else if (book2.getDueDate() == null) {
                return -1;
            }
            return book1.getDueDate().compareTo(book2.getDueDate());
        }
    }
}


	 

	  
	  
	  
	   

	   // /**
	   //  * Retrieves a list of library books sorted by the author's full name.
	   //  * If two books have the same author, the tie is broken by the book title.
	   //  * 
	   //  * The sorting is performed using the AuthorComparator class, which compares
	   //  * the full author strings and then compares titles if the authors are the same.
	   //  * 
	   //  * @return a sorted list of library books by author and book title.
	   //  */


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
	   


	   // /**
	   //  * Comparator that defines an ordering among library books using the author,  and book title as a tie-breaker.
	   //  */
	    

	   // /**
	   //  * Comparator that defines an ordering among library books using the due date.
	   //  */
	   
  /**
   * Class representation of a library (a collection of library books).
   * 
   */
  
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
  
  /**
   * Add the list of library books to the library, assume no duplicates.
   * 
   * @param list --
   *          list of library books to be added
   */
  
  /**
   * Add books specified by the input file. One book per line with ISBN, author,
   * and title separated by tabs.
   * 
   * If file does not exist or format is violated, do nothing.
   * 
   * @param filename
   */
  
  /**
   * Returns the holder of the library book with the specified ISBN.
   * If no book with the specified ISBN is in the library, returns null.
   * 
   * @param isbn --
   *          ISBN of the book to be looked up
   */
  
  /**
   * Returns the list of library books checked out to the specified holder.
   * 
   * If the specified holder has no books checked out, returns an empty list.
   * 
   * @param holder --
   *          holder whose checked out books are returned
   */
  
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
  
  /**
   * Unsets the holder and due date of the library book.
   * If no book with the specified ISBN is in the library, returns false.
   * If the book with the specified ISBN is already checked in, returns false.
   * Otherwise, returns true.
   * 
   * @param isbn --
   *          ISBN of the library book to be checked in
   */
  
  /**
   * Unsets the holder and due date for all library books checked out by the
   * specified holder.
   * If no books with the specified holder are in the library, returns false;
   * Otherwise, returns true.
   * 
   * @param holder --
   *          holder of the library books to be checked in
   */

