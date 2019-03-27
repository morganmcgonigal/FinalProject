package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Game {

    @Id
    private int gameId;

    private String gameName;
    private BigDecimal gamePrice;
    private int gameTypeId;
    private int genreId;
    private int retailerId;
    private int consoleId;

    public int getGameId() {
        return gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public BigDecimal getGamePrice() {
        return gamePrice;
    }

    public int getGameTypeId() {
        return gameTypeId;
    }

    public int getGenreId() {
        return genreId;
    }

    public int getRetailerId() {
        return retailerId;
    }

    public int getConsoleId() {
        return consoleId;
    }
}
