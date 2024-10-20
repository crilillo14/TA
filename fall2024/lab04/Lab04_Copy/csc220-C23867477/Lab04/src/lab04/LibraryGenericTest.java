package lab04;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
/**
 * Testing class for generic Library.
 *
 */
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class LibraryGenericTest {

  public static void main(String[] args) {

    // Test a library that uses names (String) to id patrons
    testStringLibrary();

    // Test a library that uses phone numbers (PhoneNumber) to id patrons
    testPhoneNumberLibrary();
    
    //Test inventory list
    testGetInventoryList();
    
 // test a medium library: you will use this for homework
   testMediumLibrary();

    System.out.println("Testing done.");
  } //end of main method

  private static void testStringLibrary() {
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
        || !booksCheckedOut1.contains(new LibraryBook<String>(9780330351690L, "Jon Krakauer", "Into the Wild"))
        || !booksCheckedOut1.contains(new LibraryBook<String>(9780374292799L, "Thomas L. Friedman", "The World is Flat"))
        || !booksCheckedOut1.get(0).getHolder().equals(patron1)
        || !booksCheckedOut1.get(0).getDueDate().equals(new GregorianCalendar(2008, 0, 1))
        || !booksCheckedOut1.get(1).getHolder().equals(patron1)
        || !booksCheckedOut1.get(1).getDueDate().equals(new GregorianCalendar(2008, 0, 1)))
      System.err.println("TEST FAILED: lookup(holder)");

    if (!lib1.checkin(patron1))
      System.err.println("TEST FAILED: checkin(holder)");

    // Additional tests for lib1
    if (!lib1.checkout(9780330351690L, patron1, 1, 1, 2008))
      System.err.println("TEST FAILED: first checkout");
    if (lib1.checkout(9780330351690L, patron1, 1, 1, 2008))
      System.err.println("TEST FAILED: checkout already checked out book");
    if (lib1.lookup(1234567890L) != null)
      System.err.println("TEST FAILED: lookup non-existent ISBN");
    if (!lib1.lookup("Non-existent Holder").isEmpty())
      System.err.println("TEST FAILED: lookup non-existent holder");
    System.out.println("String library testing done.");
  }

  private static void testPhoneNumberLibrary() {
    Library<PhoneNumber> lib2 = new Library<PhoneNumber>();
    lib2.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib2.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib2.add(9780446580342L, "David Baldacci", "Simple Genius");

    PhoneNumber patron2 = new PhoneNumber("305.555.1234");
    if (!lib2.checkout(9780330351690L, patron2, 1, 1, 2008))
      System.err.println("TEST FAILED: first checkout (PhoneNumber)");
    if (!lib2.checkout(9780374292799L, patron2, 1, 1, 2008))
      System.err.println("TEST FAILED: second checkout (PhoneNumber)");

    ArrayList<LibraryBook<PhoneNumber>> booksCheckedOut2 = lib2.lookup(patron2);
    if (booksCheckedOut2 == null
        || booksCheckedOut2.size() != 2
        || !booksCheckedOut2.contains(new LibraryBook<PhoneNumber>(9780330351690L, "Jon Krakauer", "Into the Wild"))
        || !booksCheckedOut2.contains(new LibraryBook<PhoneNumber>(9780374292799L, "Thomas L. Friedman", "The World is Flat"))
        || !booksCheckedOut2.get(0).getHolder().equals(patron2)
        || !booksCheckedOut2.get(0).getDueDate().equals(new GregorianCalendar(2008, 0, 1))
        || !booksCheckedOut2.get(1).getHolder().equals(patron2)
        || !booksCheckedOut2.get(1).getDueDate().equals(new GregorianCalendar(2008, 0, 1)))
      System.err.println("TEST FAILED: lookup(holder) (PhoneNumber)");

    if (!lib2.checkin(patron2))
      System.err.println("TEST FAILED: checkin(holder) (PhoneNumber)");

    // Additional tests for lib2
    if (!lib2.checkout(9780330351690L, patron2, 1, 1, 2008))
      System.err.println("TEST FAILED: first checkout (PhoneNumber)");
    if (lib2.checkout(9780330351690L, patron2, 1, 1, 2008))
      System.err.println("TEST FAILED: checkout already checked out book (PhoneNumber)");
    if (lib2.lookup(1234567890L) != null)
      System.err.println("TEST FAILED: lookup non-existent ISBN (PhoneNumber)");
    if (!lib2.lookup(new PhoneNumber("123.456.7890")).isEmpty())
      System.err.println("TEST FAILED: lookup non-existent holder (PhoneNumber)");

    // Test PhoneNumber equality
    PhoneNumber phone1 = new PhoneNumber("123.456.7890");
    PhoneNumber phone2 = new PhoneNumber("123.456.7890");
    PhoneNumber phone3 = new PhoneNumber("987.654.3210");
    
    if (!phone1.equals(phone2))
      System.err.println("TEST FAILED: PhoneNumber equality (same number)");
    if (phone1.equals(phone3))
      System.err.println("TEST FAILED: PhoneNumber equality (different numbers)");
    if (phone1.equals("123.456.7890"))
      System.err.println("TEST FAILED: PhoneNumber equality (comparing with String)");

    // Test PhoneNumber formatting
    PhoneNumber phone4 = new PhoneNumber("1234567890");
    if (!phone4.toString().equals("(123) 456-7890"))
      System.err.println("TEST FAILED: PhoneNumber formatting");
    
    System.out.println("Phone library testing done.");
  }
  
  private static void testGetInventoryList() {
      Library<String> lib = new Library<>();
      
      // Add books in non-sorted order
      lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
      lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
      lib.add(9780446580342L, "David Baldacci", "Simple Genius");

      ArrayList<LibraryBook<String>> inventory = lib.getInventoryList();

      // Check if the list is sorted by ISBN
      if (inventory.size() != 3) {
          System.err.println("TEST FAILED: Incorrect number of books in inventory");
      }

      if (inventory.get(0).getIsbn() != 9780330351690L ||
          inventory.get(1).getIsbn() != 9780374292799L ||
          inventory.get(2).getIsbn() != 9780446580342L) {
          System.err.println("TEST FAILED: Books not sorted correctly by ISBN");
      }

      // Test with empty library
      Library<String> emptyLib = new Library<>();
      ArrayList<LibraryBook<String>> emptyInventory = emptyLib.getInventoryList();

      if (!emptyInventory.isEmpty()) {
          System.err.println("TEST FAILED: Inventory of empty library should be empty");
      }

      System.out.println("getInventoryList tests completed.");
  }
  
  public static void testMediumLibrary() {
      Library<String> lib3 = new Library<String>();
      lib3.addAll("Mushroom_Publishing.txt");

      // Test 1: Check if all books are added correctly
      ArrayList<LibraryBook<String>> inventory = lib3.getInventoryList();
      

      // Test 2: Verify ISBN sorting in getInventoryList
     
      boolean isSortedByIsbn = true;
      for (int i = 0; i < inventory.size() - 1; i++) {
          if (inventory.get(i).getIsbn() > inventory.get(i + 1).getIsbn()) {
              isSortedByIsbn = false;
              break;
          }
      }
      // Test 3: Check out some books
      String patron1 = "Alice";
      String patron2 = "Bob";
      lib3.checkout(9781843190004L, patron1, 3, 1, 2023);
      lib3.checkout(9781843190011L, patron1, 3, 15, 2023);
      lib3.checkout(9781843190349L, patron2, 4, 1, 2023);
      
      // Test 4: Lookup books by patron
      List<LibraryBook<String>> aliceBooks = lib3.lookup(patron1);
      List<LibraryBook<String>> bobBooks = lib3.lookup(patron2);
      

      // Test 5: Get ordered by author
      List<LibraryBook<String>> orderedByAuthor = lib3.getOrderedByAuthor();
      System.out.println("Medium library testing done.");
  }
}

    
   
