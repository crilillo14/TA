package lab04;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Testing class for generic Library.
 *
 */
public class LibraryGenericTest {

  public static void main(String[] args) {

    // Test a library that uses names (String) to id patrons
    Library<String> lib1 = new Library<String>();
    lib1.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib1.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib1.add(9780446580342L, "David Baldacci", "Simple Genius");

    String patron1 = "Jane Doe";

    // Test checkout
    if (!lib1.checkout(9780330351690L, patron1, 1, 1, 2008))
      System.err.println("TEST FAILED: first checkout");
    if (!lib1.checkout(9780374292799L, patron1, 1, 1, 2008))
      System.err.println("TEST FAILED: second checkout");
    
    // Test lookup by holder
    ArrayList<LibraryBook<String>> booksCheckedOut1 = lib1.lookup(patron1);
    if (booksCheckedOut1 == null
        || booksCheckedOut1.size() != 2
        || !booksCheckedOut1.get(0).getHolder().equals(patron1)
        || !booksCheckedOut1.get(1).getHolder().equals(patron1))
      System.err.println("TEST FAILED: lookup(holder)");
    
    // Test checkin by holder
    if (!lib1.checkin(patron1))
      System.err.println("TEST FAILED: checkin(holder)");

    // Test a library that uses phone numbers (PhoneNumber) to id patrons
    Library<PhoneNumber> lib2 = new Library<PhoneNumber>();
    lib2.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib2.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib2.add(9780446580342L, "David Baldacci", "Simple Genius");

    PhoneNumber patron2 = new PhoneNumber("305.555.1234");

    // Test checkout with phone numbers
    if (!lib2.checkout(9780330351690L, patron2, 1, 1, 2008))
      System.err.println("TEST FAILED: first checkout");
    if (!lib2.checkout(9780374292799L, patron2, 1, 1, 2008))
      System.err.println("TEST FAILED: second checkout");
    
    // Test lookup by phone number holder
    ArrayList<LibraryBook<PhoneNumber>> booksCheckedOut2 = lib2.lookup(patron2);
    if (booksCheckedOut2 == null
        || booksCheckedOut2.size() != 2
        || !booksCheckedOut2.get(0).getHolder().equals(patron2)
        || !booksCheckedOut2.get(1).getHolder().equals(patron2))
      System.err.println("TEST FAILED: lookup(holder)");

    // Test checkin by phone number holder
    if (!lib2.checkin(patron2))                           
      System.err.println("TEST FAILED: checkin(holder)");
    
    System.out.println("Testing done.");

    // ADDITIONAL TESTS
    
    // Test getInventoryList (sorted by ISBN)
    ArrayList<LibraryBook<String>> inventoryList = lib1.getInventoryList();
    System.out.println("Inventory List Sorted by ISBN:");
    for (LibraryBook<String> book : inventoryList) {
      System.out.println(book.getIsbn() + " - " + book.getTitle());
    }

    // Test getOrderedByAuthor (sorted by Author)
    ArrayList<LibraryBook<String>> orderedByAuthor = lib1.getOrderedByAuthor();
    System.out.println("Library Sorted by Author:");
    for (LibraryBook<String> book : orderedByAuthor) {
      System.out.println(book.getAuthor() + " - " + book.getTitle());
    }

    // Test getOverdueList (overdue books sorted by due date)
    GregorianCalendar currentDate = new GregorianCalendar(2009, 1, 1);  // January 1, 2009
    ArrayList<LibraryBook<String>> overdueBooks = lib1.getOverdueList(currentDate);
    System.out.println("Overdue Books Sorted by Due Date:");
    for (LibraryBook<String> book : overdueBooks) {
      System.out.println(book.getTitle() + " (Due: " + book.getDueDate().getTime() + ")");
    }

    //Uncomment for testing the medium library with Mushroom_Publishing.txt
    Library<String> lib3 = new Library<String>();
    lib3.addAll("Mushroom_Publishing.txt");
  }
}
