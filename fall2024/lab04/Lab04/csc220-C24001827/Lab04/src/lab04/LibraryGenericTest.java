package lab04;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Testing class for generic Library.
 *
 */
public class LibraryGenericTest {

  public static void main(String[] args) {

    // test a library that uses names (String) to id patrons
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
        || !booksCheckedOut1.contains(new Book(9780330351690L, "Jon Krakauer",
            "Into the Wild"))
        || !booksCheckedOut1.contains(new Book(9780374292799L,
            "Thomas L. Friedman", "The World is Flat"))
        || !booksCheckedOut1.get(0).getHolder().equals(patron1)
        || !booksCheckedOut1.get(0).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1))
        || !booksCheckedOut1.get(1).getHolder().equals(patron1)
        || !booksCheckedOut1.get(1).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1)))
      System.err.println("TEST FAILED: lookup(holder)");
    if (!lib1.checkin(patron1))
      System.err.println("TEST FAILED: checkin(holder)");

    // test a library that uses phone numbers (PhoneNumber) to id patrons
    Library<PhoneNumber> lib2 = new Library<PhoneNumber>();
    lib2.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib2.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib2.add(9780446580342L, "David Baldacci", "Simple Genius");

    PhoneNumber patron2 = new PhoneNumber("305.555.1234");

    if (!lib2.checkout(9780330351690L, patron2, 1, 1, 2008))
      System.err.println("TEST FAILED: first checkout");
    if (!lib2.checkout(9780374292799L, patron2, 1, 1, 2008))
      System.err.println("TEST FAILED: second checkout");
    ArrayList<LibraryBook<PhoneNumber>> booksCheckedOut2 = lib2.lookup(patron2);
    if (booksCheckedOut2 == null
        || booksCheckedOut2.size() != 2
        || !booksCheckedOut2.contains(new Book(9780330351690L, "Jon Krakauer",
            "Into the Wild"))
        || !booksCheckedOut2.contains(new Book(9780374292799L,
            "Thomas L. Friedman", "The World is Flat"))
        || !booksCheckedOut2.get(0).getHolder().equals(patron2)
        || !booksCheckedOut2.get(0).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1))
        || !booksCheckedOut2.get(1).getHolder().equals(patron2)
        || !booksCheckedOut2.get(1).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1)))
      System.err.println("TEST FAILED: lookup(holder)");
    if (!lib2.checkin(patron2))                           
      System.err.println("TEST FAILED: checkin(holder)");
    
    // FILL IN for tests
    // Test for getOrderedByAuthor
    ArrayList<LibraryBook<String>> orderedByAuthor = lib1.getOrderedByAuthor();
    if (!orderedByAuthor.get(0).getAuthor().equals("David Baldacci") ||
        !orderedByAuthor.get(1).getAuthor().equals("Jon Krakauer") ||
        !orderedByAuthor.get(2).getAuthor().equals("Thomas L. Friedman")) {
      System.err.println("TEST FAILED: getOrderedByAuthor");
    } 

    // Test for getOverdueList
    GregorianCalendar testDate = new GregorianCalendar(2024, 8, 17); 

    lib1.checkout(9780330351690L, patron1, 1, 1, 2008);  
    lib1.checkout(9780374292799L, patron1, 1, 1, 2025); 

    ArrayList<LibraryBook<String>> overdueBooks = lib1.getOverdueList(testDate);
    if (overdueBooks.size() != 1 || overdueBooks.get(0).getIsbn() != 9780330351690L) {
    	System.err.println("TEST FAILED: getOverdueList");
    }

    // FOR LAB: write tests for getInventoryList
    ArrayList<LibraryBook<String>> inventory = lib1.getInventoryList();
    if (inventory.size() != 3 ||
        inventory.get(0).getIsbn() != 9780330351690L ||
        inventory.get(1).getIsbn() != 9780374292799L ||
        inventory.get(2).getIsbn() != 9780446580342L) {
        System.err.println("TEST FAILED: getInventoryList");
    }
    
    // Test a medium library with Mushroom_Publishing.txt
    Library<String> lib3 = new Library<String>();    
    lib3.addAll("Mushroom_Publishing.txt");
    
    ArrayList<LibraryBook<String>> lib3Inventory = lib3.getInventoryList();
    if (lib3Inventory.isEmpty()) {
      System.err.println("TEST FAILED: Mushroom_Publishing.txt");
    } 
    
    System.out.println("Testing done.");
    
    }
  }
