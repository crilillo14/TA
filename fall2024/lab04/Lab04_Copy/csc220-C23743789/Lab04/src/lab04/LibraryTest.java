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
    lib.addAll("Mushroom_Publishing.txt");
    
    
    // FILL IN your own tests below
    List<LibraryBook<String>> sortedByAuthor = lib.getOrderedByAuthor();

    if (!sortedByAuthor.get(0).getAuthor().equals("Alan Burt Akers") ||
        !sortedByAuthor.get(0).getTitle().equals("Transit to Scorpio")) {
        System.err.println("TEST FAILED -- medium library: getOrderedByAuthor() first book");
    }

    if (!sortedByAuthor.get(sortedByAuthor.size() - 1).getAuthor().equals("William Fitzmaurice") ||
        !sortedByAuthor.get(sortedByAuthor.size() - 1).getTitle().equals("Operation: Sergeant York")) {
        System.err.println("TEST FAILED -- medium library: getOrderedByAuthor() last book");
    }

    List<LibraryBook<String>> overdueBooks = lib.getOverdueList();
    if (overdueBooks.size() != 0) {
        System.err.println("TEST FAILED -- medium library: getOverdueList() no overdue books");
    }

    lib.checkout(9781843190004L, "Alice", 1, 1, 2023); // Moyra Caldecott, "Weapons of the Wolfhound"
    lib.checkout(9781843190394L, "Bob", 1, 1, 2021); // Kate Clarke, "The Royal United Hospital"
    lib.checkout(9781843192701L, "Charlie", 1, 1, 2022); // Moyra Caldecott, "The Lily and the Bull"

    overdueBooks = lib.getOverdueList();

    if (overdueBooks.size() != 3 ||
        !overdueBooks.get(0).getTitle().equals("The Royal United Hospital") || 
        !overdueBooks.get(1).getTitle().equals("The Lily and the Bull") ||
        !overdueBooks.get(2).getTitle().equals("Weapons of the Wolfhound")) {
        System.err.println("TEST FAILED -- medium library: getOverdueList() after checkout");
    }

    System.out.println("Testing done.");
    
  }


}
