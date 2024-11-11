package lab04;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Testing class for Library.
 * 
 * 
 */
public class LibraryTest {

  public static void main(String[] args) {
    // test an empty library
    Library lib = new Library();

    if (lib.lookup(978037429279L) != null)
      System.err.println("TEST FAILED -- empty library: lookup(isbn)");
    
    ArrayList<LibraryBook> booksCheckedOut = lib.lookup("Jane Doe");
    
    if (booksCheckedOut == null || booksCheckedOut.size() != 0)
      System.err.println("TEST FAILED -- empty library: lookup(holder)");
    
    if (lib.checkout(978037429279L, "Jane Doe", 1, 1, 2008))
      System.err.println("TEST FAILED -- empty library: checkout");
    
    if (lib.checkin(978037429279L))
      System.err.println("TEST FAILED -- empty library: checkin(isbn)");
    
    if (lib.checkin("Jane Doe"))
      System.err.println("TEST FAILED -- empty library: checkin(holder)");

    // test a small library
    lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib.add(9780446580342L, "David Baldacci", "Simple Genius");

    if (lib.lookup(9780330351690L) != null)
      System.err.println("TEST FAILED -- small library: lookup(isbn)");    
    
    if (!lib.checkout(9780330351690L, "Jane Doe", 1, 1, 2008))
      System.err.println("TEST FAILED -- small library: checkout");
    
    booksCheckedOut = lib.lookup("Jane Doe");
        
    if (booksCheckedOut == null
        || booksCheckedOut.size() != 1
        || !booksCheckedOut.get(0).equals(
            new Book(9780330351690L, "Jon Krakauer", "Into the Wild"))
        || !booksCheckedOut.get(0).getHolder().equals("Jane Doe")
        || !booksCheckedOut.get(0).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1))){
      System.err.println("TEST FAILED -- small library: lookup(holder)");
    }
    if (!lib.checkin(9780330351690L))
      System.err.println("TEST FAILED -- small library: checkin(isbn)");
    if (lib.checkin("Jane Doe"))
      System.err.println("TEST FAILED -- small library: checkin(holder)");
    Library<String> lib3 = new Library<String>();
    lib.addAll("Mushroom_Publishing.txt");
    
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

    // test a medium library TODO: Assignment part 3
    //lib.addAll("Mushroom_Publishing.txt");
	
    
    // FILL IN your own tests below
	
	

    System.out.println("Testing done.");
  }


}
