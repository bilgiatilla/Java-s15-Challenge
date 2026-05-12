package entitiy;

import enums.Status;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Person {
    private List<Book> books;
    private String name;

    public Reader(String name) {
        super(name);
        books = new ArrayList<>();
    }

    public void purchaseBook (Book book) {
        books.add(book);
        book.changeOwner(this);
    }
    public void borrowBook (Book book) {
        books.add(book);
        book.updateStatus(Status.NOT_AVAILABLE);
    }
    public void returnBook (Book book) {
        books.remove(book);
        book.updateStatus(Status.AVAILABLE);
    }
    public void showBook () {
        for (Book book: books) {
            System.out.println(book);
        }
    }
    @Override
    public void whoYouAre () {
        System.out.println("I am a reader. My name is " + name);
    }
}
