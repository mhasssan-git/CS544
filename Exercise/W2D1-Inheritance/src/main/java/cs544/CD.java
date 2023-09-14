package cs544;

import jakarta.persistence.Entity;

@Entity
public class CD extends Product {
    private String artist;

    public CD(String artist) {
        this.artist = artist;
    }

    public CD() {

    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
