package entitiy;

import enums.Type;

import java.time.LocalDate;

public class MemberRecord extends Person {
    private Long memberId;
    private Type type;
    private LocalDate dateOfMembership;
    private int noBooksIssued;
    private int maxBookLimit;
    private String address;
    private String phoneNo;

    public MemberRecord(String name) {
        super(name);
    }

    public void getMember() {
        System.out.println(this);
    }
    public void incBookIssued() {
        noBooksIssued++;
    }
    public void decBookIssued() {
        if (noBooksIssued > 0) {
            noBooksIssued--;
        }
    }
    public void payBill() {
        System.out.println("Bill paid");
    }

    public boolean canBorrowBook() {
        return noBooksIssued < maxBookLimit;
    }
}
