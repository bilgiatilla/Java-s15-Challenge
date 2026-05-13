package entity;

import java.util.HashSet;
import java.util.Set;

public class Category {
    private Long categoryId;
    private String categoryName;
    private Set<Book> books;

    public Category(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.books = new HashSet<>();
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Set<Book> getBooks() {
        return books;
    }
    public void addBook (Book book) {
        books.add(book);
    }
}
