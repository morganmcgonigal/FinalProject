package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.text.NumberFormat;

@Entity
public class GameDetail {

    @Id
    private int gameId;

    private BigDecimal gamePrice;
    private String gameName;
    private String gameTypeName;
    private String genreName;
    private String retailerName;
    private String consoleName;
    private int bookshelfId;
    private BigDecimal faceValue;

    public GameDetail(int gameId, BigDecimal gamePrice, String gameName, String gameTypeName, String genreName, String retailerName, String consoleName, int bookshelfId, BigDecimal faceValue) {
        this.gameId = gameId;
        this.gamePrice = gamePrice;
        this.gameName = gameName;
        this.gameTypeName = gameTypeName;
        this.genreName = genreName;
        this.retailerName = retailerName;
        this.consoleName = consoleName;
        this.bookshelfId = bookshelfId;
        this.faceValue = faceValue;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public BigDecimal getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(BigDecimal gamePrice) {
        this.gamePrice = gamePrice;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameTypeName() {
        return gameTypeName;
    }

    public void setGameTypeName(String gameTypeName) {
        this.gameTypeName = gameTypeName;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getRetailerName() {
        return retailerName;
    }

    public void setRetailerName(String retailerName) {
        this.retailerName = retailerName;
    }

    public String getConsoleName() {
        return consoleName;
    }

    public void setConsoleName(String consoleName) {
        this.consoleName = consoleName;
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
