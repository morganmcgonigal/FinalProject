package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DiscGenre {

    @Id
    private int discGenreId;

    private String genreName;

    public int getDiscGenreId() {
        return discGenreId;
    }

    public void setDiscGenreId(int discGenreId) {
        this.discGenreId = discGenreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
