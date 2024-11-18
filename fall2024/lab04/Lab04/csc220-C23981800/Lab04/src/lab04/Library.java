package lab04;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Class representation of a library (a collection of library books).
 */
public class Library<Type> { // Making the Library class generic with Type for the holder

  protected ArrayList<LibraryBook<Type>> library; // The list now stores LibraryBook<Type>

  public Library() {
    library = new ArrayList<LibraryBook<Type>>();
  }

  /**
   * Add the specified book to the library, assume no duplicates.
   *
   * @param isbn -- ISBN of the book to be added
   * @param author -- author of the book to be added
   * @param title -- title of the book to be added
   */
  public void add(long isbn, String author, String title) {
    library.add(new LibraryBook<Type>(isbn, author, title)); // Add generic LibraryBook<Type>
  }

  /**
   * Add the list of library books to the library, assume no duplicates.
   *
   * @param list -- list of library books to be added
   */
  public void addAll(ArrayList<LibraryBook<Type>> list) { // List of generic LibraryBook<Type>
    library.addAll(list);
  }

  /**
   * Add books specified by the input file. One book per line with ISBN, author, and title separated by tabs.
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

        toBeAdded.add(new LibraryBook<Type>(isbn, author, title)); // Add generic LibraryBook<Type>

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
   * @param isbn -- ISBN of the book to be looked up
   */
  public Type lookup(long isbn) { // Return the holder of generic type
    for (LibraryBook<Type> book : library) {
      if (book.getIsbn() == isbn) {
        return book.getHolder(); // Return holder of type Type
      }
    }
    return null;
  }

  /**
   * Returns the list of library books checked out to the specified holder.
   * If the specified holder has no books checked out, returns an empty list.
   *
   * @param holder -- holder whose checked-out books are returned
   */
  public ArrayList<LibraryBook<Type>> lookup(Type holder) {
    ArrayList<LibraryBook<Type>> checkedOutList = new ArrayList<LibraryBook<Type>>();

    for (LibraryBook<Type> book : library) {
      if (holder.equals(book.getHolder())) {
        checkedOutList.add(book);
      }
    }

    return checkedOutList; // Return the list of LibraryBook<Type> checked out by the holder
  }

  /**
   * Sets the holder and due date of the library book with the specified ISBN.
   * If no book with the specified ISBN is in the library, returns false.
   * If the book with the specified ISBN is already checked out, returns false.
   * Otherwise, returns true.
   *
   * @param isbn -- ISBN of the library book to be checked out
   * @param holder -- new holder of the library book
   * @param month -- month of the new due date of the library book
   * @param day -- day of the new due date of the library book
   * @param year -- year of the new due date of the library book
   */
  public boolean checkout(long isbn, Type holder, int month, int day, int year) {
    for (LibraryBook<Type> book : library) {
      if (book.getIsbn() == isbn) {
        if (book.getHolder() != null) {
          return false;
        } else {
          GregorianCalendar dueDate = new GregorianCalendar(year, month, day);
          book.checkout(holder, dueDate); // Checkout using holder of type Type
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
   * @param isbn -- ISBN of the library book to be checked in
   */
  public boolean checkin(long isbn) {
    for (LibraryBook<Type> book : library) {
      if (book.getIsbn() == isbn) {
        if (book.getHolder() == null) {
          return false;
        } else {
          book.checkin();
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Unsets the holder and due date for all library books checked out by the specified holder.
   * If no books with the specified holder are in the library, returns false;
   * Otherwise, returns true.
   *
   * @param holder -- holder of the library books to be checked in
   */
  public boolean checkin(Type holder) {
    boolean found = false;
    for (LibraryBook<Type> book : library) {
      if (holder.equals(book.getHolder())) {
        book.checkin();
        found = true;
      }
    }
    return found;
  }
}
