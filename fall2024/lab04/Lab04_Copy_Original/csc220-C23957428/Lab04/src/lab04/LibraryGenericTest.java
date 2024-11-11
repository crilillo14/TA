package lab04;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Testing class for generic Library.
 *z
 */
public class LibraryGenericTest {

  public static void main(String[] args) {

	  
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
    
    // FOR LAB: write tests for getInventoryList
    
    ArrayList<LibraryBook<String>> testList1 = lib1.getInventoryList();
    if (testList1 == null 
    		|| testList1.size() != 3
    		|| testList1.get(0).getIsbn() != 9780330351690L
    		|| testList1.get(1).getIsbn() != 9780374292799L
    		|| testList1.get(2).getIsbn() != 9780446580342L) {
    	System.out.println("Test Failed: getInventoryList Lib1");
    } else {
    	System.out.println("Test Passed: getInventoryList Lib1");
    }
    
    
    ArrayList<LibraryBook<PhoneNumber>> testList2 = lib2.getInventoryList();
    if (testList2 == null 
    		|| testList2.get(0).getIsbn() != 9780330351690L
    		|| testList2.get(1).getIsbn() != 9780374292799L
    		|| testList2.get(2).getIsbn() != 9780446580342L) {
    	System.out.println("Test Failed: getInventoryList Lib1");
    } else {
    	System.out.println("Test Passed: getInventoryList Lib2");
    }
    
    
    
    Library<String> testLibrary = new Library<>();
    
    testLibrary.add(1234567890L, "Miguel Blas", "CSC 220");
    testLibrary.add(98765432L, "Declan Foley", "Intro to Engineering");
    testLibrary.add(2468097531L, "Ryan Dominguez", "Political Science Theory");
    testLibrary.add(1357908642L, "Jonathan Hooks", "ITD Basics");
    
    // tests the getOrderedByAuthor() method
    List<LibraryBook<String>> orderedByAuthor = testLibrary.getOrderedByAuthor();
    System.out.println("Books ordered by Author: " );
    for( LibraryBook<String> book : orderedByAuthor ) {
    	System.out.println(book.getAuthor() + " - " + book.getTitle());
    }
    
    GregorianCalendar OverDueDate = new GregorianCalendar (2023, 8, 18);
    GregorianCalendar FutureDate = new GregorianCalendar (2025, 8, 18);
    
    testLibrary.checkout(1234567890L, "John", OverDueDate.get(Calendar.MONTH), OverDueDate.get(Calendar.DAY_OF_MONTH), OverDueDate.get(Calendar.YEAR));
    testLibrary.checkout(98765432L, "Jane", FutureDate.get(Calendar.MONTH), FutureDate.get(Calendar.DAY_OF_MONTH), FutureDate.get(Calendar.YEAR));
    testLibrary.checkout(2468097531L, "Jack", FutureDate.get(Calendar.MONTH), FutureDate.get(Calendar.DAY_OF_MONTH), FutureDate.get(Calendar.YEAR));
    
    // tests the getOverdueList() method
    List<LibraryBook<String>> OverDueList = testLibrary.getOverdueList();
    System.out.println("Overdue Books: ");
    for ( LibraryBook<String> book : OverDueList ) {
    	System.out.println(book.getAuthor() + " - " + book.getTitle() + " (Due: " + book.getDueDate().getTime() + ")");
    }
    
    
    // test a medium library: you will use this for homework
    // Library<String> lib3 = new Library<String>();    
    // lib3.addAll("Mushroom_Publishing.txt");
    
  }
}
