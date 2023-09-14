package cs544;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Office {

    @Id
    private Long roomnumber;
    private String building;
    @OneToMany(mappedBy = "office",cascade = CascadeType.PERSIST)
    private List<Employee> employees=new ArrayList<>();

    public void setRoomnumber(Long roomnumber) {
        this.roomnumber = roomnumber;
    }

    public Long getRoomnumber() {
        return roomnumber;
    }
}
