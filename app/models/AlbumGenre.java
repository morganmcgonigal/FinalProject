package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AlbumGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int albumGenreId;

    private String genreName;

    public int getAlbumGenreId() {
        return albumGenreId;
    }

    public void setAlbumGenreId(int albumGenreId) {
        this.albumGenreId = albumGenreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
