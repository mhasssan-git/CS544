package cs544;

import jakarta.persistence.Entity;

@Entity
public class Book extends Product {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
