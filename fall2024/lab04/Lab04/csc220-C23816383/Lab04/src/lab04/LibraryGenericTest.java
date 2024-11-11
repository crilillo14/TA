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

    // test a medium library
    Library<String> lib3 = new Library<String>();
    lib3.addAll("Mushroom_Publishing.txt");

    // Test getInventoryList
    ArrayList<LibraryBook<String>> inventory = lib3.getInventoryList();
    System.out.println("Inventory list sorted by ISBN:");
    for (LibraryBook<String> book : inventory) {
      System.out.println(book.getIsbn() + ": " + book.getTitle() + " by " + book.getAuthor());
    }

    // Test getOrderedByAuthor
    ArrayList<LibraryBook<String>> orderedByAuthor = lib3.getOrderedByAuthor();
    System.out.println("\nBooks ordered by author:");
    for (LibraryBook<String> book : orderedByAuthor) {
      System.out.println(book.getAuthor() + ": " + book.getTitle() + " (ISBN: " + book.getIsbn() + ")");
    }

    // Test checkout and getOverdueList
    String patron3 = "John Smith";
    lib3.checkout(9781843190004L, patron3, 1, 1, 2008);
    lib3.checkout(9781843190011L, patron3, 1, 15, 2008);
    lib3.checkout(9781843190349L, patron3, 2, 1, 2008);

    ArrayList<LibraryBook<String>> overdueList = lib3.getOverdueList(2, 14, 2008);
    System.out.println("\nOverdue books as of 2/14/2008:");
    for (LibraryBook<String> book : overdueList) {
      System.out.println(book.getTitle() + " by " + book.getAuthor() + ", due on " + book.getDueDate().getTime());
    }

    // Additional tests
    System.out.println("\nAdditional tests:");

    // Test lookup by ISBN
    if (lib3.lookup(9781843190004L).equals(patron3)) {
      System.out.println("TEST PASSED: lookup by ISBN");
    } else {
      System.out.println("TEST FAILED: lookup by ISBN");
    }

    // Test lookup by holder
    ArrayList<LibraryBook<String>> patronBooks = lib3.lookup(patron3);
    if (patronBooks.size() == 3) {
      System.out.println("TEST PASSED: lookup by holder");
    } else {
      System.out.println("TEST FAILED: lookup by holder");
    }

    // Test checkin by ISBN
    if (lib3.checkin(9781843190004L)) {
      System.out.println("TEST PASSED: checkin by ISBN");
    } else {
      System.out.println("TEST FAILED: checkin by ISBN");
    }

    // Test checkin by holder
    if (lib3.checkin(patron3)) {
      System.out.println("TEST PASSED: checkin by holder");
    } else {
      System.out.println("TEST FAILED: checkin by holder");
    }

    System.out.println("Testing done.");
  }
}