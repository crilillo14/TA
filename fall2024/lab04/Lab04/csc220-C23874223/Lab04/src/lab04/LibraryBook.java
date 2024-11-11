package lab04;

import java.util.GregorianCalendar;

public class LibraryBook<Type> {
    private long isbn;
    private String author;
    private String title;
    private Type holder;
    private GregorianCalendar dueDate;

    public LibraryBook(long isbn, String author, String title) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.holder = null;
        this.dueDate = null;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Type getHolder() {
        return holder;
    }

    public GregorianCalendar getDueDate() {
        return dueDate;
    }

    public void checkout(Type holder, GregorianCalendar dueDate) {
        this.holder = holder;
        this.dueDate = dueDate;
    }

    public void checkin() {
        this.holder = null;
        this.dueDate = null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof LibraryBook)) return false;
        LibraryBook<?> other = (LibraryBook<?>) obj;
        return this.isbn == other.isbn; 
    }

    @Override
    public int hashCode() {
        return Long.hashCode(isbn);
    }
}
