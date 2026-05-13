package entity;

import enums.Status;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String libraryName;
    private BookRepository bookRepository;
    private List<MemberRecord> members;
    private List<Librarian> librarians;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.bookRepository = new BookRepository();
        this.members = new ArrayList<>();
        this.librarians = new ArrayList<>();
    }

    public String getLibraryName() {
        return libraryName;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public List<MemberRecord> getMembers() {
        return members;
    }

    public void addBook(Book book) {
        bookRepository.addBook(book);
    }
    public void removeBook(Long bookId) {
        bookRepository.removeBook(bookId);
    }
    public void addMember(MemberRecord member) {
        members.add(member);
    }
    public void addLibrarian (Librarian librarian) {
        librarians.add(librarian);
    }
    public void showBooks() {
        for (Book book : bookRepository.findAll()) {
            System.out.println(book);
        }
    }
}
