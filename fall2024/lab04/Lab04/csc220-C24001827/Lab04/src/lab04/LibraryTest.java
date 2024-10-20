package lab04;

import java.util.ArrayList;

public class LibraryTest {

    public static void main(String[] args) {
        // Create an instance of Library with String type holders
        Library<String> lib = new Library<>();

        // Add some books to the library
        lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
        lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
        lib.add(9780446580342L, "David Baldacci", "Simple Genius");

        // Test 1: Lookup a book by ISBN (should return null for an empty library)
        if (lib.lookup(9780374292799L) != null) {
            System.err.println("TEST FAILED -- empty library: lookup(isbn)");
        }

        // Test 2: Checkout a book to "Jane Doe"
        if (!lib.checkout(9780374292799L, "Jane Doe", 1, 1, 2024)) {
            System.err.println("TEST FAILED -- could not checkout book to Jane Doe");
        }

        // Test 3: Lookup books by holder "Jane Doe"
        ArrayList<LibraryBook<String>> booksCheckedOut = lib.lookup("Jane Doe");
        if (booksCheckedOut == null || booksCheckedOut.size() != 1) {
            System.err.println("TEST FAILED -- lookup(holder) did not return the correct number of books.");
        }

        // Test 4: Check in the book by ISBN
        if (!lib.checkin(9780374292799L)) {
            System.err.println("TEST FAILED -- could not checkin book by ISBN");
        }

        // Test 5: Ensure no books are checked out to "Jane Doe" after checkin
        booksCheckedOut = lib.lookup("Jane Doe");
        if (booksCheckedOut != null && booksCheckedOut.size() != 0) {
            System.err.println("TEST FAILED -- lookup(holder) still shows books checked out after checkin.");
        }

        // Output the result
        System.out.println("Testing done.");
    }
}
