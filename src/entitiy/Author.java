package entitiy;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person {
    private List<Book> books;
    private String name;

    public Author(String name) {
        super(name);
        books = new ArrayList<>();
    }

    public void newBook(Book book) {
        books.add(book);
    }
    public void showBook() {
        for(Book book : books) {
            System.out.println(book);
        }
    }
    @Override
    public void whoYouAre () {
        System.out.println("I am an author. My name is " + name);
    }

}
