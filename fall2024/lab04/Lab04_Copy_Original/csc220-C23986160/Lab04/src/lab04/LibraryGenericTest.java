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
    // part 3

	if (!lib1.checkout(9780446580342L, patron1, 1, 1, 2008))
		System.err.println("TEST FAILED: third checkout");
	if (lib1.checkout(9780446580342L, patron1, 1, 1, 2008))
		System.err.println("TEST FAILED: fourth checkout");
	ArrayList<LibraryBook<String>> booksCheckedOut3 = lib1.lookup(patron1);
	if (booksCheckedOut3 == null
			|| booksCheckedOut3.size() != 1
			|| !booksCheckedOut3.contains(new Book(9780446580342L, "David Baldacci", "Simple Genius"))
			|| !booksCheckedOut3.get(0).getHolder().equals(patron1)
			|| !booksCheckedOut3.get(0).getDueDate().equals(
					new GregorianCalendar(2008, 1, 1)))
		System.err.println("TEST FAILED: lookup(holder)");
	if (!lib1.checkin(patron1))
		System.err.println("TEST FAILED: checkin(holder)");


    // FOR LAB: write tests for getInventoryList

	ArrayList<LibraryBook<String>> sortedInventoryList1 = lib1.getInventoryList();
//	System.out.println(sortedInventoryList1);

	ArrayList<LibraryBook<PhoneNumber>> sortedInventoryList2 = lib2.getInventoryList();
//	System.out.println(sortedInventoryList2);

	Library<String> testLib = new Library<String>();
	testLib.add(456, "author2", "title2");
	testLib.add(123, "author1", "title1");
	testLib.add(789, "author3", "title3");
	testLib.add(69, "author4", "title4");

	ArrayList<LibraryBook<String>> sortedInventoryList3 = testLib.getInventoryList();
//	System.out.println(sortedInventoryList3);



	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ASSIGNMENT
	// test a medium library: you will use this for homework
	Library<String> lib3 = new Library<String>();
	lib3.addAll("Mushroom_Publishing.txt");



	// TESTING ORDER BY AUTHOR METHOD
	System.out.println("TESTING ORDER BY AUTHOR METHOD\n");

    // test ordering by author
    List<LibraryBook<String>> booksByAuthor = lib3.getOrderedByAuthor();
	for (int i = 0; i < booksByAuthor.size(); i++) {
		System.out.println("AUTHOR: " + booksByAuthor.get(i).getAuthor() + " || TITLE: " + booksByAuthor.get(i).getTitle());
	}




    // TESTING ORDER BY DUEDATE METHOD
	System.out.println("\n\nTESTING ORDER BY DUE DATE METHOD\n");

    /*
     * Mushroom.txt
        9781843190004	Moyra Caldecott	Weapons of the Wolfhound
		9781843190011	Moyra Caldecott	The Eye of Callanish
		9781843190028	Moyra Caldecott	Crystal Legends
		9781843190042	Martyn Folkes	Bath City Centre Street Map and Guide
		9781843190073	Jen Alexander	The Coming of the Third
		9781843190110	David Meade Betts	Breaking the Gaze
		9781843190349	Esme Ellis	Pathway Into Sunrise
		9781843190363	Emma Lorant	Cloner
		9781843190394	Kate Clarke	The Royal United Hospital
		9781843190400	Jean Fanelli	The War Comes to Witham Street
		9781843190479	Anthony J D Burns	Demogorgon Rising
		9781843190516	Daniel Wyatt	The Fuehrermaster
		9781843190677	Cheryl Jones	Herbs for Healthy Skin
		9781843190769	Roger Taylor	The Call of the Sword
		9781843190875	Renee Angers	Ice and a Curious Man
		9781843190936	Carol E. Meacham	Machina Obscura
		9781843190998	Helen K Barker	Iceni
		9781843191230	Mary Lancaster	An Endless Exile
		9781843192022	Roger Taylor	Whistler
		9781843192039	William Fitzmaurice	Operation: Sergeant York
		9781843192701	Moyra Caldecott	The Lily and the Bull
		9781843192954	Dennis Radha-Rose	The Anxiety Relief Program
		9781843193319	Alan Burt Akers	Transit to Scorpio
     */


	// first we gotta check out some books
	lib3.checkout(9781843190004L, "daniel1", 1, 1, 2008);
	lib3.checkout(9781843190011L, "daniel2", 4, 2, 2005);
	lib3.checkout(9781843190028L, "daniel3", 6, 2, 2014);
	lib3.checkout(9781843190042L, "daniel4", 3, 5, 2018);
	lib3.checkout(9781843190073L, "daniel5", 4, 2, 2002);
	lib3.checkout(9781843190110L, "daniel6", 6, 1, 2007);
	lib3.checkout(9781843190349L, "daniel7", 9, 4, 2030);
	lib3.checkout(9781843190363L, "daniel8", 8, 3, 2004);
	lib3.checkout(9781843190394L, "daniel9", 7, 2, 2011);
	lib3.checkout(9781843190400L, "daniel10", 6, 1, 2025);
	lib3.checkout(9781843190479L, "daniel11", 5, 3, 2003);
	lib3.checkout(9781843190516L, "daniel12", 4, 2, 2002);
	lib3.checkout(9781843190677L, "daniel13", 3, 1, 2001);
	lib3.checkout(9781843190769L, "daniel14", 2, 2, 2000);
	lib3.checkout(9781843190875L, "daniel15", 1, 3, 2004);
	lib3.checkout(9781843190936L, "daniel16", 2, 4, 2005);
	lib3.checkout(9781843190998L, "daniel17", 3, 5, 2006);
	lib3.checkout(9781843191230L, "daniel18", 4, 6, 2007);

	// test ordering by due date
	List<LibraryBook<String>> booksByTitle = lib3.getOverdueList();

	for (int i = 0; i < booksByTitle.size(); i++) {
		if (booksByTitle.get(i).getDueDate() != null) {
			System.out.println(booksByTitle.get(i).getIsbn() + " " + booksByTitle.get(i).getDueDate().getTime());
		}
    }


  }

}


















































