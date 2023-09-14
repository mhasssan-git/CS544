package cs544;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class School {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Student> students=new ArrayList<>();

    public School(String name) {
        this.name = name;
    }

    public School() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public void addStudent(Student student)
    {
        this.students.add(student);
    }
}
