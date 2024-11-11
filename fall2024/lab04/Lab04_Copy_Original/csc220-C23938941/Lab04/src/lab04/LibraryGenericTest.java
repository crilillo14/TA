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
    
 
    
    // test a medium library: you will use this for homework
    Library<String> lib3 = new Library<String>();    
    
    
    lib3.addAll("Mushroom_Publishing.txt");
     
    ArrayList<LibraryBook<String>> mushroomInventory = lib3.getInventoryList();
    if (mushroomInventory == null || mushroomInventory.size() == 0) {
      System.err.println("TEST FAILED: Mushroom_Publishing.txt - no books loaded");
    } else {
      long expectedIsbn = 9781843190004L; 
      boolean found = false;
      for (LibraryBook<String> book : mushroomInventory) {
        if (book.getIsbn() == expectedIsbn) {
          found = true;
          break;
        }
      }
      if (!found) {
        System.err.println("TEST FAILED: Mushroom_Publishing.txt - specific book not found");
      }
    }

    System.out.println("Testing done.");
    
  //Testing the getInventory after adding new values to our library
    Boolean check = false;
    Library<PhoneNumber> lib4 = new Library<PhoneNumber>();
    lib4.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib4.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib4.add(9780446580342L, "David Baldacci", "Simple Genius");
    lib4.add(9780446580343L, "Author4", "Book4");
    ArrayList<LibraryBook<PhoneNumber>> inventoryOfNumbers = lib4.getInventoryList();
    if(inventoryOfNumbers == null || inventoryOfNumbers.size() == 0) {
    	System.err.println("TEST FAILED: the inventory is empty.");
    }
    else { 
    	String authorExpected = "Author4";
    	for(LibraryBook<PhoneNumber> number : inventoryOfNumbers) {
    		if(number.getAuthor() == authorExpected) {
    			check = true;
    			System.out.println("Testing done.");
    			break;
    		}
    	}
    }
    if(!check) {
    	System.err.println("TEST FAILED: Author 4 was not found in the inventory.");
    }
  }
  
    
  }
