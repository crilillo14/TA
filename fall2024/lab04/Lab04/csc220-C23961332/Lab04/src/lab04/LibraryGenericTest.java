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
		ArrayList<LibraryBook<String>> booksCheckedOut1 = lib1.lookup(patron1);
		if (booksCheckedOut1 == null || booksCheckedOut1.size() != 2
				|| !booksCheckedOut1.contains(new Book(9780330351690L, "Jon Krakauer", "Into the Wild"))
				|| !booksCheckedOut1.contains(new Book(9780374292799L, "Thomas L. Friedman", "The World is Flat"))
				|| !booksCheckedOut1.get(0).getHolder().equals(patron1)
				|| !booksCheckedOut1.get(0).getDueDate().equals(new GregorianCalendar(2008, 1, 1))
				|| !booksCheckedOut1.get(1).getHolder().equals(patron1)
				|| !booksCheckedOut1.get(1).getDueDate().equals(new GregorianCalendar(2008, 1, 1)))
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
		ArrayList<LibraryBook<PhoneNumber>> booksCheckedOut2 = lib2.lookup(patron2);
		if (booksCheckedOut2 == null || booksCheckedOut2.size() != 2
				|| !booksCheckedOut2.contains(new Book(9780330351690L, "Jon Krakauer", "Into the Wild"))
				|| !booksCheckedOut2.contains(new Book(9780374292799L, "Thomas L. Friedman", "The World is Flat"))
				|| !booksCheckedOut2.get(0).getHolder().equals(patron2)
				|| !booksCheckedOut2.get(0).getDueDate().equals(new GregorianCalendar(2008, 1, 1))
				|| !booksCheckedOut2.get(1).getHolder().equals(patron2)
				|| !booksCheckedOut2.get(1).getDueDate().equals(new GregorianCalendar(2008, 1, 1)))
			System.err.println("TEST FAILED: lookup(holder)");
		if (!lib2.checkin(patron2))
			System.err.println("TEST FAILED: checkin(holder)");

		// FILL IN for tests
		// Library that uses ints as holders
		Library<Integer> longLib = new Library<Integer>();
		
		longLib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
		longLib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
		longLib.add(9780446580342L, "David Baldacci", "Simple Genius");
		
		int studentID = 23961332;
		
		if (!longLib.checkout(9780330351690L, studentID, 1, 1, 2008))
			System.err.println("TEST FAILED: first checkout");
		if (!longLib.checkout(9780374292799L, studentID, 1, 1, 2008))
			System.err.println("TEST FAILED: second checkout");
		
		System.out.println("Library with Integers as holders:\n" + longLib.lookup( new Integer(studentID) ) + "\n");

		// FOR LAB: write tests for getInventoryList
		ArrayList<LibraryBook<String>> sortedLibrary1 = lib1.getInventoryList();
		for (int i = 0; i < sortedLibrary1.size() - 1; i++) {
			if (sortedLibrary1.get(i).getIsbn() > sortedLibrary1.get(i + 1).getIsbn()) {
				System.err.println("TEST FAILED: sortedlibrary1 has an error");
			}
		}

		ArrayList<LibraryBook<PhoneNumber>> sortedLibrary2 = lib2.getInventoryList();
		for (int i = 0; i < sortedLibrary2.size() - 1; i++) {
			if (sortedLibrary2.get(i).getIsbn() > sortedLibrary2.get(i + 1).getIsbn()) {
				System.err.println("TEST FAILED: sortedlibrary2 has an error");
			}
		}

		Library<String> unsortedLib = new Library<String>();

		unsortedLib.add(23L, "Thomas L. Friedman", "The World is Flat");
		unsortedLib.add(12L, "Jon Krakauer", "Into the Wild");
		unsortedLib.add(3L, "David Baldacci", "Simple Genius");
		unsortedLib.add(56L, "Jon Krakauer", "Into the Wild");
		unsortedLib.add(0L, "David Baldacci", "Simple Genius");
		unsortedLib.add(99L, "David Baldacci", "Simple Genius");
		unsortedLib.add(1L, "David Baldacci", "Simple Genius");

		ArrayList<LibraryBook<String>> sortedLibrary3 = unsortedLib.getInventoryList();
		for (int i = 0; i < sortedLibrary3.size() - 1; i++) {
			if (sortedLibrary3.get(i).getIsbn() > sortedLibrary3.get(i + 1).getIsbn()) {
				System.err.println("TEST FAILED: sortedlibrary3 has an error");
			}
		}

		// test a medium library: you will use this for homework
		Library<String> lib3 = new Library<String>();
		lib3.addAll("Mushroom_Publishing.txt");

		// Sort by ISBN
		System.out.println("Sorted by ISBN:");
		ArrayList<LibraryBook<String>> sortedList = lib3.getInventoryList();
		for (int i = 0; i < sortedList.size(); i++) {
			System.out.println(sortedList.get(i).getIsbn());
		}
		System.out.println();

		// Test sorting by author
		System.out.println("Sorted by Author:");
		sortedList = lib3.getOrderedByAuthor();
		for (int i = 0; i < sortedList.size(); i++) {
			System.out.println(sortedList.get(i).getAuthor() + ", " + sortedList.get(i).getTitle());
		}
		System.out.println();

		// Check out some Books
		lib3.checkout(9781843190875L, "Javi", 2, 28, 2023);
		lib3.checkout(9781843192039L, "Javi", 6, 4, 2022);
		lib3.checkout(9781843190936L, "Tom", 7, 20, 2024);
		lib3.checkout(9781843190028L, "Javi", 10, 17, 2024);
		lib3.checkout(9781843193319L, "Tom", 1, 1, 2025);

		System.out.println("Overdue List, oldest first:");
		sortedList = lib3.getOverdueList();
		for (int i = 0; i < sortedList.size(); i++) {
			System.out.println(sortedList.get(i).getIsbn() + " checked by " + sortedList.get(i).getHolder() + " due on " + sortedList.get(i).getDueDate().getTime());
		}
		System.out.println();

		System.out.println("Testing done.");

	}
}
