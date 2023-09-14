package cs544;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne(mappedBy = "patient")
    private Address address;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointment=new ArrayList<>();
}
