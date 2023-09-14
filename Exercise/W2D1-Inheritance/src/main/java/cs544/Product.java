package cs544;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="product_type")
public abstract class Product {
    @Id
    private Long id;
    private String name;
    private String description;
}
