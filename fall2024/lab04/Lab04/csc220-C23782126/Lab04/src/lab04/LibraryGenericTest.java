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
    
 // Test for getInventoryList
    lib1.add(9780262033848L, "George Orwell", "Animal Farm");
    lib1.add(9780131103627L, "Homer", "Iliad");
    
    ArrayList<LibraryBook<String>> inventoryList = lib1.getInventoryList();
    if (inventoryList.size() != 5) {
      System.err.println("TEST FAILED: getInventoryList size incorrect.");
    } else {
      System.out.println("Small Library Inventory List:");
      for (LibraryBook<String> book : inventoryList) {
        System.out.println(book);
      }
    }

    // Test checkin of a book not checked out
    if (lib1.checkin(9780446580342L)) {
      System.err.println("TEST FAILED: book not checked out.");
    }
    
    // Test checkout of a book that is already checked out
    if (lib1.checkout(9780330351690L, patron1, 1, 1, 2008)) {
      System.err.println("TEST FAILED: book already checked out.");
    }

    // Test getInventoryList sorted by ISBN
    ArrayList<LibraryBook<String>> sortedInventoryList = lib1.getInventoryList();
    boolean sortedByISBN = true;
    for (int i = 0; i < sortedInventoryList.size() - 1; i++) {
      if (sortedInventoryList.get(i).getIsbn() > sortedInventoryList.get(i + 1).getIsbn()) {
        sortedByISBN = false;
        System.err.println("TEST FAILED: not sorted by ISBN.");
        break;
      }
    }
   
    
    // test a medium library: you will use this for homework
    Library<String> lib3 = new Library<String>();    
    lib3.addAll("Mushroom_Publishing.txt");
    
    ArrayList<LibraryBook<String>> sortedISBNList = lib3.getInventoryList();
    if (inventoryList.size() != 5) {
      System.err.println("TEST FAILED: getInventoryList size incorrect.");
    } else {
      System.out.println("\nMedium Library Inventory List (by ISBN):\n");
      for (LibraryBook<String> book : sortedISBNList) {
        System.out.println(book);
      }
    }
    
    
    ArrayList<LibraryBook<String>> sortedAuthorList = lib3.getOrderedByAuthor();
    boolean sortedByAuthor = true;
    for(int i = 0; i < sortedAuthorList.size() - 1; i++) {
    	if(sortedAuthorList.get(i).getAuthor() == sortedAuthorList.get(i + 1).getAuthor()) {
    		sortedByAuthor = false;
    		System.err.println("TEST FAILED: not sorted by Author.");
    		break;
    	}
    }
    
    ArrayList<LibraryBook<String>> sortedDDList = lib3.getOverdueList();
    boolean sortedByDD = true;
    for(int i = 0; i < sortedDDList.size() - 1; i++) {
    	if(sortedDDList.get(i).getDueDate() == sortedDDList.get(i + 1).getDueDate()) {
    		sortedByDD = false;
    		System.err.println("TEST FAILED: not sorted by DueDate.");
    		break;
    	}
    }
    
    System.out.println("\nMedium Library Inventory List (by Author):\n");
    for (LibraryBook<String> book : sortedAuthorList) {
      System.out.println(book);
    }
    
    System.out.println("\nMedium Library Inventory List (by DueDate):\n");
    for (LibraryBook<String> book : sortedDDList) {
      System.out.println(book);
    }
    
  }
}

