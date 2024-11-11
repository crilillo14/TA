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
    
    System.out.println(lib1.getInventoryList());
    
    
    
//    Library<String> lib11 = new Library<String>();
//    lib11.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
//    lib11.add(9780330351690L, "Jon Krakauer", "Into the Wild");
//    lib11.add(9780446580342L, "David Baldacci", "Simple Genius");
//
//    // Get the inventory list sorted by ISBN
//    ArrayList<LibraryBook<String>> inventoryList = lib11.getInventoryList();
//    
//    // Check if the inventory list is sorted correctly by ISBN
//    if (inventoryList.size() != 3
//        || inventoryList.get(0).getIsbn() != 9780330351690L
//        || inventoryList.get(1).getIsbn() != 9780374292799L
//        || inventoryList.get(2).getIsbn() != 9780446580342L) {
//      System.err.println("TEST FAILED: getInventoryList()");
//    }
//
//    System.out.println("Testing done.");
//
//    // Test with an empty library
//    Library<String> lib22 = new Library<String>();
//    ArrayList<LibraryBook<String>> emptyList = lib22.getInventoryList();
//    if (emptyList.size() != 0) {
//      System.err.println("TEST FAILED: getInventoryList() with empty library");
//    }
//
//    // Test with one book in the library
//    lib22.add(9780446580342L, "David Baldacci", "Simple Genius");
//    ArrayList<LibraryBook<String>> singleBookList = lib22.getInventoryList();
//    if (singleBookList.size() != 1
//        || singleBookList.get(0).getIsbn() != 9780446580342L) {
//      System.err.println("TEST FAILED: getInventoryList() with one book");
//    }
    
    
  }
}
