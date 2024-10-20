package lab04;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Testing class for Library.
 * 
 * 
 */
public class LibraryTest 
{

  public static void main(String[] args) 
  {
    // Testing an empty library
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

    // Testing a small library
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
            new GregorianCalendar(2008, 1, 1)))
    {
      System.err.println("TEST FAILED -- small library: lookup(holder)");
    }
    if (!lib.checkin(9780330351690L))
      System.err.println("TEST FAILED -- small library: checkin(isbn)");
    if (lib.checkin("Jane Doe"))
      System.err.println("TEST FAILED -- small library: checkin(holder)");

    // TODO: Assignment part 3
    lib.addAll("Mushroom_Publishing.txt");
    
    // FILL IN your own tests below
    
 // Test Case #1: Checking out a non-existent book in the library
    if (lib.checkout(9999999999999L, "John Doe", 6, 10, 2023)) 
    {
        System.err.println("TEST FAILED -- allowed checkout of non-existent book.");
    }
       
 // Test Case #2: Checking in books by specific holder
    lib.add(9780679783268L, "George Orwell", "Animal Farm");
    lib.checkout(9780679783268L, "Alice", 5, 10, 2024);

    lib.add(9780061120084L, "Harper Lee", "To Kill a Mockingbird");
    lib.checkout(9780061120084L, "Alice", 6, 15, 2024);

    if (!lib.checkin("Alice")) 
    {
        System.err.println("TEST FAILED -- failed to check in all books by holder.");
    }

    ArrayList<LibraryBook<String>> aliceBooks = lib.lookup("Alice");
    if (aliceBooks != null && !aliceBooks.isEmpty()) 
    {
        System.err.println("TEST FAILED -- some books are still checked out after check-in by holder.");
    }

 // Test Case #3: Checking out multiple books by the same user
    lib.add(9780142415436L, "John Steinbeck", "Of Mice and Men");
    lib.add(9780316769488L, "J.D. Salinger", "The Catcher in the Rye");

    lib.checkout(9780142415436L, "Sam", 4, 10, 2024);
    lib.checkout(9780316769488L, "Sam", 5, 10, 2024);

    ArrayList<LibraryBook<String>> samBooks = lib.lookup("Sam");
    if (samBooks.size() != 2) 
    {
        System.err.println("TEST FAILED -- user should have two books checked out.");
    }
    
 // Test Case #4: Checking in a book that hasn't been checked out previously
    if (lib.checkin(9780374292799L)) 
    {
        System.err.println("TEST FAILED -- allowed check-in for a book that wasn't checked out.");
    } 
    
 // Test Case #5: Printing an overdue list of books from the library

    // Checkout a couple of books with past due dates
    lib.checkout(9780330351690L, "Jane Doe", 1, 1, 2022); // This should be an overdue book
    lib.checkout(9780374292799L, "John Smith", 1, 1, 2025); // This should not be an overdue book

    List<LibraryBook<String>> overdueBooks = lib.getOverdueList();
    System.out.println("Overdue Books in the Library:");
    for (LibraryBook<String> book : overdueBooks) 
    {
      System.out.println(book.getIsbn() + ": " + book.getTitle() + " (Due: " + book.getDueDate().getTime() + ")");
    }
    
    System.out.println("Testing done.");
  }


}
