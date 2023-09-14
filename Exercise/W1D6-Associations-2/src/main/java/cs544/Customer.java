package cs544;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    private int id;
    private String name;
    @OneToMany
    private List<Reservation> reservations=new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public Customer() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
