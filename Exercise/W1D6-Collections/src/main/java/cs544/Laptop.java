package cs544;

import jakarta.persistence.*;

@Entity
public class Laptop
{
    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private String type;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Employee owner;

    public Laptop() {

    }
    public Laptop(String brand, String type, Employee owner) {
        this.brand = brand;
        this.type = type;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
