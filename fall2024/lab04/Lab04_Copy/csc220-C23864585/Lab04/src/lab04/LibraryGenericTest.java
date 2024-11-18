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
    
    
    lib1.checkout(9780330351690L, patron1, 1, 1, 2008);
    if (lib1.checkout(9780330351690L, "John Smith", 2, 2, 2008))
      System.err.println("TEST FAILED: checkout book already checked out");

    if (lib1.checkin(9780446580342L))
      System.err.println("TEST FAILED: checkin book never checked out");

    if (!lib1.checkin(9780330351690L))
      System.err.println("TEST FAILED: checkin by ISBN");
    
    // FILL IN for tests
    
    // FOR LAB: write tests for getInventoryList

    ArrayList<LibraryBook<String>> inventoryList = lib1.getInventoryList();

    boolean isSorted = true;
    for (int i = 0; i < inventoryList.size() - 1; i++) {
      if (inventoryList.get(i).getIsbn() > inventoryList.get(i + 1).getIsbn()) {
        isSorted = false;
        break;
      }
    }

    if (inventoryList.size() != 3 || !isSorted) {
      System.err.println("Testing FAILED.");
    } else {
      System.out.println("Testing done.");
    }
    
    // test a medium library: you will use this for homework
    Library<String> lib3 = new Library<String>();    
    lib3.addAll("Mushroom_Publishing.txt");
    
    ArrayList<LibraryBook<String>> authorSortedListMedium = lib3.getOrderedByAuthor();
    boolean isAuthorSortedMedium = true;
    for (int i = 0; i < authorSortedListMedium.size() - 1; i++) {
      LibraryBook<String> currentBook = authorSortedListMedium.get(i);
      LibraryBook<String> nextBook = authorSortedListMedium.get(i + 1);
      int authorComparison = currentBook.getAuthor().compareTo(nextBook.getAuthor());

      if (authorComparison > 0 || 
         (authorComparison == 0 && currentBook.getTitle().compareTo(nextBook.getTitle()) > 0)) {
        isAuthorSortedMedium = false;
        break;
      }
    }

    if (!isAuthorSortedMedium) {
      System.err.println("TEST FAILED");
    } else {
      System.out.println("Testing done");
    }

    GregorianCalendar currentDateMedium = new GregorianCalendar(2023, 9, 17);
    ArrayList<LibraryBook<String>> overdueListMedium = lib3.getOverdueList(currentDateMedium);

    boolean isOverdueSortedMedium = true;
    for (int i = 0; i < overdueListMedium.size() - 1; i++) {
      if (overdueListMedium.get(i).getDueDate().after(overdueListMedium.get(i + 1).getDueDate())) {
        isOverdueSortedMedium = false;
        break;
      }
    }

    if (!isOverdueSortedMedium) {
      System.err.println("TEST FAILED");
    } else {
      System.out.println("Testing done.");
    }
    
    
  }
}