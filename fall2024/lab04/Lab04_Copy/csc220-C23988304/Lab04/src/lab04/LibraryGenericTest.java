package lab04;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;


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
    
    // FOR LAB: write tests for getInventoryList
    
    System.out.println(lib2);
    lib2.add(9080330351690L, "John karuaker", "into the nothin");
    ArrayList<LibraryBook<PhoneNumber>> testList = lib2.getInventoryList();
    System.out.println(testList);
    
    Library<String> lib7 = new Library<String>();
    lib7.add(978190011,	"Moyra Caldecott" ,"The Eye of Callanish");
    lib7.add(978184319,	"Moyra Caldecott",	"Crystal Legends");
    
    
    
    
    
    
    Library<String> lib3 = new Library<String>();
    lib3.addAll("Mushroom_Publishing.txt");
    
	lib3.checkout(9781843190004L, "esteban1", 1, 1, 2025);
	lib3.checkout(9781843190011L, "esteban2", 4, 2, 2026);
	lib3.checkout(9781843190028L, "esteban3", 6, 2, 2014);
	lib3.checkout(9781843190042L, "esteban4", 3, 5, 2018);
	lib3.checkout(9781843190073L, "esteban5", 4, 2, 2002);
	lib3.checkout(9781843190110L, "esteban6", 6, 1, 2007);
	lib3.checkout(9781843190349L, "esteban7", 9, 4, 2009);
	lib3.checkout(9781843190363L, "esteban8", 8, 3, 2004);
	lib3.checkout(9781843190394L, "esteban9", 7, 2, 2011);
	lib3.checkout(9781843190400L, "esteban10", 6, 1, 2007);
	lib3.checkout(9781843190479L, "esteban11", 5, 3, 2003);
	lib3.checkout(9781843190516L, "esteban12", 4, 2, 2002);
	lib3.checkout(9781843190677L, "esteban13", 3, 1, 2001);
	lib3.checkout(9781843190769L, "esteban14", 2, 2, 2000);
	lib3.checkout(9781843190875L, "esteban15", 1, 3, 2004);
	lib3.checkout(9781843190936L, "esteban16", 2, 4, 2005);
	lib3.checkout(9781843190998L, "esteban17", 3, 5, 2006);
	lib3.checkout(9781843191230L, "esteban18", 4, 6, 2007);
	
	List<LibraryBook<String>> tester = lib3.getOverdueList();
	for (int index = 0; index < tester.size(); index++) {
		if (tester.get(index).getDueDate() != null) {
			System.out.println(tester.get(index).getDueDate().getTime());

		}
		
	}// end of for loop
    
    
    
    
    

    
    
    
    
    
    // test a medium library: you will use this for homework
    Library<String> lib21 = new Library<String>();    
    lib21.addAll("Mushroom_Publishing.txt");
    
    
    
    List<LibraryBook<String>> ohyeah = lib21.getOrderedByAuthor();
    
    for(int index = 0; index < ohyeah.size(); index++) {
    	
    	System.out.print(ohyeah.get(index).getAuthor() + " ");
    	System.out.println(ohyeah.get(index).getTitle());
    
    	
    }
    
    
    
    
  }
}
