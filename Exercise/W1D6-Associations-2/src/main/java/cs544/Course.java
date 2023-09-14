package cs544;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String courseNumber;
    private  String name;
    @ManyToMany(mappedBy = "courseList",cascade = CascadeType.PERSIST)
    private List<Student> students=new ArrayList<Student>();
    public Course(String courseNumber, String name) {
        this.courseNumber = courseNumber;
        this.name = name;
    }

    public Course() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
