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
    
    System.out.println("Testing done.");
    
    // FILL IN for tests
    
    // FOR LAB: write tests for getInventoryList
    Library<String> lib5 = new Library<String>();
    lib5.add(0001L, "Thomas L. Friedman", "The World is Flat");
    lib5.add(0002L, "ZAM Fraw", "Hello World");
    lib5.add(0003L, "ZAM Fraw", "Apple Founders");
    lib5.add(0004L, "Jon Krakauer", "Into the Wild");
    lib5.add(0005L, "David Baldacci", "Simple Genius");
    lib5.add(0006L, "Alez Tester", "Zoology");
    lib5.checkout(0004L, "Andrew", 12, 1, 2024);
    lib5.checkout(0001L, "Brian", 12, 4, 2024);
    lib5.checkout(0005L, "Edd", 12, 1, 2024);
    lib5.checkout(0002L, "Brian", 12, 4, 2023);
    
    System.out.println(lib5.getInventoryList());
    System.out.println(lib5.getOrderedByAuthor());
    System.out.println(lib5.getOverdueList());
    
    Library<String> lib4 = new Library<String>();
    lib4.add(0004L, "Jon Krakauer", "Into the Wild");
    lib4.add(0001L, "Thomas L. Friedman", "The World is Flat");
    lib4.add(0006L, "Alez Tester", "Zoology");
    lib4.add(0002L, "ZAM Fraw", "Hello World");
    lib4.add(0003L, "ZAM Fraw", "Apple Founders");
    lib4.add(0005L, "David Baldacci", "Simple Genius");
    lib4.checkout(0004L, "Andrew", 12, 1, 2024);
    lib4.checkout(0001L, "Brian", 12, 4, 2024);
    lib4.checkout(0005L, "Edd", 12, 1, 2024);
    lib4.checkout(0002L, "Brian", 12, 4, 2023);
    
    System.out.println(lib4.getInventoryList());
    System.out.println(lib4.getOrderedByAuthor());
    System.out.println(lib4.getOverdueList());

    
    // test a medium library: you will use this for homework
    Library<String> lib3 = new Library<String>();    
    lib3.addAll("Mushroom_Publishing.txt");
    lib3.checkout(9781843190875L, "Andrew", 12, 1, 2024);
    lib3.checkout(9781843190875L, "Brian", 12, 4, 2024);
    lib3.checkout(9781843192022L, "Edd", 12, 1, 2024);
    lib3.checkout(9781843190073L, "Brian", 12, 4, 2023);
    System.out.println(lib3.getInventoryList());
    System.out.println(lib3.getOrderedByAuthor());
    System.out.println(lib3.getOverdueList());
    
    
  }
}
