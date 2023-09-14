package test;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "tblCar")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @OneToOne
    private Person person;
    private String model;
}
