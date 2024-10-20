package lab04;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Comparator;
import java.util.Collections;


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
    // Test sorting by ISBN using a custom comparator
    Collections.sort(booksCheckedOut1, new IsbnComparator<>());
    System.out.println("Sorted by ISBN:");
    for (LibraryBook<String> book : booksCheckedOut1) {
      System.out.println(book.getIsbn() + " - " + book.getTitle());
    }

    // Test sorting by author using a custom comparator
    Collections.sort(booksCheckedOut1, new AuthorComparator<>());
    System.out.println("Sorted by Author:");
    for (LibraryBook<String> book : booksCheckedOut1) {
      System.out.println(book.getAuthor() + " - " + book.getTitle());
    }

    // Test a medium library: test with Mushroom_Publishing.txt
    Library<String> lib3 = new Library<String>();
    lib3.addAll("Mushroom_Publishing.txt");
    ArrayList<LibraryBook<String>> booksCheckedOut3 = lib3.getInventoryList();
    System.out.println("Number of books in medium library: " + booksCheckedOut3.size());

    // Test sorting the medium library by ISBN
    booksCheckedOut3 = lib3.getInventoryList();
    Collections.sort(booksCheckedOut3, new IsbnComparator<>());
    System.out.println("First book ISBN: " + booksCheckedOut3.get(0).getIsbn());

    // Test sorting the medium library by Author
    Collections.sort(booksCheckedOut3, new AuthorComparator<>());
    System.out.println("First book by Author: " + booksCheckedOut3.get(0).getAuthor());
  }

  // Comparator for sorting books by ISBN
  static class IsbnComparator<Type> implements Comparator<LibraryBook<Type>> {
    public int compare(LibraryBook<Type> book1, LibraryBook<Type> book2) {
      return Long.compare(book1.getIsbn(), book2.getIsbn());
    }
  }

  // Comparator for sorting books by author and breaking ties with title
  static class AuthorComparator<Type> implements Comparator<LibraryBook<Type>> {
    public int compare(LibraryBook<Type> book1, LibraryBook<Type> book2) {
      int authorComparison = book1.getAuthor().compareTo(book2.getAuthor());
      if (authorComparison != 0) {
        return authorComparison;
      }
      return book1.getTitle().compareTo(book2.getTitle());
    }
  }

  // FILL IN for tests


      // FOR LAB: write tests for getInventoryList

  }
