package test;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "tblPerson")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @OneToOne
    //@PrimaryKeyJoinColumn
    private Car car;
    private String name;

}
