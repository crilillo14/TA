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
    
    // Test sorting by author using getOrderedByAuthor()
    System.out.println("Testing sorting by author...");
    List<LibraryBook<String>> sortedByAuthor = lib1.getOrderedByAuthor();
    for (LibraryBook<String> book : sortedByAuthor) {
        System.out.println(book.getAuthor() + " - " + book.getTitle());
    }

    lib1.checkout(9780321356680L, "Jane Doe", 2020, 1, 1);  // Overdue
    lib1.checkout(9780330351690L, "John Doe", 2023, 1, 1);  // Not overdue

    System.out.println("Testing overdue list...");
    List<LibraryBook<String>> overdueBooks = lib1.getOverdueList();
    for (LibraryBook<String> book : overdueBooks) {
        System.out.println(book.getIsbn() + " - " + book.getTitle() + " (Overdue)");
    }

    System.out.println("Testing sorting by ISBN...");
    List<LibraryBook<String>> sortedBooks = lib1.getInventoryList();
    for (LibraryBook<String> book : sortedBooks) {
        System.out.println(book.getIsbn() + " - " + book.getTitle());
    }

    Library<String> lib3 = new Library<String>();
    lib3.addAll("Mushroom_Publishing.txt");

    

    System.out.println("Testing medium library sorting by ISBN...");
    List<LibraryBook<String>> mediumSortedBooks = lib3.getInventoryList();
    for (LibraryBook<String> book : mediumSortedBooks) {
        System.out.println(book.getIsbn() + " - " + book.getTitle());
    }

    System.out.println("Testing done.");
  }
}