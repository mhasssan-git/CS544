package cs544;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.util.Date;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private long isbn;
    private String title;
    private String author;

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinTable(name = "book_publisher",joinColumns = {
            @JoinColumn(name = "book_isbn")},
    inverseJoinColumns = {
            @JoinColumn(name="publisher_id")
    })
    private Publisher publisher;

    public Book(String title, String author,Publisher publisher) {
        this.title = title;
        this.author = author;
        this.publisher=publisher;
    }

    public Book() {

    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
