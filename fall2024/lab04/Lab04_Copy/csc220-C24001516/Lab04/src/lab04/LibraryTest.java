package lab04;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

/**
 * Testing class for Library.
 * 
 * 
 */
public class LibraryTest {

  public static void main(String[] args) {
    // test an empty library
    Library lib = new Library();

    if (lib.lookup(978037429279L) != null)
      System.err.println("TEST FAILED -- empty library: lookup(isbn)");
    
    ArrayList<LibraryBook> booksCheckedOut = lib.lookup("Jane Doe");
    
    if (booksCheckedOut == null || booksCheckedOut.size() != 0)
      System.err.println("TEST FAILED -- empty library: lookup(holder)");
    
    if (lib.checkout(978037429279L, "Jane Doe", 1, 1, 2008))
      System.err.println("TEST FAILED -- empty library: checkout");
    
    if (lib.checkin(978037429279L))
      System.err.println("TEST FAILED -- empty library: checkin(isbn)");
    
    if (lib.checkin("Jane Doe"))
      System.err.println("TEST FAILED -- empty library: checkin(holder)");

    // test a small library
    lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib.add(9780446580342L, "David Baldacci", "Simple Genius");

    if (lib.lookup(9780330351690L) != null)
      System.err.println("TEST FAILED -- small library: lookup(isbn)");    
    
    if (!lib.checkout(9780330351690L, "Jane Doe", 1, 1, 2008))
      System.err.println("TEST FAILED -- small library: checkout");
    
    booksCheckedOut = lib.lookup("Jane Doe");
        
    if (booksCheckedOut == null
        || booksCheckedOut.size() != 1
        || !booksCheckedOut.get(0).equals(
            new Book(9780330351690L, "Jon Krakauer", "Into the Wild"))
        || !booksCheckedOut.get(0).getHolder().equals("Jane Doe")
        || !booksCheckedOut.get(0).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1))){
      System.err.println("TEST FAILED -- small library: lookup(holder)");
    }
    if (!lib.checkin(9780330351690L))
      System.err.println("TEST FAILED -- small library: checkin(isbn)");
    if (lib.checkin("Jane Doe"))
      System.err.println("TEST FAILED -- small library: checkin(holder)");

    // test a medium library TODO: Assignment part 3
//    Library<phonenumber> lib2 = new Library();
    
    
    lib.addAll("Mushroom_Publishing.txt");
    System.out.println("overdue" + lib.getOverdueList());
    System.out.println("by author" + lib.getOrderedByAuthor() );
    
    // FILL IN your own tests below

    // Add books with different authors
    lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib.add(9780446580342L, "David Baldacci", "Simple Genius");
    lib.add(9780590353427L, "J.K. Rowling", "Harry Potter and the Sorcerer's Stone");

    // Get the list of books sorted by author
    List<LibraryBook<String>> orderedByAuthor = lib.getOrderedByAuthor();

    // Print the sorted list of books by author
    System.out.println("Books sorted by author:");
    for (LibraryBook<String> book : orderedByAuthor) {
        System.out.println(book.getAuthor() + " - " + book.getTitle());
    }

///////////////////////////////////////////////////////////////////////////
    // Add books to the library
    lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib.add(9780446580342L, "David Baldacci", "Simple Genius");
    lib.add(9780590353427L, "J.K. Rowling", "Harry Potter and the Sorcerer's Stone");

    // Checkout books with different due dates
    // Current date: let's assume it's 2023/12/01 (adjust for the actual test time)
    // Some dates will be overdue, some not

    // Overdue book (checked out with a past due date)
    lib.checkout(9780374292799L, "Jane Doe", 1, 1, 2023); // Due on January 1, 2023

    // Not overdue (due in the future)
    lib.checkout(9780330351690L, "John Smith", 12, 1, 2024); // Due on December 1, 2024

    // Overdue book (checked out with a past due date)
    lib.checkout(9780446580342L, "Alice Jones", 6, 1, 2023); // Due on June 1, 2023

    // Not overdue (due in the future)
    lib.checkout(9780590353427L, "Bob White", 11, 1, 2024); // Due on November 1, 2024

    // Get the list of overdue books
    List<LibraryBook<String>> overdueBooks = lib.getOverdueList();

    // Expected output: Two overdue books, sorted by the due date
    System.out.println("Overdue books list:");
    for (LibraryBook<String> book : overdueBooks) {
        System.out.println(book.getTitle() + " - Due on: " + book.getDueDate().getTime());
    }

    // Test if the overdue list contains the correct number of books
    if (overdueBooks.size() != 2) {
        System.err.println("TEST FAILED -- incorrect number of overdue books");
    } else {
        System.out.println("Overdue list test passed.");
    }

    // Verify the order of overdue books
    if (!overdueBooks.get(0).getTitle().equals("The World is Flat") ||
        !overdueBooks.get(1).getTitle().equals("Simple Genius")) {
        System.err.println("TEST FAILED -- overdue books not sorted correctly");
    } else {
        System.out.println("Overdue books are sorted correctly by due date.");
    }


    System.out.println(lib.getInventoryList());
    
    System.out.println("Testing done.");
  }


}
