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

        if (!lib1.checkout(9780330351690L, patron1, 1, 1, 2008)) {
            System.err.println("TEST FAILED: first checkout");
        }
        if (!lib1.checkout(9780374292799L, patron1, 1, 1, 2008)) {
            System.err.println("TEST FAILED: second checkout");
        }
        ArrayList<LibraryBook<String>> booksCheckedOut1 = lib1
                .lookup(patron1);
        if (booksCheckedOut1 == null
                || booksCheckedOut1.size() != 2
                || !booksCheckedOut1.contains(new LibraryBook<>(9780330351690L, "Jon Krakauer",
                        "Into the Wild"))
                || !booksCheckedOut1.contains(new LibraryBook<>(9780374292799L,
                        "Thomas L. Friedman", "The World is Flat"))
                || !booksCheckedOut1.get(0).getHolder().equals(patron1)
                || !booksCheckedOut1.get(0).getDueDate().equals(
                        new GregorianCalendar(2008, 1, 1))
                || !booksCheckedOut1.get(1).getHolder().equals(patron1)
                || !booksCheckedOut1.get(1).getDueDate().equals(
                        new GregorianCalendar(2008, 1, 1))) {
            System.err.println("TEST FAILED: lookup(holder)");
        }
        if (!lib1.checkin(patron1)) {
            System.err.println("TEST FAILED: checkin(holder)");
        }

        // test a library that uses phone numbers (PhoneNumber) to id patrons
        Library<PhoneNumber> lib2 = new Library<PhoneNumber>();
        lib2.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
        lib2.add(9780330351690L, "Jon Krakauer", "Into the Wild");
        lib2.add(9780446580342L, "David Baldacci", "Simple Genius");

        PhoneNumber patron2 = new PhoneNumber("305.555.1234");

        if (!lib2.checkout(9780330351690L, patron2, 1, 1, 2008)) {
            System.err.println("TEST FAILED: first checkout");
        }
        if (!lib2.checkout(9780374292799L, patron2, 1, 1, 2008)) {
            System.err.println("TEST FAILED: second checkout");
        }
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
                        new GregorianCalendar(2008, 1, 1))) {
            System.err.println("TEST FAILED: lookup(holder)");
        }
        if (!lib2.checkin(patron2)) {
            System.err.println("TEST FAILED: checkin(holder)");
        }

        System.out.println("Testing done.");

        // FILL IN for tests
        // FOR LAB: write tests for getInventoryList
        Library<String> lib3 = new Library<String>();
        lib3.add(9, "Thomas L. Friedman", "The World is Flat");
        lib3.add(8, "Jon Krakauer", "Into the Wild");
        lib3.add(7, "David Baldacci", "Simple Genius");

        ArrayList<LibraryBook<String>> inventoryList1 = lib3.getInventoryList();
        for (LibraryBook<String> book : inventoryList1) {
            System.out.println(book);
        }
        System.out.println("inventoryList1: " + inventoryList1);

        // test a medium library: you will use this for homework
        //Library<String> lib3 = new Library<String>();    
        //lib3.addAll("Mushroom_Publishing.txt");
        // Test for overdue books
        Library<String> lib4 = new Library<String>();
        lib4.add(1, "alex", "el palon");
        lib4.add(2, "eric", "palo");

        lib4.checkout(1, "dexa", 11, 19, 20);
        lib4.checkout(2, "bob", 11, 19, 2000);

        System.out.println(lib4.getOverdueList());

        Library<String> lib6 = new Library<String>();
        lib6.addAll("Mushroom_Publishing.txt");
        lib6.checkout(9781843190677L, "Alice", 11, 19, 2023);
        lib6.checkout(9781843193319L, "Bob", 11, 19, 2000);
        System.out.println(lib6.getOverdueList());

    }
}
