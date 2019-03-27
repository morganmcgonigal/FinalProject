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

//                      g.gameId, g.gamePrice, " +
//                      g.gameName, gt.gameTypeName, ge.genreName, " +
//                      r.retailerName, c.consoleName


    public GameDetail(int gameId, BigDecimal gamePrice, String gameName,
                      String gameTypeName, String genreName,
                      String retailerName, String consoleName) {
        this.gameId = gameId;
        this.gamePrice = gamePrice;
        this.gameName = gameName;
        this.gameTypeName = gameTypeName;
        this.genreName = genreName;
        this.retailerName = retailerName;
        this.consoleName = consoleName;
    }

    public int getGameId() {
        return gameId;
    }

    public BigDecimal getGamePrice() {
        return gamePrice;
    }

    public String getFormattedGamePrice(){
        return NumberFormat.getCurrencyInstance().format(gamePrice);
    }

    public String getGameName() {
        return gameName;
    }

    public String getGameTypeName() {
        return gameTypeName;
    }

    public String getGenreName() {
        return genreName;
    }

    public String getRetailerName() {
        return retailerName;
    }

    public String getConsoleName() {
        return consoleName;
    }
}
