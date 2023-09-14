package cs544;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tblOrder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderid;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Customer customer;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<OrderLine> orderLines = new ArrayList<OrderLine>();

    public Order(Date date, Customer customer) {
        this.date = date;
        this.customer = customer;
    }

    public Order() {

    }

    public Long getOrderid() {
        return orderid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
