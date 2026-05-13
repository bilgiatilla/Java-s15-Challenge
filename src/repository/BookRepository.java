package repository;

import entity.Author;
import entity.Book;
import entity.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepository {

    private Map<Long, Book> books;

    public BookRepository() {
        this.books = new HashMap<>();
    }

    public void addBook (Book book) {
        books.put(book.getBookId(), book);
    }

    public void removeBook (Long bookId) {
        books.remove(bookId);
    }

    public Book findById (Long bookId) {
        return books.get(bookId);
    }

    public List<Book> findByTitle (String title) {
        List<Book> result = new ArrayList<>();
        for (Book book: books.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> findByAuthor (Author author) {
        List<Book> result = new ArrayList<>();

        for (Book book : books.values()) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }
    public List<Book> findByCategory (Category category) {
        List<Book> result = new ArrayList<>();

        for (Book book : books.values()) {
            if (book.getCategory().equals(category)) {
                result.add(book);
            }
        }
        return result;
    }
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }
}
