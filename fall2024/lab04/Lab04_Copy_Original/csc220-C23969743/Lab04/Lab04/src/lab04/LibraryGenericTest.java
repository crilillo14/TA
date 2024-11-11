package lab04;

import java.util.ArrayList;
import java.util.GregorianCalendar;

// import java.util.Comparator;


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
    // Tests with custom holder type
    Library<Integer> lib3 = new Library<>();
    lib3.add(9780671027385L, "George R.R. Martin", "A Game of Thrones");
    Integer holderId = 12345;

    lib3.checkout(9780671027385L, holderId, 5, 15, 2025);
    if (lib3.lookup(holderId) == null || lib3.lookup(holderId).isEmpty()) {
        System.err.println("TEST FAILED: lookup(holder) with Integer holder");
    }

    lib3.checkin(holderId);
    if (lib3.lookup(holderId) == null || !lib3.lookup(holderId).isEmpty()) {
        System.err.println("TEST FAILED: lookup(holder) after checkin with Integer holder");
    }

    // Tests empty library
    Library<String> emptyLib = new Library<>();
    if (emptyLib.lookup("Nonexistent Holder") != null && !emptyLib.lookup("Nonexistent Holder").isEmpty()) {
        System.err.println("TEST FAILED: lookup(holder) in empty library");
    }

    if (emptyLib.checkout(1234567890L, "Some Holder", 1, 1, 2025)) {
        System.err.println("TEST FAILED: checkout in empty library");
    }

    if (emptyLib.checkin("Some Holder")) {
        System.err.println("TEST FAILED: checkin in empty library");
    }

    // Tests adding duplicate books to lib
    Library<String> lib5 = new Library<>();
    lib5.add(9780671027385L, "George R.R. Martin", "A Game of Thrones");
    lib5.add(9780671027385L, "George R.R. Martin", "A Game of Thrones");
    
    if (lib5.lookup(9780671027385L) != null) {
        System.err.println("TEST FAILED: duplicate books");
    }
    
    System.out.println("Additional Testing done.");
    
    // FOR LAB: write tests for getInventoryList
    // Tests getInventoryList method
    Library<String> lib4 = new Library<>();
    lib4.add(9780671027385L, "George R.R. Martin", "A Game of Thrones");
    lib4.add(9780123456789L, "J.K. Rowling", "Harry Potter and the Sorcerer's Stone");
    lib4.add(9780987654321L, "J.R.R. Tolkien", "The Hobbit");

    ArrayList<LibraryBook<String>> sortedInventory = lib4.getInventoryList();

    if (sortedInventory == null || sortedInventory.size() != 3) {
        System.err.println("TEST FAILED: getInventoryList size");
    } else {
        // Checks if sorted by ISBN
        boolean sorted = true;
        for (int i = 0; i < sortedInventory.size() - 1; i++) {
            if (sortedInventory.get(i).getIsbn() > sortedInventory.get(i + 1).getIsbn()) {
                sorted = false;
                break;
            }
        }
        if (!sorted) {
            System.err.println("TEST FAILED: getInventoryList not sorted by ISBN");
        }
    }

    System.out.println("Additional Testing done.");
    
    // test a medium library: you will use this for homework
    //Library<String> lib3 = new Library<String>();    
    //lib3.addAll("Mushroom_Publishing.txt");
    
  }
}
