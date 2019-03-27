package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Book {

    @Id
    private int bookId;

    private String bookName;
    private BigDecimal bookPrice;
    private int bookTypeId;
    private String bookTypeName;
    private int genreId;
    private String genreName;
    private int retailerId;
    private String retailerName;
    private String authorName;
    private int bookshelfId;

    public Book(String bookName, BigDecimal bookPrice, int bookTypeId, int genreId, int retailerId, String authorName, int bookshelfId) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookTypeId = bookTypeId;
        this.genreId = genreId;
        this.retailerId = retailerId;
        this.authorName = authorName;
        this.bookshelfId = bookshelfId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(int bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public int getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(int retailerId) {
        this.retailerId = retailerId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getBookshelfId() {
        return bookshelfId;
    }

    public void setBookshelfId(int bookshelfId) {
        this.bookshelfId = bookshelfId;
    }
}
