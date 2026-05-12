package entitiy;

import enums.Status;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private  List<Reader> readers;

    public Library () {
        books = new ArrayList<>();
        readers = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void newBook(Book book) {
        books.add(book);
        System.out.println("Book added succesfully!");
    }

    public void lendBook(Book book, Reader reader) {
        if(book.getStatus() == Status.AVAILABLE) {
            reader.borrowBook(book);
            System.out.println("Book borrowed succesfully!");
        } else {
            System.out.println("Book is not available");
        }
    }
    public void takeBackBook (Book book, Reader reader) {
        reader.returnBook(book);
        book.updateStatus(Status.AVAILABLE);
        System.out.println("Book returned");
    }
    public void showBook () {
        for (Book book: books) {
            System.out.println(book);
        }
    }
}
