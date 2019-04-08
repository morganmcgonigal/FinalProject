package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DiscGenre {

    @Id
    private int discGenreId;

    private String discGenreName;

    public int getDiscGenreId() {
        return discGenreId;
    }

    public void setDiscGenreId(int discGenreId) {
        this.discGenreId = discGenreId;
    }

    public String getDiscGenreName() {
        return discGenreName;
    }

    public void setDiscGenreName(String discGenreName) {
        this.discGenreName = discGenreName;
    }
}
