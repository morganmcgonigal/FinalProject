package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.text.NumberFormat;

@Entity
public class DiscDetail {

//    private int discId;
//
//    private String discName;
//    private BigDecimal discPrice;
//    private int discTypeId;
//    private int genreId;
//    private int retailerId;
//    private int bookshelfId;
//    private String artistName;

    @Id
    private int discId;

    private String discName;
    private BigDecimal discPrice;
    private String discTypeName;
    private String genreName;
    private String retailerName;
    private String artistName;
    private int bookshelfId;

    public DiscDetail(int discId, String discName,
                      BigDecimal discPrice, String discTypeName,
                      String genreName, String retailerName,
                      String artistName, int bookshelfId) {
        this.discId = discId;
        this.discName = discName;
        this.discPrice = discPrice;
        this.discTypeName = discTypeName;
        this.genreName = genreName;
        this.retailerName = retailerName;
        this.artistName = artistName;
        this.bookshelfId = bookshelfId;
    }

    public int getDiscId() {
        return discId;
    }

    public String getDiscName() {
        return discName;
    }

    public BigDecimal getDiscPrice() {
        return discPrice;
    }

    public String getFormattedDiscPrice(){
        return NumberFormat.getCurrencyInstance().format(discPrice);
    }

    public String getDiscTypeName() {
        return discTypeName;
    }

    public String getGenreName() {
        return genreName;
    }

    public String getRetailerName() {
        return retailerName;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getBookshelfId() {
        return bookshelfId;
    }
}
