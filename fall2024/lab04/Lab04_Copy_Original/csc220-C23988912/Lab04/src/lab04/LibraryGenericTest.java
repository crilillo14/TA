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
    
    Library<String> lib4 = new Library<String>();
    lib4.add(9780446580342L, "David Baldacci", "Simple Genius");
    lib4.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib4.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    ArrayList<LibraryBook<String>> inventoryList = lib4.getInventoryList();
   // System.out.println(lib4.getInventoryList());
    
    if (inventoryList.get(0).getIsbn() != 9780330351690L ||
    	    inventoryList.get(1).getIsbn() != 9780374292799L ||
    	    inventoryList.get(2).getIsbn() != 9780446580342L) {
    	    System.err.println("TEST FAILED: getInventoryList does not sort by ISBN correctly.");
    	}
    if (!inventoryList.get(0).getTitle().equals("Into the Wild") ||
    	    !inventoryList.get(1).getTitle().equals("The World is Flat") ||
    	    !inventoryList.get(2).getTitle().equals("Simple Genius")) {
    	    System.err.println("TEST FAILED: Book details are incorrect in inventory list.");
    	}

   
//    
//    Library<String> emptyLib = new Library<String>();
//    ArrayList<LibraryBook<String>> emptyInventory = emptyLib.getInventoryList();
//    if (emptyInventory.size() != 0) {
//        System.err.println("TEST FAILED: getInventoryList should return an empty list for an empty library.");
//    }
//    
//    
//    Library<String> singleLib = new Library<String>();
//    singleLib.add(9780140177398L, "John Steinbeck", "Of Mice and Men");
//    ArrayList<LibraryBook<String>> singleInventory = singleLib.getInventoryList();
//    if (singleInventory.size() != 1 || singleInventory.get(0).getIsbn() != 9780140177398L) {
//        System.err.println("TEST FAILED: getInventoryList failed with a single book.");
//    }
//
//    boolean isSorted = true;
//    for (int i = 0; i < inventoryList.size() - 1; i++) {
//        if (inventoryList.get(i).getIsbn() > inventoryList.get(i + 1).getIsbn()) {
//            isSorted = false;
//            break;
//        }
//    }
//    if (!isSorted) {
//        System.err.println("TEST FAILED: getInventoryList does not sort the books correctly.");
//    }

    

 LibraryBook<String> book1 = new LibraryBook<String>(9780330351690L, "Jon Krakauer", "Into the Wild");
 LibraryBook<String> book2 = new LibraryBook<String>(9780374292799L, "Thomas L. Friedman", "The World is Flat");
 LibraryBook<String> book3 = new LibraryBook<String>(9780446580342L, "David Baldacci", "Simple Genius");
 LibraryBook<String> book4 = new LibraryBook<String>(9780330351690L, "Jon Krakauer", "Into the Wild"); // Same as book1


 Library<String> lib = new Library<String>(); 
 Library<String>.IsbnComparator comparator = lib.new IsbnComparator();


 if (comparator.compare(book1, book2) >= 0) {
     System.err.println("TEST FAILED: IsbnComparator incorrectly compared book1 and book2.");
 }

 if (comparator.compare(book2, book1) <= 0) {
     System.err.println("TEST FAILED: IsbnComparator incorrectly compared book2 and book1.");
 }


 if (comparator.compare(book1, book4) != 0) {
     System.err.println("TEST FAILED: IsbnComparator incorrectly compared book1 and book4.");
 }




Library<String> libAuthor = new Library<>();
libAuthor.add(9780446580342L, "David Baldacci", "Simple Genius");
libAuthor.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
libAuthor.add(9780330351690L, "Jon Krakauer", "Into the Wild");
List<LibraryBook<String>> sortedByAuthor = libAuthor.getOrderedByAuthor();

if (!sortedByAuthor.get(0).getAuthor().equals("David Baldacci") ||
  !sortedByAuthor.get(1).getAuthor().equals("Jon Krakauer") ||
  !sortedByAuthor.get(2).getAuthor().equals("Thomas L. Friedman")) {
  System.err.println("TEST FAILED: getOrderedByAuthor did not sort by author correctly.");
}



Library<String> libOverdueTest = new Library<>();
libOverdueTest.add(9780330351690L, "Jon Krakauer", "Into the Wild");
libOverdueTest.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
libOverdueTest.add(9780140177398L, "John Steinbeck", "Of Mice and Men");


libOverdueTest.checkout(9780330351690L, "Jane Doe", 1, 1, 2023); 
libOverdueTest.checkout(9780374292799L, "Jane Doe", 12, 31, 2024);
libOverdueTest.checkout(9780140177398L, "Jane Doe", 1, 1, 2025); 


List<LibraryBook<String>> overdueBooks = libOverdueTest.getOverdueList();


if (overdueBooks.size() != 1 || !overdueBooks.get(0).getTitle().equals("Into the Wild")) {
    System.err.println("TEST FAILED: getOverdueList did not return only the overdue books.");
} 

for (LibraryBook<String> book : overdueBooks) {
    if (book.getDueDate().after(new GregorianCalendar())) {
        System.err.println("TEST FAILED: getOverdueList included a book that is not overdue.");
    }
}
//System.out.println(libOverdueTest.getOverdueList());

    
//    System.out.println(lib1.getInventoryList());
//    
//    Library<Integer> libInt = new Library<Integer>();
//    libInt.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
//    libInt.add(9780330351690L, "Jon Krakauer", "Into the Wild");
//    libInt.add(9780446580342L, "David Baldacci", "Simple Genius");
//    Integer patronId = 12345;
//    
//    
//    if (!libInt.checkout(9780134685991L, patronId, 2, 15, 2022)) {
//    	System.err.println("TEST FAILED: checkout with Integer holder");
//    }
//    
//    ArrayList<LibraryBook<Integer>> booksCheckedOutInt = libInt.lookup(patronId);
//    if (booksCheckedOutInt == null || booksCheckedOutInt.size()!=1)
//     System.err.print("TEST FAILED: lookup(holder) with Integer holder");
//    if (!libInt.checkin(patronId))
//    	System.err.print("TEST FAILED: checkIn(holder) with Integer hodler");
//    
    
   // System.out.println("Testing done.");
    // test a medium library: you will use this for homework
    Library<String> lib3 = new Library<String>();    
    lib3.addAll("Mushroom_Publishing.txt");
    if (lib3.getInventoryList().size() != 23) { // We know there are 23 books in the file
        System.err.println("TEST FAILED: Not all books from Mushroom_Publishing.txt were loaded correctly.");
    } 
    List<LibraryBook<String>> sortedByISBN = lib3.getInventoryList();
    for (int i = 0; i < sortedByISBN.size() - 1; i++) {
        if (sortedByISBN.get(i).getIsbn() > sortedByISBN.get(i + 1).getIsbn()) {
            System.err.println("TEST FAILED: getInventoryList did not sort books by ISBN correctly.");
            break;
        }
    }
 
    List<LibraryBook<String>> mushroomsortedByAuthor = lib3.getOrderedByAuthor();
    for (int i = 0; i < mushroomsortedByAuthor.size() - 1; i++) {
        String author1 = mushroomsortedByAuthor.get(i).getAuthor();
        String author2 = mushroomsortedByAuthor.get(i + 1).getAuthor();
        if (author1.compareTo(author2) > 0) {
            System.err.println("TEST FAILED: getOrderedByAuthor did not sort books by author correctly.");
            break;
        }
    }
    
    }
}
    
  

