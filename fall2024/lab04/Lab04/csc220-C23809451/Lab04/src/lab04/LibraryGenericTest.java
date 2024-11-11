package lab04;

import java.util.List;

public class LibraryGenericTest {

    public static void main(String[] args) {
        // Test with String holders (names)
        Library<String> lib1 = new Library<>();
        lib1.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
        lib1.add(9780330351690L, "Jon Krakauer", "Into the Wild");
        lib1.add(9780446580342L, "David Baldacci", "Simple Genius");
        lib1.add(9780140177398L, "George Orwell", "1984");

        // Checkout some books to create overdue items
        lib1.checkout(9780330351690L, "Jane Doe", 1, 1, 2000); // Overdue
        lib1.checkout(9780446580342L, "John Doe", 1, 1, 2025); // Not overdue

        // Test getOrderedByAuthor
        List<LibraryBook<String>> sortedByAuthor = lib1.getOrderedByAuthor();
        System.out.println("Books sorted by author:");
        for (LibraryBook<String> book : sortedByAuthor) {
            System.out.println(book);
        }

        // Test getOverdueList
        List<LibraryBook<String>> overdueBooks = lib1.getOverdueList();
        System.out.println("Overdue books:");
        for (LibraryBook<String> book : overdueBooks) {
            System.out.println(book);
        }

        System.out.println("Testing done.");
    }
}

