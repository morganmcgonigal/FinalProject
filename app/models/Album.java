package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.text.NumberFormat;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int albumId;

    private String artistName;
    private String albumName;
    private BigDecimal albumPrice;
    private int albumGenreId;
    private int bookshelfId;
    private int retailerId;
    private BigDecimal faceValue;

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public BigDecimal getAlbumPrice() {
        return albumPrice;
    }

    public String getFormattedAlbumPrice(){
        return NumberFormat.getCurrencyInstance().format(albumPrice);
    }

    public void setAlbumPrice(BigDecimal albumPrice) {
        this.albumPrice = albumPrice;
    }

    public int getAlbumGenreId() {
        return albumGenreId;
    }

    public void setAlbumGenreId(int albumGenreId) {
        this.albumGenreId = albumGenreId;
    }

    public int getBookshelfId() {
        return bookshelfId;
    }

    public void setBookshelfId(int bookshelfId) {
        this.bookshelfId = bookshelfId;
    }

    public int getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(int retailerId) {
        this.retailerId = retailerId;
    }

    public BigDecimal getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(BigDecimal faceValue) {
        this.faceValue = faceValue;
    }
}
