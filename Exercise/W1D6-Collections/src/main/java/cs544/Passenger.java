package cs544;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Passenger {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public List<Flight> getFlights() {
        return flights;
    }

    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Flight> flights=new ArrayList<Flight>();

    public Passenger(String name) {
        this.name = name;
    }

    public Passenger() {

    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
