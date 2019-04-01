package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GameGenre {

    @Id
    private int gameGenreId;

    private String genreName;

    public int getGameGenreId() {
        return gameGenreId;
    }

    public void setGameGenreId(int gameGenreId) {
        this.gameGenreId = gameGenreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
