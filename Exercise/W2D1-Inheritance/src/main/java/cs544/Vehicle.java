package cs544;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SecondaryTable(name="owners")
public class Vehicle {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(table="owners")
    private String owner;

    private String make;

    private String model;

    private int year;

    private String color;
@OneToMany
@JoinColumn
@OrderColumn(name="wheels_ORDER ")

    private List<Wheel> wheels;

}
