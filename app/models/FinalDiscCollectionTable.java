package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class FinalDiscCollectionTable {

    @Id
    private int bookshelfId;

    private int discId;
    private String discName;
    private BigDecimal discPrice;
    private String discTypeName;
    private String retailerName;
    private String discGenreName;

    public FinalDiscCollectionTable(int bookshelfId, int discId, String discName, BigDecimal discPrice, String discTypeName, String retailerName, String discGenreName) {
        this.bookshelfId = bookshelfId;
        this.discId = discId;
        this.discName = discName;
        this.discPrice = discPrice;
        this.discTypeName = discTypeName;
        this.retailerName = retailerName;
        this.discGenreName = discGenreName;
    }

    public int getBookshelfId() {
        return bookshelfId;
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

    public String getDiscTypeName() {
        return discTypeName;
    }

    public String getRetailerName() {
        return retailerName;
    }

    public String getDiscGenreName() {
        return discGenreName;
    }
}
