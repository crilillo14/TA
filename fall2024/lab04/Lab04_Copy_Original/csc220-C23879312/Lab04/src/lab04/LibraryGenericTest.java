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
    
    Library<String> lib3 = new Library<String>();
    lib3.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib3.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib3.add(9780446580342L, "David Baldacci", "Simple Genius");
    System.out.println(lib3.getInventoryList());
    
    Library<String> lib4 = new Library<String>();
    lib4.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib4.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib4.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib4.add(9780446580342L, "David Baldacci", "Simple Genius");
    System.out.println(lib4.getInventoryList());
    
    Library<String> lib5 = new Library<String>();
    System.out.println(lib5.getInventoryList());
    
    
    
    
    
     //test a medium library: you will use this for homework
    Library<String> lib6 = new Library<String>();    
    lib6.addAll("Mushroom_Publishing.txt");
    
    System.out.println("Testing get order by author:");
    List<LibraryBook<String>> test = lib6.getOrderedByAuthor();
    for (LibraryBook<String> book : test) {
    	System.out.println(book.getAuthor() + " : " + book.getTitle());
    }
    
    System.out.println();
    
    // tests for the overdue books list
    Library<String> lib7 = new Library<String>();
    
    lib7.add(9780374292799L, "Sidney Cocimano", "A Day in the Life");
    lib7.add(9780330351690L, "Carlos Ramirez", "Tennis How-To");
    lib7.add(9780446580342L, "Kyle Bolton", "Poli-Sci");
    lib7.add(9780446587742L, "Ava Prinzo", "OU");
    lib7.add(9780446587743L, "Michael Finkel", "Accounting 101");
    
    lib7.checkout(9780374292799L, "Rick", 1, 1, 2023);
    lib7.checkout(9780330351690L, "Vick", 1, 1, 2024);
    lib7.checkout(9780446580342L, "Tick", 1, 1, 2025);
    lib7.checkout(9780446587743L, "Mick", 8, 17, 2024); //book due today!
    
    System.out.println("Checking overdue list....");
    
    List<LibraryBook<String>> overdues = lib7.getOverdueList();
    for(LibraryBook<String> book : overdues) {
    	System.out.println(book.getIsbn() + " " + book.getAuthor() + " " + book.getTitle() + " Holder: " + book.getHolder() + " Due: " + book.getDueDate().getTime());
    }
    
    System.out.println();
    
    System.out.println("Testing get order by author again!:");
    List<LibraryBook<String>> test2 = lib7.getOrderedByAuthor();
    for (LibraryBook<String> book : test2) {
    	System.out.println(book.getAuthor() + " : " + book.getTitle());
    }
    
    
    //double check gregorian cal
    GregorianCalendar today = new GregorianCalendar();
    System.out.println(today.getTime());

    
    
    
    
    
    
    
    
    
    
  }
}
