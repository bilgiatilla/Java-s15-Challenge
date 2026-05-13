package entity;

import enums.Status;

import java.util.List;

public class Librarian extends Person {
    private String password;

    public Librarian(Long personId, String name, String password) {
        super(personId, name);
        this.password = password;
    }
    public boolean verifyMember(MemberRecord member) {
        return member != null && member.canBorrowBook();
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am a librarian. My name is " + getName());
    }
}
