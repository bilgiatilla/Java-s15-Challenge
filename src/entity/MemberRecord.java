package entity;

import enums.Type;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberRecord extends Person {
    private Long memberId;
    private Type type;
    private LocalDate dateOfMembership;
    private int noBooksIssued;
    private int maxBookLimit = 5;
    private String address;
    private String phoneNo;
    private List<Book> borrowedBooks;

    public MemberRecord(Long personId, Long memberId, String name, Type type, String address, String phoneNo) {
        super(personId, name);
        this.memberId = memberId;
        this.type = type;
        this.address = address;
        this.phoneNo = phoneNo;
        this.dateOfMembership = LocalDate.now();
        this.noBooksIssued = 0;
        this.borrowedBooks = new ArrayList<>();
    }

    public Long getMemberId() {
        return memberId;
    }

    public Type getType() {
        return type;
    }

    public int getNoBooksIssued() {
        return noBooksIssued;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        if (canBorrowBook()) {
            borrowedBooks.add(book);
            noBooksIssued++;
        }
    }
    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            noBooksIssued--;
        }
    }

    public void payBill(Bill bill) {
        bill.markAsPaid();
    }

    public boolean canBorrowBook() {
        return noBooksIssued < maxBookLimit;
    }
    @Override
    public void whoYouAre() {
        System.out.println("I am a library member. My name is " + getName());
    }
}
