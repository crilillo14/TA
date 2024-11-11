package lab04;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 * Class representation of a library (a collection of library books).
 * 
 */
public class Library {

  private ArrayList<LibraryBook> library;

  public Library() {
    library = new ArrayList<LibraryBook>();
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
    library.add(new LibraryBook(isbn, author, title));
  }

  /**
   * Add the list of library books to the library, assume no duplicates.
   * 
   * @param list --
   *          list of library books to be added
   */
  public void addAll(ArrayList<LibraryBook> list) {
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
    ArrayList<LibraryBook> toBeAdded = new ArrayList<LibraryBook>();

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

        toBeAdded.add(new LibraryBook(isbn, author, title));

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
  public String lookup(long isbn) {
    for (LibraryBook book : library) {
      if (book.getIsbn() == isbn) {
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
  public ArrayList<LibraryBook> lookup(String holder) {
    ArrayList<LibraryBook> checkedOutList = new ArrayList<>();
    for (LibraryBook book : library) {
      if (holder.equals(book.getHolder())) {
        checkedOutList.add(book);
      }
    }
    return checkedOutList;
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
  public boolean checkout(long isbn, String holder, int month, int day, int year) {
    for (LibraryBook book : library) {
      if (book.getIsbn() == isbn) {
        if (book.getHolder() != null) {
          return false;
        }
        GregorianCalendar dueDate = new GregorianCalendar(year, month, day);
        book.checkout(holder, dueDate);
        return true;
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
    for (LibraryBook book : library) {
      if (book.getIsbn() == isbn) {
        if (book.getHolder() == null) {
          return false;
        }
        book.checkin();
        return true;
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
  public boolean checkin(String holder) {
    int count = 0;
    for (LibraryBook book : library) {
      if (holder.equals(book.getHolder())) {
        book.checkin();
        count++;
      }
    }
    return count > 0;
  }

  /**
   * Returns the list of library books, sorted by ISBN (smallest ISBN first).
   */
  public ArrayList<LibraryBook> getInventoryList() {
    ArrayList<LibraryBook> libraryCopy = new ArrayList<>(library);
    IsbnComparator comparator = new IsbnComparator();
    sort(libraryCopy, comparator);
    return libraryCopy;
  }

  /**
   * Performs a SELECTION SORT on the input ArrayList. 
   */
  private static <ListType> void sort(ArrayList<ListType> list, Comparator<ListType> c) {
    for (int i = 0; i < list.size() - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < list.size(); j++) {
        if (c.compare(list.get(j), list.get(minIndex)) < 0) {
          minIndex = j;
        }
      }
      ListType temp = list.get(i);
      list.set(i, list.get(minIndex));
      list.set(minIndex, temp);
    }
  }

  /**
   * Comparator that defines an ordering among library books using the ISBN.
   */
  protected class IsbnComparator implements Comparator<LibraryBook> {
    @Override
    public int compare(LibraryBook book1, LibraryBook book2) {
      return Long.compare(book1.getIsbn(), book2.getIsbn());
    }
  }

  /**
   * Retrieves a list of library books sorted by the author's full name.
   */
  public List<LibraryBook> getOrderedByAuthor() {
    ArrayList<LibraryBook> libraryCopy = new ArrayList<>(library);
    AuthorComparator comparator = new AuthorComparator();
    sort(libraryCopy, comparator);
    return libraryCopy;
  }

  /**
   * Comparator that defines an ordering among library books using the author,
   * and book title as a tie-breaker.
   */
  protected class AuthorComparator implements Comparator<LibraryBook> {
    @Override
    public int compare(LibraryBook book1, LibraryBook book2) {
      int authorCompare = book1.getAuthor().compareTo(book2.getAuthor());
      if (authorCompare != 0) {
        return authorCompare;
      } else {
        return book1.getTitle().compareTo(book2.getTitle());
      }
    }
  }

  /**
   * Retrieves a list of overdue library books sorted by the due date, with the oldest due date first.
   */
  public List<LibraryBook> getOverdueList() {
    ArrayList<LibraryBook> overdueBooks = new ArrayList<>();
    GregorianCalendar today = new GregorianCalendar();

    for (LibraryBook book : library) {
      if (book.getDueDate() != null && book.getDueDate().before(today)) {
        overdueBooks.add(book);
      }
    }

    DueDateComparator comparator = new DueDateComparator();
    sort(overdueBooks, comparator);

    return overdueBooks;
  }

  /**
   * Comparator that defines an
