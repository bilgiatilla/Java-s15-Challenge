package service;

import entity.Bill;
import entity.Book;
import entity.MemberRecord;
import enums.Status;

import java.util.ArrayList;
import java.util.List;

public class LoanService {
    private List<Bill> bills;
    private Long billCounter = 1L;

    public LoanService() {
        this.bills = new ArrayList<>();
    }

    public Bill borrowBook (MemberRecord member, Book book) {
        if (book.getStatus() != Status.AVAILABLE) {
            System.out.println("Book is not available");
            return null;
        }
        if (!member.canBorrowBook()) {
            System.out.println("Member reached maximum book limit.");
            return null;
        }
        book.borrowBy(member);
        member.borrowBook(book);

        Bill bill = new Bill (billCounter++, member, book, book.getPrice());
        bill.markAsPaid();
        bills.add(bill);
        System.out.println("Book borrowed successfully. Bill created.");
        return bill;
    }

    public void returnBook (MemberRecord member, Book book) {
        if (book.getOwner() != member) {
            System.out.println("This book does not belong to this member.");
            return;
        }
        book.returnToLibrary();
        member.returnBook(book);

        Bill bill = findBillByBookAndMember(book, member);

        if (bill != null) {
            bill.refund();
            System.out.println("Book returned successfully. Payment refunded.");
        } else {
            System.out.println("Book returned successfully. Bill not found.");
        }
    }

    private Bill findBillByBookAndMember (Book book, MemberRecord member) {
        for (Bill bill : bills) {
            if (bill.getBook().equals(book) && bill.getMember().equals(member) && !bill.isRefunded()) {
                return bill;
            }
        }
        return null;
    }
    public List<Bill> getBillHistory() {
        return bills;
    }
}
