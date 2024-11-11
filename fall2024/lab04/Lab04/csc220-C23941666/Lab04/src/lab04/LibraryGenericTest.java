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
    ArrayList<LibraryBook<String>> booksCheckedOut1 = lib1
        .lookup(patron1);
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
    ArrayList<LibraryBook<PhoneNumber>> booksCheckedOut2 = lib2
        .lookup(patron2);
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
    
    System.out.println("Testing done.");
    
    // FILL IN for tests
    // FOR LAB: write tests for getInventoryList
    
    //test 1
    Library<String> emptyLibrary = new Library<String>();
    ArrayList<LibraryBook<String>> emptyInventory = emptyLibrary.getInventoryList();

    if (emptyInventory.size() != 0) {
      System.out.println("Test 1 failed");
    } else {
      System.out.println("Test 1 passed");
    }
    
    //test 2
    Library<String> duplicateISBNLibrary = new Library<String>();
    duplicateISBNLibrary.add(9781234567890L, "Author One", "First Book");
    duplicateISBNLibrary.add(9781234567890L, "Author Two", "Second Book");  // Same ISBN
    duplicateISBNLibrary.add(9780987654321L, "Author Three", "Third Book");

    ArrayList<LibraryBook<String>> duplicateInventory = duplicateISBNLibrary.getInventoryList();
    if (duplicateInventory.size() != 3 || duplicateInventory.get(0).getIsbn() != 9780987654321L) {
      System.out.println("Test 2 failed");
    } else {
      System.out.println("Test 2 passed");
    }
    
    //test 3
    Library<String> sortedLibrary = new Library<String>();
    sortedLibrary.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    sortedLibrary.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    sortedLibrary.add(9780446580342L, "David Baldacci", "Simple Genius");

    ArrayList<LibraryBook<String>> sortedInventory = sortedLibrary.getInventoryList();
    if (sortedInventory.get(0).getIsbn() != 9780330351690L || sortedInventory.get(2).getIsbn() != 9780446580342L) {
      System.out.println("Test 3 failed");
    } else {
      System.out.println("Test 3 passed");
    }
    
    //test 4
    Library<String> sameAuthorLibrary = new Library<String>();
    sameAuthorLibrary.add(9781234567890L, "Same Author", "First Book");
    sameAuthorLibrary.add(9781234567891L, "Same Author", "Second Book");

    ArrayList<LibraryBook<String>> sameAuthorInventory = sameAuthorLibrary.getInventoryList();
    if (sameAuthorInventory.get(0).getIsbn() != 9781234567890L || sameAuthorInventory.get(1).getIsbn() != 9781234567891L) {
      System.out.println("Test 4 failed");
    } else {
      System.out.println("Test 4 passed");
    }
    
    
    // test a medium library: you will use this for homework
    Library<String> lib3 = new Library<String>();    
    lib3.addAll("Mushroom_Publishing.txt");
    
  }
}
