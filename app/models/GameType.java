package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GameType {

    @Id
    private int gameTypeId;

    private String gameTypeName;

    public int getGameTypeId() {
        return gameTypeId;
    }

    public void setGameTypeId(int gameTypeId) {
        this.gameTypeId = gameTypeId;
    }

    public String getGameTypeName() {
        return gameTypeName;
    }

    public void setGameTypeName(String gameTypeName) {
        this.gameTypeName = gameTypeName;
    }
}
