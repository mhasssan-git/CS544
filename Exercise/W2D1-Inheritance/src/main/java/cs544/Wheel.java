package cs544;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Wheel {
@Id
    private Long id;

    private int size;

    private double pressure;

}
