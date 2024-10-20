package lab04;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Testing class for generic Library.
 *
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
    lib2.add(9912345678573L, "Andy Dietel", "Book");
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
    
//    lib2.add(6912345678573L, "Andy Dietel", "Book2");
//    lib2.add(6912345678574L, "Andy Dietel", "Book2");
    
//    for (int i = 0; i < lib2.getInventoryList().size(); i++) {
//    	System.out.println(lib2.getInventoryList().get(i).getIsbn());
//    }
    
    
    
//    for (int i = 0; i < lib1.getInventoryList().size(); i++) {
//    	System.out.println(lib1.getInventoryList().get(i).getIsbn());
//    }
    
//    Library<String> lib3 = new Library<String>();
//    lib3.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
 
//    for (int i = 0; i < lib3.getInventoryList().size(); i++) {
//    	System.out.println(lib3.getInventoryList().get(i).getIsbn());
//    }
// 
//    Library<String> lib4 = new Library<String>(); lib3.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
// 
//    for (int i = 0; i < lib4.getInventoryList().size(); i++) {
//    	System.out.println(lib4.getInventoryList().get(i).getIsbn());
//    
    
    // test a medium library: you will use this for homework
//    Library<String> lib3 = new Library<String>();    
//    lib3.addAll("Mushroom_Publishing.txt");
//    lib3.checkout(9781843190004L, "Andy Dietel", 9, 15, 2024);
//    lib3.checkout(9781843190011L, "Andy Dietel", 6, 13, 2023);
//    lib3.checkout(9781843190028L, "Andy Dietel", 1, 13, 2023);
//    lib3.checkout(9781843190042L, "Andy Dietel", 6, 12, 2023);
//    lib3.checkout(9781843190073L, "Andy Dietel", 5, 13, 2023);
//    lib3.checkout(9781843190110L, "Andy Dietel", 4, 13, 2023);
//    
// 
//    for (int i = 0; i < lib3.getOverdueList().size(); i++) {
//    	GregorianCalendar test = lib3.getOverdueList().get(i).getDueDate();
//    	System.out.println(test.get(test.MONTH) + " : " + test.get(test.DAY_OF_MONTH) + " : " + test.get(test.YEAR));
//    }
//    
//    for (int i = 0; i < lib3.getOrderedByAuthor().size(); i++) {
//    	System.out.println(lib3.getOrderedByAuthor().get(i).getAuthor());
//    }
//    
//    
//    Library<String> lib4 = new Library<String>();
//    for (int i = 0; i < lib4.getOrderedByAuthor().size(); i++) {
//    	System.out.println(lib4.getOrderedByAuthor().get(i).getAuthor());
//    }
//    
//    for (int i = 0; i < lib4.getOverdueList().size(); i++) {
//    	GregorianCalendar test = lib4.getOverdueList().get(i).getDueDate();
//    	System.out.println(test.get(test.MONTH) + " : " + test.get(test.DAY_OF_MONTH) + " : " + test.get(test.YEAR));
//    }
//    
//    lib4.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
//    lib4.checkout(9780374292799L, "Andy Dietel", 1, 13, 2023);
//    
//    for (int i = 0; i < lib4.getOrderedByAuthor().size(); i++) {
//    	System.out.println(lib4.getOrderedByAuthor().get(i).getAuthor());
//    }
//    
//    for (int i = 0; i < lib4.getOverdueList().size(); i++) {
//    	GregorianCalendar test = lib4.getOverdueList().get(i).getDueDate();
//    	System.out.println(test.get(test.MONTH) + " : " + test.get(test.DAY_OF_MONTH) + " : " + test.get(test.YEAR));
//    }
//    
    
//    
    
  }
}
