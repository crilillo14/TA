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
    System.out.println("Library size after addAll: " + lib.getInventoryList().size());

    
    ArrayList<LibraryBook<String>> inventoryList = (ArrayList<LibraryBook<String>>) lib.getInventoryList();
    if (inventoryList.size() != 26) {
      System.err.println("TEST FAILED -- medium library: inventory size should be 26, found " + inventoryList.size());
    } else {
      System.out.println("TEST PASSED -- medium library: correct inventory size of 26 books.");
    }
    
//     FILL IN your own tests below
//    
    List<LibraryBook<String>> orderedByAuthor = lib.getOrderedByAuthor();

    if (orderedByAuthor.size() != 26) {
      System.err.println("TEST FAILED -- getOrderedByAuthor: Expected 26 books, got " + orderedByAuthor.size());
    } else if (!orderedByAuthor.get(0).getAuthor().equals("Alan Burt Akers") || 
               !orderedByAuthor.get(1).getAuthor().equals("Anthony J D Burns")) {
      System.err.println("TEST FAILED -- getOrderedByAuthor: Incorrect ordering of books by author");
    } else {
      System.out.println("TEST PASSED -- getOrderedByAuthor: Correct ordering of books by author.");
    }
    
    lib.checkout(9781843190479L, "Jane Doe", 1, 1, 2020);  
    lib.checkout(9781843190011L, "John Smith", 1, 1, 2021); 

    List<LibraryBook<String>> overdueBooks = lib.getOverdueList();

    if (overdueBooks.size() != 2) {
      System.err.println("TEST FAILED -- getOverdueList: Expected 2 overdue books, found " + overdueBooks.size());
    } else if (!(overdueBooks.get(0).getIsbn() == 9781843190479L)) {
      System.err.println("TEST FAILED -- getOverdueList: Incorrect ordering by due date.");
    } else {
      System.out.println("TEST PASSED -- getOverdueList: Correct list of overdue books.");
    }
    
    
    System.out.println("Testing done.");
  }


}
