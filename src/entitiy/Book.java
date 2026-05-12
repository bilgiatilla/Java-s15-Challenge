package entitiy;

import enums.Status;

import java.time.LocalDate;

public class Book {
    private Long bookId;
    private Author author;
    private String name;
    private double price;
    private int edition;
    private Status status;
    private LocalDate dateOfPurchase;
    private Person owner;

    public Book(Long bookId, Author author, String name, double price, int edition, Status status, LocalDate dateOfPurchase, Person owner) {
        this.bookId = bookId;
        this.author = author;
        this.name = name;
        this.price = price;
        this.edition = edition;
        this.status = status;
        this.dateOfPurchase = dateOfPurchase;
        this.owner = owner;
    }


    public String getTitle () {
        return name;
    }

    public Author getAuthor() {
        return author;
    }
    public Person getOwner () {
        return owner;
    }

    public Long getBook_ID() {
        return bookId;
    }

    public double getPrice() {
        return price;
    }

    public int getEdition() {
        return edition;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void changeOwner (Person member) {
        this.owner = member;
    }
    public void updateStatus (Status status) {
        this.status = status;
    }
    public void display() {
        System.out.println(this);
    }
    @Override
    public String toString() {
        return "Book{" +
                "id=" + bookId +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", status=" + status +
                '}';
    }
}
