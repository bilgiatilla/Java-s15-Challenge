package entity;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person {
    private List<Book> books;

    public Author(Long personId, String name) {
        super(personId, name);
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }
    @Override
    public void whoYouAre () {
        System.out.println("I am an author. My name is " + getName());
    }

}
