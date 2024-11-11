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
    
    // test a medium library: you will use this for homework
    Library<String> lib3 = new Library<String>();    
    lib3.addAll("Mushroom_Publishing.txt");
    
    ArrayList<LibraryBook<String>> inventoryList = lib3.getInventoryList();
    long previousIsbn = 0;
    for (int i = 0; i < inventoryList.size(); i++) {
      LibraryBook<String> book = inventoryList.get(i);

      if (i > 0 && book.getIsbn() < previousIsbn) {
        System.err.println("TEST FAILED: getInventoryList" + i);
      }
      previousIsbn = book.getIsbn();
    }

    String patron = "Jane Doe";
    if (!lib3.checkout(9781843190028L, patron, 1, 1, 2024)) {
      System.err.println("TEST FAILED: checkout");
    } else {
      ArrayList<LibraryBook<String>> booksCheckedOut = lib3.lookup(patron);
      if (booksCheckedOut == null || booksCheckedOut.size() != 1 || 
          !booksCheckedOut.get(0).getTitle().equals("Crystal Legends")) {
        System.err.println("TEST FAILED: checkout");
      }
    }

    if (!lib3.checkin(9781843190028L)) {
      System.err.println("TEST FAILED: checkin");
    } else {
      ArrayList<LibraryBook<String>> booksCheckedOut = lib3.lookup(patron);
      if (booksCheckedOut != null && booksCheckedOut.size() > 0) {
        System.err.println("TEST FAILED: checkin");
      }
    }

    if (!lib3.checkout(9781843190011L, patron, 1, 1, 2024)) {
      System.err.println("TEST FAILED: checkout");
    } else {
      if (!lib3.checkin(patron)) {
        System.err.println("TEST FAILED: checkin");
      } else {
        ArrayList<LibraryBook<String>> booksCheckedOut = lib3.lookup(patron);
        if (booksCheckedOut != null && booksCheckedOut.size() > 0) {
          System.err.println("TEST FAILED: checkin");
        }
      }
    }
  }
}
