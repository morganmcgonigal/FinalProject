package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.text.NumberFormat;

@Entity
public class BookDetail {

    @Id
    private int bookId;
    private String bookName;
    private BigDecimal bookPrice;
    private String bookTypeName;
    private String genreName;
    private String retailerName;
    private String authorName;

//                      b.bookId,   b.bookName     "b.bookPrice
//                       bt.bookTypeName       g.genreName
//                      r.retailerName         b.authorName)

    public BookDetail(int bookId, String bookName, BigDecimal bookPrice,
                      String bookTypeName, String genreName,
                      String retailerName, String authorName) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookTypeName = bookTypeName;
        this.genreName = genreName;
        this.retailerName = retailerName;
        this.authorName = authorName;
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

    public String getFormattedBookPrice(){
        return NumberFormat.getCurrencyInstance().format(bookPrice);
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
}
