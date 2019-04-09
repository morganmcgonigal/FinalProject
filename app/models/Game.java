package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.text.NumberFormat;

@Entity
public class Game {

    @Id
    private int gameId;

    private String gameName;
    private BigDecimal gamePrice;
    private int gameTypeId;
    private int gameGenreId;
    private int retailerId;
    private int consoleId;
    private int bookshelfId;
    private BigDecimal faceValue;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public BigDecimal getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(BigDecimal gamePrice) {
        this.gamePrice = gamePrice;
    }

    public String getFormattedGamePrice(){
        return NumberFormat.getCurrencyInstance().format(gamePrice);
    }

    public int getGameTypeId() {
        return gameTypeId;
    }

    public void setGameTypeId(int gameTypeId) {
        this.gameTypeId = gameTypeId;
    }

    public int getGameGenreId() {
        return gameGenreId;
    }

    public void setGameGenreId(int gameGenreId) {
        this.gameGenreId = gameGenreId;
    }

    public int getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(int retailerId) {
        this.retailerId = retailerId;
    }

    public int getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(int consoleId) {
        this.consoleId = consoleId;
    }

    public int getBookshelfId() {
        return bookshelfId;
    }

    public void setBookshelfId(int bookshelfId) {
        this.bookshelfId = bookshelfId;
    }

    public BigDecimal getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(BigDecimal faceValue) {
        this.faceValue = faceValue;
    }
}
