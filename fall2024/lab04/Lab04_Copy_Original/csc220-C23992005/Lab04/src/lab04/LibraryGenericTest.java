package lab04;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Testing class for generic Library.
 *
 */
public class LibraryGenericTest 
{

  public static void main(String[] args) 
  {

    // test a library that uses names (String) to id patrons
    Library<String> lib1 = new Library<String>();
    lib1.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib1.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib1.add(9780446580342L, "David Baldacci", "Simple Genius");

    String patron1 = "Jane Doe";

    if (!lib1.checkout(9780330351690L, patron1, 1, 1, 2008))
      System.err.println("TEST FAILED: first checkout");
    if (!lib1.checkout(9780374292799L, patron1, 1, 1, 2008))
      System.err.println("TEST FAILED: second checkout");
    ArrayList<LibraryBook<String>> booksCheckedOut1 = lib1
        .lookup(patron1);
    if (booksCheckedOut1 == null
        || booksCheckedOut1.size() != 2
        || !booksCheckedOut1.contains(new Book(9780330351690L, "Jon Krakauer",
            "Into the Wild"))
        || !booksCheckedOut1.contains(new Book(9780374292799L,
            "Thomas L. Friedman", "The World is Flat"))
        || !booksCheckedOut1.get(0).getHolder().equals(patron1)
        || !booksCheckedOut1.get(0).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1))
        || !booksCheckedOut1.get(1).getHolder().equals(patron1)
        || !booksCheckedOut1.get(1).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1)))
      System.err.println("TEST FAILED: lookup(holder)");
    if (!lib1.checkin(patron1))
      System.err.println("TEST FAILED: checkin(holder)");

    // test a library that uses phone numbers (PhoneNumber) to id patrons
    Library<PhoneNumber> lib2 = new Library<PhoneNumber>();
    lib2.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib2.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib2.add(9780446580342L, "David Baldacci", "Simple Genius");

    PhoneNumber patron2 = new PhoneNumber("305.555.1234");

    if (!lib2.checkout(9780330351690L, patron2, 1, 1, 2008))
      System.err.println("TEST FAILED: first checkout");
    if (!lib2.checkout(9780374292799L, patron2, 1, 1, 2008))
      System.err.println("TEST FAILED: second checkout");
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
            new GregorianCalendar(2008, 1, 1)))
      System.err.println("TEST FAILED: lookup(holder)");
    if (!lib2.checkin(patron2))                           
      System.err.println("TEST FAILED: checkin(holder)");
    
    System.out.println("Testing done.");
    
    // FILL IN for tests
    
    // Test Case #1: getInventoryList() method iteration
    ArrayList<LibraryBook<String>> inventory = lib1.getInventoryList();
    if(inventory.size() != 3 || inventory.get(0).getIsbn() != 9780330351690L 
    		|| inventory.get(1).getIsbn() != 9780374292799L || inventory.get(2).getIsbn() != 9780446580342L )
    {
    	System.err.println("Test Failed: getInventoryList()");
    }
    else
    {
    	System.out.println("Test Passed: getInventoryList()");
    }
    
    // Test Case #2: getOrderedByAuthor() method iteration
    List<LibraryBook<String>> orderedByAuthor = lib1.getOrderedByAuthor();
    if (orderedByAuthor.size() != 3
        || !orderedByAuthor.get(0).getAuthor().equals("David Baldacci")
        || !orderedByAuthor.get(1).getAuthor().equals("Jon Krakauer")
        || !orderedByAuthor.get(2).getAuthor().equals("Thomas L. Friedman")) 
    {
        System.err.println("TEST FAILED: getOrderedByAuthor()");
    } 
    else 
    {
        System.out.println("Test Passed: getOrderedByAuthor()");
    }
    

    // Checking out a couple of books with due dates in the past
    lib1.checkout(9780330351690L, patron1, 1, 1, 2020);  // This should be overdue, as 2020 is from the past
    lib1.checkout(9780374292799L, patron1, 1, 1, 2025);  // This is not supposed to be overdue, as 2025 is from the future

    // Test Case #3: getOverdueList() method iteration
    List<LibraryBook<String>> overdueList = lib1.getOverdueList();
    if (overdueList.size() != 1 || overdueList.get(0).getIsbn() != 9780330351690L) 
    {
        System.err.println("TEST FAILED: getOverdueList()");
    } 
    else 
    {
        System.out.println("Test Passed: getOverdueList()");
    }
    
    System.out.println("Testing done.");
    
    // Test a medium library: you will use this for homework
    Library<String> lib3 = new Library<String>();
    
    lib3.addAll("Mushroom_Publishing.txt");

    // Test Case #4: Checking whether the books from the file were added (as it provided some specific ISBNs from the file)
    ArrayList<LibraryBook<String>> inventory3 = lib3.getInventoryList();

    // Checking with ISBN's in the Mushroom_Publishing.txt
    
    long knownISBN1 = 9781843192701L;
    long knownISBN2 = 9781843192954L;
    long knownISBN3 = 9781843193319L;

    boolean foundISBN1 = false;
    boolean foundISBN2 = false;
    boolean foundISBN3 = false;

    for (LibraryBook<String> book : inventory3) 
    {
        if (book.getIsbn() == knownISBN1) 
        {
            foundISBN1 = true;
        }
        if (book.getIsbn() == knownISBN2) 
        {
            foundISBN2 = true;
        }
        if (book.getIsbn() == knownISBN3) 
        {
            foundISBN3 = true;
        }
    }

    if (!foundISBN1 || !foundISBN2 || !foundISBN3) 
    {
        System.err.println("TEST FAILED: Not all known books from the file were added to the inventory.");
    } 
    else 
    {
        System.out.println("Test Passed: All known books from the file were found in the inventory.");
    }

    String patron3 = "John Doe";

    // Test Case #5: Checking out a known book from the file
    if (!lib3.checkout(knownISBN1, patron3, 5, 20, 2024)) 
    {
        System.err.println("TEST FAILED: failed to checkout a book from the medium library.");
    } 
    else 
    {
        System.out.println("Test Passed: Successfully checked out a book from the medium library.");
    }

    // Test Case #6: Look up of the patron's checked out books in the library
    ArrayList<LibraryBook<String>> booksCheckedOut3 = lib3.lookup(patron3);
    if (booksCheckedOut3 == null || booksCheckedOut3.size() != 1 || booksCheckedOut3.get(0).getIsbn() != knownISBN1) 
    {
        System.err.println("TEST FAILED: lookup of books checked out by patron from medium-sized library.");
    } 
    else 
    {
        System.out.println("Test Passed: Lookup of books checked out by patron from medium-sized library.");
    }

    // Test Case #7: Check-in of the book from the medium-sized library
    if (!lib3.checkin(knownISBN1)) 
    {
        System.err.println("TEST FAILED: failed to check in a book from the medium-sized library.");
    } 
    else 
    {
        System.out.println("Test Passed: Successfully checked in a book from the medium-sized library.");
    }

    System.out.println("Testing done for the medium-sized library.");

    
  }
}
