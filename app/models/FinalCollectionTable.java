package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class FinalCollectionTable {

    @Id
    private int bookshelfId;

    private int bookId;
    private String bookName;
    private BigDecimal bookPrice;
    private String bookTypeName;
    private String genreName;
    private String retailerName;
    private String authorName;
    private BigDecimal faceValue;
    private BigDecimal totalPrice;


    public FinalCollectionTable(int bookshelfId, int bookId, String bookName, BigDecimal bookPrice, String bookTypeName, String genreName, String retailerName, String authorName, BigDecimal faceValue, BigDecimal totalPrice) {
        this.bookshelfId = bookshelfId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookTypeName = bookTypeName;
        this.genreName = genreName;
        this.retailerName = retailerName;
        this.authorName = authorName;
        this.faceValue = faceValue;
        this.totalPrice = totalPrice;
    }

    public int getBookshelfId() {
        return bookshelfId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public String getBookTypeName() {
        return bookTypeName;
    }

    public String getGenreName() {
        return genreName;
    }

    public String getRetailerName() {
        return retailerName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public BigDecimal getFaceValue() {
        return faceValue;
    }

    public BigDecimal getTotalPrice(){
        return totalPrice;
    }
}
