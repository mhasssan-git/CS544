package cs544;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderLine {
    @Id
    private Long id;
    private int quantity;
    @ManyToOne
    private Product product;
}
