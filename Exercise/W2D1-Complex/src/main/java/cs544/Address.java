package cs544;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    private long id;
    private String street;
    private String state;
    private String zip;
    private String city;
    @OneToOne
    @MapsId
    private Patient patient;

    public Address(String street, String state, String zip, String city) {
        this.street = street;
        this.state = state;
        this.zip = zip;
        this.city = city;
    }

    public Address() {

    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
