package cs544;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "owner",cascade = CascadeType.ALL)
    private Set<Laptop> laptopSet = new HashSet<Laptop>();

    public Employee() {

    }

    public Long getId() {
        return id;
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Laptop> getLaptopSet() {
        return laptopSet;
    }

    public void addLaptop(Laptop laptop) {
        laptopSet.add(laptop);
    }
}
