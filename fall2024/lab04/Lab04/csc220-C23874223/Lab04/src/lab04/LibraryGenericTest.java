package lab04;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class LibraryGenericTest {

    public static void main(String[] args) {
        // Test a library that uses names (String) to identify patrons
        Library<String> lib1 = new Library<>();
        lib1.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
        lib1.add(9780330351690L, "Jon Krakauer", "Into the Wild");
        lib1.add(9780446580342L, "David Baldacci", "Simple Genius");

        String patron1 = "Jane Doe";

        if (!lib1.checkout(9780330351690L, patron1, 1, 1, 2008))
            System.err.println("TEST FAILED: first checkout");
        if (!lib1.checkout(9780374292799L, patron1, 1, 1, 2008))
            System.err.println("TEST FAILED: second checkout");

        ArrayList<LibraryBook<String>> booksCheckedOut1 = lib1.lookup(patron1);
        if (booksCheckedOut1 == null || booksCheckedOut1.size() != 2
                || !booksCheckedOut1.contains(new LibraryBook<>(9780330351690L, "Jon Krakauer", "Into the Wild"))
                || !booksCheckedOut1.contains(new LibraryBook<>(9780374292799L, "Thomas L. Friedman", "The World is Flat"))
                || !booksCheckedOut1.get(0).getHolder().equals(patron1)
                || !booksCheckedOut1.get(0).getDueDate().equals(new GregorianCalendar(2008, 0, 1)) // January is 0
                || !booksCheckedOut1.get(1).getHolder().equals(patron1)
                || !booksCheckedOut1.get(1).getDueDate().equals(new GregorianCalendar(2008, 0, 1)))
            System.err.println("TEST FAILED: lookup(holder)");

        if (!lib1.checkin(patron1))
            System.err.println("TEST FAILED: checkin(holder)");

        // Test getInventoryList
        ArrayList<LibraryBook<String>> inventory = lib1.getInventoryList();
        if (inventory.size() != 3) {
            System.err.println("TEST FAILED: Inventory list size");
        }
        if (!inventory.contains(new LibraryBook<>(9780374292799L, "Thomas L. Friedman", "The World is Flat")) ||
            !inventory.contains(new LibraryBook<>(9780330351690L, "Jon Krakauer", "Into the Wild")) ||
            !inventory.contains(new LibraryBook<>(9780446580342L, "David Baldacci", "Simple Genius"))) {
            System.err.println("TEST FAILED: Inventory list contents");
        }

        // Test getOrderedByAuthor
        ArrayList<LibraryBook<String>> orderedByAuthor = (ArrayList<LibraryBook<String>>) lib1.getOrderedByAuthor();
        if (!orderedByAuthor.get(0).getAuthor().equals("David Baldacci")) {
            System.err.println("TEST FAILED: First book should be by David Baldacci");
        }

        // Test overdue list
        ArrayList<LibraryBook<String>> overdueList = (ArrayList<LibraryBook<String>>) lib1.getOverdueList();
        // Assuming the library was checked out correctly, you might want to create a specific scenario for overdue checks

        // Test a library that uses phone numbers (PhoneNumber) to identify patrons
        Library<PhoneNumber> lib2 = new Library<>();
        lib2.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
        lib2.add(9780330351690L, "Jon Krakauer", "Into the Wild");
        lib2.add(9780446580342L, "David Baldacci", "Simple Genius");

        PhoneNumber patron2 = new PhoneNumber("305.555.1234");

        if (!lib2.checkout(9780330351690L, patron2, 1, 1, 2008))
            System.err.println("TEST FAILED: first checkout");
        if (!lib2.checkout(9780374292799L, patron2, 1, 1, 2008))
            System.err.println("TEST FAILED: second checkout");

        ArrayList<LibraryBook<PhoneNumber>> booksCheckedOut2 = lib2.lookup(patron2);
        if (booksCheckedOut2 == null || booksCheckedOut2.size() != 2
                || !booksCheckedOut2.contains(new LibraryBook<>(9780330351690L, "Jon Krakauer", "Into the Wild"))
                || !booksCheckedOut2.contains(new LibraryBook<>(9780374292799L, "Thomas L. Friedman", "The World is Flat"))
                || !booksCheckedOut2.get(0).getHolder().equals(patron2)
                || !booksCheckedOut2.get(0).getDueDate().equals(new GregorianCalendar(2008, 0, 1))
                || !booksCheckedOut2.get(1).getHolder().equals(patron2)
                || !booksCheckedOut2.get(1).getDueDate().equals(new GregorianCalendar(2008, 0, 1)))
            System.err.println("TEST FAILED: lookup(holder)");

        if (!lib2.checkin(patron2))
            System.err.println("TEST FAILED: checkin(holder)");

        System.out.println("Testing done.");
 

    
    // FILL IN for tests
    
    // FOR LAB: write tests for getInventoryList
    
    // test a medium library: you will use this for homework
    Library<String> lib3 = new Library<String>();    
    lib3.addAll("Mushroom_Publishing.txt");
    
  }
}