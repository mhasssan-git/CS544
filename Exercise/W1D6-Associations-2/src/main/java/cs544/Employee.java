package cs544;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long employeenumber;
    private String name;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Department department;
    @ManyToOne
    private Office office;

    public Employee() {

    }

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public Long getEmployeenumber() {
        return employeenumber;
    }

    public void setEmployeenumber(Long employeenumber) {
        this.employeenumber = employeenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
