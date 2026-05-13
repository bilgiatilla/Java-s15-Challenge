package entity;

import java.time.LocalDate;

public class Bill {
    private long billId;
    private MemberRecord member;
    private Book book;
    private LocalDate billDate;
    private double amount;
    private boolean paid;
    private boolean refunded;

    public Bill(long billId, MemberRecord member, Book book, double amount) {
        this.billId = billId;
        this.member = member;
        this.book = book;
        this.amount = amount;
        this.billDate = LocalDate.now();
        this.paid = false;
        this.refunded = false;
    }

    public long getBillId() {
        return billId;
    }

    public MemberRecord getMember() {
        return member;
    }

    public Book getBook() {
        return book;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isPaid () {
        return paid;
    }
    public boolean isRefunded () {
        return refunded;
    }

    public void markAsPaid () {
        this.paid = true;
    }

    public void refund() {
        this.refunded = true;
        this.paid = false;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", member=" + member.getName() +
                ", book=" + book.getTitle() +
                ", amount=" + amount +
                ", paid=" + paid +
                ", refunded=" + refunded +
                '}';
    }
}
