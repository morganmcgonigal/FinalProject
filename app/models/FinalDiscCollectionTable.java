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
    private BigDecimal faceValue;
    private BigDecimal totalPrice;

    public FinalDiscCollectionTable(int bookshelfId, int discId, String discName,
                                    BigDecimal discPrice, String discTypeName,
                                    String retailerName, String discGenreName, BigDecimal faceValue,
                                    BigDecimal totalPrice) {
        this.bookshelfId = bookshelfId;
        this.discId = discId;
        this.discName = discName;
        this.discPrice = discPrice;
        this.discTypeName = discTypeName;
        this.retailerName = retailerName;
        this.discGenreName = discGenreName;
        this.faceValue = faceValue;
        this.totalPrice = totalPrice;
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

    public BigDecimal getFaceValue() {
        return faceValue;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
