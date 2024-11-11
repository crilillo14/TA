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
    if (lib2.checkin(patron2)) {                           
        System.out.println("** log 01 ** TEST for Lab = " + 
                      lib2.checkout(9780374292799L, patron2, 1, 1, 2008));
    }
    
    /****
    //List<LibraryBook<Type>> getOverdueList()
    List<Library<String>> overDueList = new List<Library<String>>(); 
    overDueList.getOverdueList(); 
    
    System.out.println("");
    System.out.println("** log 02 ** TEST for Over Due list");
    int index = 0;
    for (index = 0; index < overDueList.size(); index++) {
   	     System.out.println(overDueList.get(index).toString());
    }
    *****/

    
 // test a medium library: you will use this for homework
    Library<String> lib3 = new Library<String>();    
    lib3.addAll("Mushroom_Publishing.txt");
    ArrayList<LibraryBook<String>> booksCheckedOut3 = new ArrayList<LibraryBook<String>>();       		
    
    /***
    lib3.add(9781843190004L, "Moyra Caldecott", "Weapons of the Wolfhound");
    lib3.add(9781843190011L, "Moyra Caldecott", "The Eye of Callanish");
    lib3.add(9781843190028L, "Moyra Caldecott", "Crystal Legends");
    ****/
    	    
    String patron3 = "John";
    booksCheckedOut3 = lib3.getInventoryList();
        
    if (lib3.checkout(9781843190004L, patron3, 11, 11, 2024))
        System.out.println("** log 03 ** TEST for HomeWork = " +
        		           lib3.checkout(9781843190004L, patron3, 11, 11, 2024)); 
    
    if (!lib3.checkout(9781843190004L, patron3, 1, 1, 2008))
        System.out.println("** log 04 ** TEST for HomeWork = " +
        		           lib3.checkout(9780330351690L, patron3, 1, 1, 2008)); 
        
                        
    System.out.println("** log 05 ** TEST for HomeWork = " + 
                      lib3.checkin(patron3));
       
    lib3.checkout(9781843190011L, patron3, 1, 15, 2004);
    System.out.println("** log 06 ** TEST for HomeWork = " + 
            lib3.checkin(patron3));
    
    lib3.checkout(9781843190028L, patron3, 8, 15, 2004);
    System.out.println("** log 07 ** TEST for HomeWork = " + 
            lib3.checkin(patron3));
    
  //  ArrayList<LibraryBook<String>> booksCheckedOut3 = new ArrayList<LibraryBook<String>>();       		
  //   booksCheckedOut3 = lib3.lookup(patron3);
    
    
    if (!booksCheckedOut3.get(0).getAuthor().equals(patron3)) {
    	System.out.println("** log 10 ** TEST for HomeWork = " + 
                 lib3.checkin(patron3));
    }
    
    /********
    if compareTo(new GregorianCalendar())
    *******/
    
    System.out.println("");
    System.out.println("** log 20 ** TEST for listing Mushroom");
    int index = 0;
    for (index = 0; index < booksCheckedOut3.size(); index++) {
   	     System.out.println(booksCheckedOut3.get(index).toString());
    }
  }
    
    
  private static String checkin(long l) {
	// TODO Auto-generated method stub
	return null;
  }
}
