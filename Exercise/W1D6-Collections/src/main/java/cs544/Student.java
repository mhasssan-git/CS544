package cs544;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private Long studentid;
    private String firstname;
    private String lastname;

    public Student(Long studentid, String firstname, String lastname) {
        this.studentid = studentid;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Student() {

    }

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
