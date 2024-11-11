package lab04;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Testing class for generic Library.
 *
 */
public class LibraryGenericTest {

  public static void main(String[] args) {

    // Existing tests for checking out books
    testBasicCheckoutAndLookup();

    // Additional tests
    testGetInventoryList();
    testGetOrderedByAuthor();
    testGetOverdueList();

    System.out.println("All tests complete.");
  }

  public static void testBasicCheckoutAndLookup() {
    // Test a library that uses names (String) to id patrons
    Library<String> lib1 = new Library<String>();
    lib1.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib1.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib1.add(9780446580342L, "David Baldacci", "Simple Genius");

    String patron1 = "Jane Doe";

    if (!lib1.checkout(9780330351690L, patron1, 1, 1, 2008))
      System.err.println("TEST FAILED: first checkout");
    if (!lib1.checkout(9780374292799L, patron1, 1, 1, 2008))
      System.err.println("TEST FAILED: second checkout");
    ArrayList<LibraryBook<String>> booksCheckedOut1 = lib1.lookup(patron1);
    if (booksCheckedOut1 == null
        || booksCheckedOut1.size() != 2
        || !booksCheckedOut1.contains(new Book(9780330351690L, "Jon Krakauer", "Into the Wild"))
        || !booksCheckedOut1.contains(new Book(9780374292799L, "Thomas L. Friedman", "The World is Flat"))
        || !booksCheckedOut1.get(0).getHolder().equals(patron1)
        || !booksCheckedOut1.get(0).getDueDate().equals(new GregorianCalendar(2008, 1, 1))
        || !booksCheckedOut1.get(1).getHolder().equals(patron1)
        || !booksCheckedOut1.get(1).getDueDate().equals(new GregorianCalendar(2008, 1, 1)))
      System.err.println("TEST FAILED: lookup(holder)");

    if (!lib1.checkin(patron1))
      System.err.println("TEST FAILED: checkin(holder)");
  }

  // Test for getInventoryList()
  public static void testGetInventoryList() {
    Library<String> lib = new Library<String>();
    lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib.add(9780446580342L, "David Baldacci", "Simple Genius");

    ArrayList<LibraryBook<String>> sortedInventory = lib.getInventoryList();

    if (sortedInventory.get(0).getIsbn() != 9780330351690L) {
      System.err.println("TEST FAILED: Inventory sorting incorrect");
    } else if (sortedInventory.get(1).getIsbn() != 9780374292799L) {
      System.err.println("TEST FAILED: Inventory sorting incorrect");
    } else if (sortedInventory.get(2).getIsbn() != 9780446580342L) {
      System.err.println("TEST FAILED: Inventory sorting incorrect");
    } else {
      System.out.println("TEST PASSED: getInventoryList()");
    }
  }

  // Test for getOrderedByAuthor()
  public static void testGetOrderedByAuthor() {
    Library<String> lib = new Library<String>();
    lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib.add(9780446580342L, "David Baldacci", "Simple Genius");

    List<LibraryBook<String>> sortedBooks = lib.getOrderedByAuthor();

    if (!sortedBooks.get(0).getAuthor().equals("David Baldacci")) {
      System.err.println("TEST FAILED: Author sorting incorrect");
    } else if (!sortedBooks.get(1).getAuthor().equals("Jon Krakauer")) {
      System.err.println("TEST FAILED: Author sorting incorrect");
    } else if (!sortedBooks.get(2).getAuthor().equals("Thomas L. Friedman")) {
      System.err.println("TEST FAILED: Author sorting incorrect");
    } else {
      System.out.println("TEST PASSED: getOrderedByAuthor()");
    }
  }

  // Test for getOverdueList()
  public static void testGetOverdueList() {
    Library<String> lib = new Library<String>();
    lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");

    String patron1 = "Jane Doe";

    // Checkout with past due date
    lib.checkout(9780374292799L, patron1, 1, 1, 2020); // Overdue
    // Checkout with future due date
    lib.checkout(9780330351690L, patron1, 12, 31, 2030); // Not overdue

    List<LibraryBook<String>> overdueBooks = lib.getOverdueList();

    if (overdueBooks.size() != 1) {
      System.err.println("TEST FAILED: getOverdueList() incorrect number of books");
    } else if (overdueBooks.get(0).getIsbn() != 9780374292799L) {
      System.err.println("TEST FAILED: getOverdueList() incorrect book returned");
    } else {
      System.out.println("TEST PASSED: getOverdueList()");
    }
  }
}
