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
    private int bookshelfId;
    private BigDecimal faceValue;

    public DiscDetail(int discId, String discName, BigDecimal discPrice, String discTypeName, String genreName, String retailerName, int bookshelfId, BigDecimal faceValue) {
        this.discId = discId;
        this.discName = discName;
        this.discPrice = discPrice;
        this.discTypeName = discTypeName;
        this.genreName = genreName;
        this.retailerName = retailerName;
        this.bookshelfId = bookshelfId;
        this.faceValue = faceValue;
    }

    public int getDiscId() {
        return discId;
    }

    public void setDiscId(int discId) {
        this.discId = discId;
    }

    public String getDiscName() {
        return discName;
    }

    public void setDiscName(String discName) {
        this.discName = discName;
    }

    public BigDecimal getDiscPrice() {
        return discPrice;
    }

    public void setDiscPrice(BigDecimal discPrice) {
        this.discPrice = discPrice;
    }

    public String getDiscTypeName() {
        return discTypeName;
    }

    public void setDiscTypeName(String discTypeName) {
        this.discTypeName = discTypeName;
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
