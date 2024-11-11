package lab04;

import java.util.ArrayList;
import java.util.Calendar;
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
    Library<Integer> lib3 = new Library<Integer>();
    lib3.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib3.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib3.add(9780446580342L, "David Baldacci", "Simple Genius");
    
    Integer patron3 = 234;
    
    if (!lib3.checkout(9780374292799L, patron3, 1, 1, 2008))
        System.err.println("TEST FAILED: first checkout");
    if (lib3.checkout(1234567L, patron3, 1, 1, 2008))
        System.err.println("TEST FAILED: second checkout");
    ArrayList<LibraryBook<Integer>> booksCheckedOut3 = lib3.lookup(patron3);
    if (booksCheckedOut3 == null || booksCheckedOut3.size() != 1)
    	System.err.println("TEST FAILED: lookup");
    
    // FOR LAB: write tests for getInventoryList
    ArrayList<LibraryBook<String>> invList1 = lib1.getInventoryList();
    long prevValue = 0L;
    for (int i = 0; i < invList1.size(); i++) {
    	
    	if (invList1.get(i).getIsbn() < prevValue)
			System.err.println("TEST FAILED: sort");
    	
    	prevValue = invList1.get(i).getIsbn();
    }
    
    // test a medium library: you will use this for homework
    Library<String> lib4 = new Library<String>();    
    lib4.addAll("Mushroom_Publishing.txt");
    
    // things to test
    // (1) getInventoryList
    // (2) getOrderedByAuthor
    // (3) getOverdueList
    
    ArrayList<LibraryBook<String>> inv4a = lib4.getInventoryList();
    if (inv4a.size() == 0)
    	System.err.println("TEST FAILED: addAll");
    for (int i = 1; i < inv4a.size(); i++) {
    	if (inv4a.get(i).getIsbn() < inv4a.get(i-1).getIsbn())
    		System.err.println("TEST FAILED: getInventoryList");
    }
    
    ArrayList<LibraryBook<String>> inv4b = (ArrayList<LibraryBook<String>>) lib4.getOrderedByAuthor();
    if (inv4b.size() == 0)
    	System.err.println("TEST FAILED: getOrderedByAuthor");
    for (int i = 1; i < inv4b.size(); i++) {
    	if (inv4b.get(i).getAuthor().charAt(0) < inv4b.get(i-1).getAuthor().charAt(0))
    		System.err.println("TEST FAILED: getOrderedByAuthor");
    }
    
    ArrayList<LibraryBook<String>> inv4c = (ArrayList<LibraryBook<String>>) lib4.getOverdueList();
    if (inv4c.size() != 0)
    	System.err.println("TEST FAILED: getOverdueList");
    lib4.checkout(9781843190936L, "Brendan W.", Calendar.APRIL, 10, 2008);
    lib4.checkout(9781843192039L, "Brendan W.", Calendar.MAY, 10, 2008);
    lib4.checkout(9781843190073L, "Emmanuel H.", Calendar.JANUARY, 1, 2010);
    
    inv4c = (ArrayList<LibraryBook<String>>) lib4.getOverdueList();
    if (inv4c.size() == 0)
    	System.err.println("TEST FAILED: getOverdueList");
    for (int i = 1; i < inv4c.size(); i++) {
    	GregorianCalendar currIt = inv4c.get(i).getDueDate();
    	GregorianCalendar prevIt = inv4c.get(i-1).getDueDate();
    	
    	if (currIt.get(GregorianCalendar.YEAR) < prevIt.get(GregorianCalendar.YEAR))
    		System.err.println("TEST FAILED: getOverdueList");
    	else if (currIt.get(GregorianCalendar.YEAR) == prevIt.get(GregorianCalendar.YEAR)
    			&& currIt.get(GregorianCalendar.MONTH) < prevIt.get(GregorianCalendar.MONTH))
    		System.err.println("TEST FAILED: getOverdueList");
    }
    
    
  }
}
