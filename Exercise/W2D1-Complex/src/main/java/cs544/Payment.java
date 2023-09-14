package cs544;

import jakarta.persistence.Embeddable;

@Embeddable
public class Payment {
    private  String paydate;
    private double amount;
}
