package cs544;

import jakarta.persistence.Entity;

@Entity
public class DVD extends Product {
    private String genre;

    public DVD(String genre) {
        this.genre = genre;
    }

    public DVD() {

    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
