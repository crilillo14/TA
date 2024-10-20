package lab04;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Testing class for Library.
 * This class performs various tests on the library system.
 * 
 */
public class LibraryTest {

  public static void main(String[] args) {
    // Create an empty library and perform various tests

    // Initialize a generic library with String as the holder type
    Library<String> lib = new Library<>();

    // Test an empty library
    // Lookup by ISBN on an empty library
    if (lib.lookup(978037429279L) != null)
      System.err.println("TEST FAILED -- empty library: lookup(isbn)");
    
    // Lookup by holder on an empty library
    ArrayList<LibraryBook<String>> booksCheckedOut = lib.lookup("Jane Doe");
    
    if (booksCheckedOut == null || booksCheckedOut.size() != 0)
      System.err.println("TEST FAILED -- empty library: lookup(holder)");
    
    // Test checkout on an empty library
    if (lib.checkout(978037429279L, "Jane Doe", 1, 1, 2008))
      System.err.println("TEST FAILED -- empty library: checkout");
    
    // Test checkin by ISBN on an empty library
    if (lib.checkin(978037429279L))
      System.err.println("TEST FAILED -- empty library: checkin(isbn)");
    
    // Test checkin by holder on an empty library
    if (lib.checkin("Jane Doe"))
      System.err.println("TEST FAILED -- empty library: checkin(holder)");

    // Test a small library
    // Adding books to the library
    lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib.add(9780446580342L, "David Baldacci", "Simple Genius");

    // Test lookup by ISBN (before checkout)
    if (lib.lookup(9780330351690L) != null)
      System.err.println("TEST FAILED -- small library: lookup(isbn)");    
    
    // Test checkout of a book
    if (!lib.checkout(9780330351690L, "Jane Doe", 1, 1, 2008))
      System.err.println("TEST FAILED -- small library: checkout");
    
    // Test lookup by holder after checkout
    booksCheckedOut = lib.lookup("Jane Doe");
        
    if (booksCheckedOut == null
        || booksCheckedOut.size() != 1
        || !booksCheckedOut.get(0).equals(
            new Book(9780330351690L, "Jon Krakauer", "Into the Wild"))
        || !booksCheckedOut.get(0).getHolder().equals("Jane Doe")
        || !booksCheckedOut.get(0).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1))) {
      System.err.println("TEST FAILED -- small library: lookup(holder)");
    }
    
    // Test checkin by ISBN
    if (!lib.checkin(9780330351690L))
      System.err.println("TEST FAILED -- small library: checkin(isbn)");
    
    // Test checkin by holder (should fail, no books checked out)
    if (lib.checkin("Jane Doe"))
      System.err.println("TEST FAILED -- small library: checkin(holder)");

    // Test adding multiple books from a file (Mushroom_Publishing.txt)
    lib.addAll("Mushroom_Publishing.txt");

    // Custom tests for assignment
    // For example, you can add more tests to check sorting by ISBN, author, etc.
    // Test getInventoryList (sorted by ISBN)
    ArrayList<LibraryBook<String>> sortedByISBN = lib.getInventoryList();
    for (LibraryBook<String> book : sortedByISBN) {
      System.out.println("Sorted by ISBN: " + book.getIsbn() + " - " + book.getTitle());
    }

    // Test getOrderedByAuthor (sorted by author)
    ArrayList<LibraryBook<String>> sortedByAuthor = lib.getOrderedByAuthor();
    for (LibraryBook<String> book : sortedByAuthor) {
      System.out.println("Sorted by Author: " + book.getAuthor() + " - " + book.getTitle());
    }

    // Test getOverdueList (sorted by due date)
    GregorianCalendar currentDate = new GregorianCalendar(2024, 1, 1); // Set current date
    ArrayList<LibraryBook<String>> overdueBooks = lib.getOverdueList(currentDate);
    for (LibraryBook<String> book : overdueBooks) {
      System.out.println("Overdue: " + book.getTitle() + " - Due on: " + book.getDueDate().getTime());
    }

    System.out.println("Testing done.");
  }
}
