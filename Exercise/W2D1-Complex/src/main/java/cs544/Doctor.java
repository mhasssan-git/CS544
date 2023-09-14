package cs544;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Doctor {
    @Id
    private Long id;
    private String doctortype;
    private String firstname;
    private String lastname;
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointment=new ArrayList<>();
}
