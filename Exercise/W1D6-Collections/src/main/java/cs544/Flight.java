package cs544;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Flight {
    @Id
    @GeneratedValue
    private Long id;
    private String flightnumber;
    @Column(name = "dFrom")
    private String from;
    @Column(name = "dTo")
    private String to;

    @Temporal(TemporalType.DATE)
    private Date date;

    public Flight(String flightnumber, String from, String to, Date date) {
        this.flightnumber = flightnumber;
        this.from = from;
        this.to = to;
        this.date = date;
    }

    public Flight() {

    }

    public Long getId() {
        return id;
    }


    public String getFlightnumber() {
        return flightnumber;
    }

    public void setFlightnumber(String flightnumber) {
        this.flightnumber = flightnumber;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
