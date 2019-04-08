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

    private String albumGenreName;

    public int getAlbumGenreId() {
        return albumGenreId;
    }

    public void setAlbumGenreId(int albumGenreId) {
        this.albumGenreId = albumGenreId;
    }

    public String getAlbumGenreName() {
        return albumGenreName;
    }

    public void setAlbumGenreName(String albumGenreName) {
        this.albumGenreName = albumGenreName;
    }
}
