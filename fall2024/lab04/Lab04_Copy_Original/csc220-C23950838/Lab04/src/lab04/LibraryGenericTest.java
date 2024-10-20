package lab04;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

/**
 * Testing class for generic Library.
 *
 */
public class LibraryGenericTest {

  public static void main(String[] args) {

//    // test a library that uses names (String) to id patrons
//    Library<String> lib1 = new Library<String>();
//    lib1.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
//    lib1.add(9780330351690L, "Jon Krakauer", "Into the Wild");
//    lib1.add(9780446580342L, "David Baldacci", "Simple Genius");
//
//    String patron1 = "Jane Doe";
//
//    if (!lib1.checkout(9780330351690L, patron1, 1, 1, 2008))
//      System.err.println("TEST FAILED: first checkout");
//    if (!lib1.checkout(9780374292799L, patron1, 1, 1, 2008))
//      System.err.println("TEST FAILED: second checkout");
//    ArrayList<LibraryBook<String>> booksCheckedOut1 = lib1
//        .lookup(patron1);
//    if (booksCheckedOut1 == null
//        || booksCheckedOut1.size() != 2
//        || !booksCheckedOut1.contains(new Book(9780330351690L, "Jon Krakauer",
//            "Into the Wild"))
//        || !booksCheckedOut1.contains(new Book(9780374292799L,
//            "Thomas L. Friedman", "The World is Flat"))
//        || !booksCheckedOut1.get(0).getHolder().equals(patron1)
//        || !booksCheckedOut1.get(0).getDueDate().equals(
//            new GregorianCalendar(2008, 1, 1))
//        || !booksCheckedOut1.get(1).getHolder().equals(patron1)
//        || !booksCheckedOut1.get(1).getDueDate().equals(
//            new GregorianCalendar(2008, 1, 1)))
//      System.err.println("TEST FAILED: lookup(holder)");
//    if (!lib1.checkin(patron1))
//      System.err.println("TEST FAILED: checkin(holder)");
//
//    // test a library that uses phone numbers (PhoneNumber) to id patrons
//    Library<PhoneNumber> lib2 = new Library<PhoneNumber>();
//    lib2.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
//    lib2.add(9780330351690L, "Jon Krakauer", "Into the Wild");
//    lib2.add(9780446580342L, "David Baldacci", "Simple Genius");
//
//    PhoneNumber patron2 = new PhoneNumber("305.555.1234");
//
//    if (!lib2.checkout(9780330351690L, patron2, 1, 1, 2008))
//      System.err.println("TEST FAILED: first checkout");
//    if (!lib2.checkout(9780374292799L, patron2, 1, 1, 2008))
//      System.err.println("TEST FAILED: second checkout");
//    ArrayList<LibraryBook<PhoneNumber>> booksCheckedOut2 = lib2
//        .lookup(patron2);
//    if (booksCheckedOut2 == null
//        || booksCheckedOut2.size() != 2
//        || !booksCheckedOut2.contains(new Book(9780330351690L, "Jon Krakauer",
//            "Into the Wild"))
//        || !booksCheckedOut2.contains(new Book(9780374292799L,
//            "Thomas L. Friedman", "The World is Flat"))
//        || !booksCheckedOut2.get(0).getHolder().equals(patron2)
//        || !booksCheckedOut2.get(0).getDueDate().equals(
//            new GregorianCalendar(2008, 1, 1))
//        || !booksCheckedOut2.get(1).getHolder().equals(patron2)
//        || !booksCheckedOut2.get(1).getDueDate().equals(
//            new GregorianCalendar(2008, 1, 1)))
//      System.err.println("TEST FAILED: lookup(holder)");
//    if (!lib2.checkin(patron2))                           
//      System.err.println("TEST FAILED: checkin(holder)");
//    
//    System.out.println("Testing done.");
//    
//    // FILL IN for tests
//    
//    // FOR LAB: write tests for getInventoryList
//    
//    System.out.println("Books in lib1: ");
//    int index;
//    
//    Library<String> theLibrary = new Library<String>();
//    Library<PhoneNumber> phoneLibrary = new Library<PhoneNumber>();
//    
//    ArrayList<LibraryBook<String>> lib1books = new ArrayList<LibraryBook<String>>();
//    ArrayList<LibraryBook<PhoneNumber>> lib2books = new ArrayList<LibraryBook<PhoneNumber>>();
//    
//    System.out.println("0 books before sorting: ");
//    
//    for (index = 0; index < lib1books.size(); ++index) {
//    	System.out.println(lib1books.get(index));
//	}
//    
//    for (index = 0; index < lib2books.size(); ++index) {
//    	System.out.println(lib2books.get(index));
//	}
//    
//    System.out.println("0 books after sorting: ");
//    
//    for (index = 0; index < theLibrary.getInventoryList().size(); ++index) {
//    	System.out.println(theLibrary.getInventoryList().get(index));
//    }
//    
//    for (index = 0; index < phoneLibrary.getInventoryList().size(); ++index) {
//    	System.out.println(phoneLibrary.getInventoryList().get(index));
//    }
//    
//
//    LibraryBook<String> book1 = new LibraryBook<String>(5780374292799L, "Thomas L. Friedman", "The World is Flat");
//    LibraryBook<String> book2 = new LibraryBook<String>(4780330351690L, "John Krakenhouse", "Into the Wild");
//    LibraryBook<String> book3 = new LibraryBook<String>(1780446580342L, "David Baldacci", "Simple Genius");
//    LibraryBook<PhoneNumber> book4 = new LibraryBook<PhoneNumber>(3780374292799L, "Richard Sweeney", "The Earth is a Rhombicosidodecahedron");
//    LibraryBook<String> book5 = new LibraryBook<String>(6780330351690L, "John Krakenhouse", "Into the Unknown");
//    LibraryBook<PhoneNumber> book6 = new LibraryBook<PhoneNumber>(7780446580342L, "Homer Simpson", "D'OH!");
//    LibraryBook<PhoneNumber> book7 = new LibraryBook<PhoneNumber>(2340446580342L, "Ninja Muffin", "Friday Night Funkin'");
//    
//    lib1books.add(book1);
//    lib1books.add(book2);
//    lib1books.add(book3);
//    lib2books.add(book4);
//    lib1books.add(book5);
//    lib2books.add(book6);
//    lib2books.add(book7);
//    
//    theLibrary.addAll(lib1books);
//    phoneLibrary.addAll(lib2books);
//  
//    System.out.println("4 books before sorting by ISBN: ");
//    
//    for (index = 0; index < lib1books.size(); ++index) {
//    	System.out.println(lib1books.get(index));
//	}
//    
//    System.out.println("4 books after sorting by ISBN: ");
//    
//    for (index = 0; index < theLibrary.getInventoryList().size(); ++index) {
//    	System.out.println(theLibrary.getInventoryList().get(index));
//    }
//    
//    System.out.println("4 books after sorting by author: ");
//    
//    for (index = 0; index < theLibrary.getOrderedByAuthor().size(); ++index) {
//    	System.out.println(theLibrary.getOrderedByAuthor().get(index));
//    }
//    
//    System.out.println("3 phone number books before sorting by ISBN: ");
//    
//    for (index = 0; index < lib2books.size(); ++index) {
//    	System.out.println(lib2books.get(index));
//	}
//    
//    System.out.println("3 phone number books after sorting by ISBN: ");
//    
//    for (index = 0; index < phoneLibrary.getInventoryList().size(); ++index) {
//    	System.out.println(phoneLibrary.getInventoryList().get(index));
//    }
//    
//    System.out.println("3 books after sorting by author: ");
//    
//    for (index = 0; index < phoneLibrary.getOrderedByAuthor().size(); ++index) {
//    	System.out.println(phoneLibrary.getOrderedByAuthor().get(index));
//    }
    
    // test a medium library: you will use this for homework
    Library<String> lib3 = new Library<String>();    
    lib3.addAll("Mushroom_Publishing.txt");
    
    int index;
    ArrayList<LibraryBook<String>> bookList = new ArrayList<LibraryBook<String>>();
    bookList = lib3.getInventoryList();
    
    System.out.println("getInventoryList: ");
    for (index = 0; index < bookList.size(); ++index) {
    	System.out.println(bookList.get(index));
    }
    
    System.out.println("getOrderedByAuthor: ");
    for (index = 0; index < lib3.getOrderedByAuthor().size(); ++index) {
    	System.out.println(lib3.getOrderedByAuthor().get(index));
    }
    
    System.out.println("getOverdueList: (no books checked out, returns empty list)");
    for (index = 0; index < lib3.getOverdueList().size(); ++index) {
    	System.out.println(lib3.getOverdueList().get(index));
    }
    
    lib3.checkout(9781843190004L, "Taylor Slow", 10, 30, 2010); // Mid-value overdue
    lib3.checkout(9781843190011L, "Taylor Moderate-Pace", 10, 30, 2005); // Most overdue
    lib3.checkout(9781843192039L, "Taylor Swift", 10, 30, 2085); // Not overdue
    lib3.checkout(9781843190028L, "Taylor Lightspeed", 10, 30, 2023); // Least overdue
    
    System.out.println("getOverdueList: should return 3 books");
    for (index = 0; index < lib3.getOverdueList().size(); ++index) {
    	System.out.println(lib3.getOverdueList().get(index));
    }
    
  }
}
