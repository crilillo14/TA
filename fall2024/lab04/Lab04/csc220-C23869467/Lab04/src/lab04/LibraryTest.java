package lab04;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Testing class for Library.
 */
public class LibraryTest {

  public static void main(String[] args) {
    // test an empty library
    Library<String> lib = new Library<>();

    if (lib.lookup(978037429279L) != null)
      System.err.println("TEST FAILED -- empty library: lookup(isbn)");
    
    ArrayList<LibraryBook<String>> booksCheckedOut = lib.lookup("Jane Doe");
    
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

    
    
    // Test getOrderedByAuthor
    System.out.println("\nTesting getOrderedByAuthor:");
    ArrayList<LibraryBook<String>> orderedByAuthor = lib.getOrderedByAuthor();
    for (LibraryBook<String> book : orderedByAuthor) {
        System.out.println(book);
    }

    // Test getOverdueList
    System.out.println("\nTesting getOverdueList:");
    lib.checkout(9780330351690L, "John Doe", 1, 1, 2020); // Overdue
    lib.checkout(9780446580342L, "Michael", 6, 15, 2020); // Overdue
    lib.checkout(9780374292799L, "Emily", 12, 31, 2023); // Not overdue
   
    ArrayList<LibraryBook<String>> overdueBooks = lib.getOverdueList();
    for (LibraryBook<String> book : overdueBooks) {
        System.out.println(book);
    }

    
    
    
 // New tests using PhoneNumber as the holder type
    System.out.println("\nTesting with PhoneNumber as holder:");
    Library<PhoneNumber> libPhone = new Library<>();

    // Add books to the library with PhoneNumber holders
    PhoneNumber holder1 = new PhoneNumber("123-456-7890");
    PhoneNumber holder2 = new PhoneNumber("987-654-3210");

    libPhone.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    libPhone.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    libPhone.add(9780446580342L, "David Baldacci", "Simple Genius");

    // Checkout books with PhoneNumber holders
    libPhone.checkout(9780330351690L, holder1, 1, 1, 2022); // Overdue
    libPhone.checkout(9780446580342L, holder2, 6, 15, 2023); // Not overdue

    // Test lookup by ISBN
    PhoneNumber lookupPhoneHolder = libPhone.lookup(9780330351690L); // Should return holder1
    if (lookupPhoneHolder == null || !lookupPhoneHolder.equals(holder1)) {
        System.err.println("TEST FAILED -- PhoneNumber holder lookup by ISBN");
    } else {
        System.out.println("Lookup by ISBN 9780330351690L: Holder is " + lookupPhoneHolder);
    }

    // Test lookup by holder
    ArrayList<LibraryBook<PhoneNumber>> booksCheckedOutPhone = libPhone.lookup(holder1); // Correctly using PhoneNumber
    if (booksCheckedOutPhone == null || booksCheckedOutPhone.size() != 1) {
        System.err.println("TEST FAILED -- PhoneNumber holder lookup by holder");
    } else {
        System.out.println("Lookup by holder " + holder1 + ": " + booksCheckedOutPhone.get(0));
    }

    // Test checkin by ISBN
    boolean checkinByIsbnPhone = libPhone.checkin(9780330351690L); // Should return true
    if (!checkinByIsbnPhone) {
        System.err.println("TEST FAILED -- PhoneNumber holder checkin by ISBN");
    } else {
        System.out.println("Checkin by ISBN 9780330351690L: Success");
    }

    // Test checkin by holder
    boolean checkinByHolderPhone = libPhone.checkin(holder1); // Should return false (already checked in)
    if (checkinByHolderPhone) {
        System.err.println("TEST FAILED -- PhoneNumber holder checkin by holder");
    } else {
        System.out.println("Checkin by holder " + holder1 + ": Already checked in");
    }

    
    
    

    System.out.println("Testing done");
  }
}
