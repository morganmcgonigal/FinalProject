package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class FinalGameCollectionTable {

    @Id
    private int bookshelfId;

    private int gameId;
    private String gameName;
    private BigDecimal gamePrice;
    private String gameTypeName;
    private String consoleName;
    private String retailerName;
    private String gameGenreName;

    public FinalGameCollectionTable(int bookshelfId, int gameId, String gameName, BigDecimal gamePrice, String gameTypeName, String consoleName, String retailerName, String discGenreName) {
        this.bookshelfId = bookshelfId;
        this.gameId = gameId;
        this.gameName = gameName;
        this.gamePrice = gamePrice;
        this.gameTypeName = gameTypeName;
        this.consoleName = consoleName;
        this.retailerName = retailerName;
        this.gameGenreName = discGenreName;
    }

    public int getBookshelfId() {
        return bookshelfId;
    }

    public int getGameId() {
        return gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public BigDecimal getGamePrice() {
        return gamePrice;
    }

    public String getGameTypeName() {
        return gameTypeName;
    }

    public String getConsoleName() {
        return consoleName;
    }

    public String getRetailerName() {
        return retailerName;
    }

    public String getGameGenreName() {
        return gameGenreName;
    }
}
