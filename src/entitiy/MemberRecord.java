package entitiy;

import enums.Type;

import java.time.LocalDate;

public class MemberRecord {
    private Long memberId;
    private Type type;
    private LocalDate dateOfMembership;
    private int noBooksIssued;
    private int maxBookLimit;
    private String name;
    private String address;
    private String phoneNo;

    public void getMember() {
        System.out.println(this);
    }
    public void incBookIssued() {
        noBooksIssued++;
    }
    public void decBookIssued() {
        noBooksIssued--;
    }
    public void payBill() {
        System.out.println("Bill paid");
    }
}
