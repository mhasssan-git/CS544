package cs544;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.*;

@Entity
public class Student {
	@Id
	private long studentid;
	@Basic(optional = true,fetch = FetchType.LAZY)
	private String firstname;
	@Column(length = 32,nullable = false)
	private String lastname;
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private Collection<Course> courselist = new ArrayList<Course>();

	public Student() {
	}

	public Student(long studentid, String firstname, String lastname) {
		this.studentid = studentid;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public long getStudentid() {
		return studentid;
	}

	public void setStudentid(long studentid) {
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

	public Collection<Course> getCourselist() {
		return courselist;
	}

	public void addCourse(Course course) {
		this.courselist.add(course);
	}

}
