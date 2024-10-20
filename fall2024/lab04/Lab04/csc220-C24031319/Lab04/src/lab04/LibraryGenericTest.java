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
    //Lab Testing
    Library<String> LibTest = new Library<String>();
    LibTest.add(9780446580342L, "David Baldacci", "Simple Genius");
    LibTest.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    LibTest.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    LibTest.add(9780446580342L, "David Baldacci", "Simple Genius");
    
    Library<PhoneNumber> LibTest2 = new Library<PhoneNumber>();
    LibTest2.add(9780446580342L, "David Baldacci", "Simple Genius");
    LibTest2.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    LibTest2.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    LibTest2.add(9780446580342L, "David Baldacci", "Simple Genius");
    
    System.out.println("Library of String types:");
    System.out.println(LibTest.getInventoryList());
    System.out.println("Library of PhoneNumbers types:");
    System.out.println(LibTest2.getInventoryList());
    
    
    System.out.println();
    System.out.println();
    // test a medium library: you will use this for homework
    //HW testing
    Library<String> lib3 = new Library<String>();    
    lib3.addAll("Mushroom_Publishing.txt");
    System.out.println("Ordering by ISBN:");
    System.out.println(lib3.getInventoryList());
    System.out.println("Ordering by author:");
    System.out.println(lib3.getOrderedByAuthor());
    System.out.println("Ordering by overdue:");
    //adding a new book
    lib3.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    //checking out the book 
    lib3.checkout(9780374292799L, "Orel", 1, 1, 2025); //not overdue
    //adding another book
    lib3.add(9780446580342L, "David Baldacci", "Simple Genius");
    //checking out the book
    lib3.checkout(9780446580342L, "Orel", 8, 19, 2024); //overdue
    System.out.println(lib3.getOverdueList(9, 12, 2024)); //should only printout David Baldacci Book   
  }
}
