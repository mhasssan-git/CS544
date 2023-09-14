package cs544;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Reservation {
    @Id
    private int id;
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    private Book book;
    public Reservation(Date date) {
        this.date = date;
    }

    public Reservation() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
