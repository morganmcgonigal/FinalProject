package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GameGenre {

    @Id
    private int gameGenreId;

    private String gameGenreName;

    public int getGameGenreId() {
        return gameGenreId;
    }

    public void setGameGenreId(int gameGenreId) {
        this.gameGenreId = gameGenreId;
    }

    public String getGameGenreName() {
        return gameGenreName;
    }

    public void setGameGenreName(String gameGenreName) {
        this.gameGenreName = gameGenreName;
    }
}
