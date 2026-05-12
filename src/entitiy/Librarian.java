package entitiy;

import enums.Status;

import java.util.List;

public class Librarian extends Person {
    private String password;

    public Librarian(String name, String password) {
        super(name);
        this.password = password;
    }

    public Book searchBook(List<Book> books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public boolean verifyMember(MemberRecord member) {
        return member != null && member.canBorrowBook();
    }

    public void issueBook (Book book, MemberRecord member) {
        if (book.getStatus() == Status.AVAILABLE && verifyMember(member)) {
            book.updateStatus(Status.NOT_AVAILABLE);
            book.changeOwner(member);
            member.incBookIssued();
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book cannot be issued.");
        }
    }

    public double calculateFine (int lateDays) {
        if(lateDays > 0) {
            return 0;
        } else {
            return lateDays * 5;
        }
    }

    public void createBill (MemberRecord member, int lateDays) {
        double fine = calculateFine(lateDays);
        System.out.println("Bill created for " + member.getName() + ": " + fine + " TL");
    }

    public void returnBook (Book book, MemberRecord member) {
        book.updateStatus(Status.AVAILABLE);
        book.changeOwner(null);
        member.decBookIssued();
        System.out.println("Book returned successfully.");
    }

}
