package lab04;

import java.util.ArrayList;
import java.util.GregorianCalendar;
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
    if (lib.lookup(9781843190004L) == null)
        System.err.println("TEST FAILED -- medium library: lookup(isbn)");
        
    if (!lib.checkout(9781843190004L, "Alice", 2, 15, 2022))
        System.err.println("TEST FAILED -- medium library: checkout(isbn)");

    if (lib.lookup(9781843190004L).equals("Alice"))
        System.out.println("Successfully checked out book with ISBN 9781843190004");

    if (!lib.checkin(9781843190004L))
        System.err.println("TEST FAILED -- medium library: checkin(isbn)");

    // Check another book to ensure correct functionality
    if (!lib.checkout(9781843190011L, "Bob", 3, 10, 2022))
        System.err.println("TEST FAILED -- medium library: checkout(isbn)");
        
    if (!lib.checkin(9781843190011L))
        System.err.println("TEST FAILED -- medium library: checkin(isbn)");

    System.out.println("Medium library tests completed.");

    System.out.println("Testing done.");
  }


}
