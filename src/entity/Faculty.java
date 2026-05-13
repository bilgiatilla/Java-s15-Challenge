package entity;

import enums.Type;

public class Faculty extends MemberRecord {
    private String facultyId;
    private String department;

    public Faculty (Long personId, long memberId, String name, String address, String phoneNo, String studentId, String department) {
        super(personId, memberId, name, Type.STUDENT, address, phoneNo);
        this.facultyId = facultyId;
        this.department = department;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public String getDepartment() {
        return department;
    }
}
