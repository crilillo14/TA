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
    
    //Check out a book that someone else checked out
    lib2.checkout(9780374292799L, patron2, 9, 18, 2024);
    
    PhoneNumber patron3 = new PhoneNumber("305.123.4567");
    if (lib2.checkout(9780374292799L, patron3, 9, 16, 2024))
      System.err.println("TEST FAILED: double checkout");
    
    
    //Lookup a book for their ISBN
    if (!patron2.equals(lib2.lookup(9780374292799L)))
        System.err.println("TEST FAILED: lookup(isbn)");
    
    
    //Check in a book through their ISBN
    
    if (!lib2.checkin(9780374292799L))
        System.err.println("TEST FAILED: checkin(isbn)");
    
    //Is the book actually check in
    if (lib2.lookup(9780374292799L) != null)
        System.err.println("TEST FAILED: Checked in book does not appaear");
    
    //Check in non-existant book
    if (lib2.checkin(9780374292798L)) {
        System.err.println("TEST FAILED: Book by that ISBN doesn't exist");
    }
    
    //Checkout book through ISBN
    if (!lib2.checkout(9780374292799L, patron3, 9, 18, 2024)) {
        System.err.println("TEST FAILED: Checkout book through ISBN");
    }
    
    System.out.println("Testing done.");
    
    // FOR LAB: write tests for getInventoryList
    
    Library<String> lib4 = new Library<String>();
    lib4.add(9780374292798L, "George Orwell", "1984");
    lib4.add(9780374292797L, "Taylor Jenkins Reid", "The Seven Husbands of Evelyn Hugo");
    lib4.add(9780374292796L, "Leo Tolstoy", "Anna Karenina");
    lib4.add(9780374292795L, "F. Scott Fitzgerald", "The Great Gatsby");

  
    ArrayList<LibraryBook<String>> inventoryList = lib4.getInventoryList();

    
    boolean sortedIsbn = true;
    for (int i = 0; i < inventoryList.size() - 1; i++) {
        if (inventoryList.get(i).getIsbn() > inventoryList.get(i + 1).getIsbn()) {
            sortedIsbn = false;
            
        }
    }

    if (sortedIsbn) {
        System.out.println("TEST PASSED: getInventoryList");
    } else {
        System.err.println("TEST FAILED: getInventoryList incorrect sorting");
    }
    
    // test a medium library: you will use this for homework
    Library<String> lib3 = new Library<String>();    
    lib3.addAll("Mushroom_Publishing.txt");
    
    //Test the getOrderedByAuthor method
    
    
    
  }
}

