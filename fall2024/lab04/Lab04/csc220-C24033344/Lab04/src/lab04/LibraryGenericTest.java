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
    
    Library<String> myLibrary = new Library<String>();
    myLibrary.add(394898L, "Bob Marley", "Better Fuel Huel");
    myLibrary.add(93784L, "Benjamin Felix", "Fixing Good");
    myLibrary.checkout(394898L, "Chuck McGill", 12, 24, 2025);
    myLibrary.checkout(93784L, "Chuck McGill", 5, 12, 2024);
    
    
    Library<PhoneNumber> hisLibrary = new Library<PhoneNumber>();
    hisLibrary.add(2384384928L, "Bob Marley", "Better Fuel Huel");
    hisLibrary.add(9378483762L, "Benjamin Felix", "Fixing Good");
    hisLibrary.checkout(9378483762L, new PhoneNumber("954-291-2837"), 12, 24, 2025);
    hisLibrary.checkout(2384384928L, new PhoneNumber("754-928-1720"), 5, 12, 2024);
    
    System.out.println(myLibrary.lookup(394898L).equals(myLibrary.lookup(93784L)));
    System.out.println(hisLibrary.lookup(9378483762L).equals(hisLibrary.lookup(2384384928L)));
    
    // FOR LAB: write tests for getInventoryList

    myLibrary.add(290930L, "Romeo Dellaire", "Ice and Fire");
    myLibrary.add(182839L, "Bob Marley", "Better Call Maul");
    myLibrary.add(580830L, "Josh Hutchinson", "Reform and Revolution");
    
    ArrayList<LibraryBook<String>> test1 = myLibrary.getInventoryList();
    for (int i = 0; i < test1.size(); i++) {
    	System.out.println(test1.get(i).getIsbn());
    }
    
    // test a medium library: you will use this for homework
    Library<String> lib3 = new Library<String>();    
    lib3.addAll("Mushroom_Publishing.txt");
    
    System.out.println();
    
    List<LibraryBook<String>> lib3Authors = lib3.getOrderedByAuthor();
    for (LibraryBook<String> book : lib3Authors) {
    	System.out.println(book.getAuthor());
    }
    
    System.out.println();
    
    lib3.checkout(9781843190400L, "Timothy Jenkins", 10, 30, 2024);
    lib3.checkout(9781843190004L, "Bob Obendirk", 9, 2, 2024);
    lib3.checkout(9781843190073L, "Jimothy Tenkins", 11, 11, 2024);
    lib3.checkout(9781843190479L, "Juan Carlos", 5, 4, 2025);
    lib3.checkout(9781843193319L, "Wilhelmina", 2, 7, 2006);
    lib3.checkout(9781843192954L, "Joe Biden", 5, 23, 2024);
    lib3.checkout(9781843192701L, "Mark Twain", 3, 30, 2024);
    lib3.checkout(9781843192039L, "Simon Bolivar", 9, 30, 2024);
    lib3.checkout(9781843192022L, "Raymond Poincare", 8, 17, 2024);
    lib3.checkout(9781843191230L, "Francis Duke", 1, 1, 2023);
    
    List<LibraryBook<String>> lib3DueDates = lib3.getOverdueList();
    for (LibraryBook<String> book : lib3DueDates) {
    	System.out.println( book.getDueDate().get(GregorianCalendar.MONTH) + " " + book.getDueDate().get(GregorianCalendar.DATE) + " " + book.getDueDate().get(GregorianCalendar.YEAR) );
    }
    
  }
}
