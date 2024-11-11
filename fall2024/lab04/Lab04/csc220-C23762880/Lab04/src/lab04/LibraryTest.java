package lab04;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.List;

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
    
    List<LibraryBook<Book>> orderedByAuthor = lib.getOrderedByAuthor();
    boolean authorSorted = true;
    boolean titleSorted = true;
    for (int i = 0; i < orderedByAuthor.size() - 1; i++) {
        LibraryBook<Book> book1 = orderedByAuthor.get(i);
        LibraryBook<Book> book2 = orderedByAuthor.get(i + 1);
        
        // Check if the current book's author is greater than or equal to the next book's author
        if (book1.getAuthor().compareTo(book2.getAuthor()) > 0) {
            authorSorted = false;
            break;
        } else if (book1.getAuthor().equals(book2.getAuthor())) {
            // If authors are the same, check if the title is sorted
            if (book1.getTitle().compareTo(book2.getTitle()) > 0) {
                titleSorted = false;
                break;
            }
        }
    }

    if (!authorSorted) {
        System.err.println("TEST FAILED -- getOrderedByAuthor: Books are not sorted by author");
    } else if (!titleSorted) {
        System.err.println("TEST FAILED -- getOrderedByAuthor: Books are not sorted by title as tie-breaker");
    }
    
    
    // Test getOverdueList with overdue books
    lib.checkout(9780140280094L, "Jane Doe", 1, 1, 2000); // Past due date
    lib.checkout(9780143039433L, "John Doe", 1, 1, 2020); // Not overdue

    List<LibraryBook<Book>> overdueList = lib.getOverdueList();
    boolean dueDateSorted = true;
    for (int i = 0; i < overdueList.size() - 1; i++) {
        GregorianCalendar date1 = overdueList.get(i).getDueDate();
        GregorianCalendar date2 = overdueList.get(i + 1).getDueDate();
        
        // Check if the current book's due date is greater than or equal to the next book's due date
        if (date1 != null && date2 != null && date1.compareTo(date2) > 0) {
            dueDateSorted = false;
            break;
        }
    }

    if (!dueDateSorted) {
        System.err.println("TEST FAILED -- getOverdueList: Books are not sorted by due date");
    } 


    System.out.println("Testing done.");
  }


}
