package entity;

import enums.Type;

public class Student extends MemberRecord {
    private String studentId;
    private String department;

    public Student (Long personId, long memberId, String name, String address, String phoneNo, String studentId, String department) {
        super(personId, memberId, name, Type.STUDENT ,address, phoneNo);
        this.studentId = studentId;
        this.department = department;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getDepartment() {
        return department;
    }
}
