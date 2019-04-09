package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.text.NumberFormat;

@Entity
public class AlbumDetail {

    @Id
    private int albumId;

    private String albumName;
    private BigDecimal albumPrice;
    private String genreName;
    private String retailerName;
    private String artistName;
    private int bookshelfId;
    private BigDecimal faceValue;

    public AlbumDetail(int albumId, String albumName, BigDecimal albumPrice, String genreName, String retailerName, String artistName, int bookshelfId, BigDecimal faceValue) {
        this.albumId = albumId;
        this.albumName = albumName;
        this.albumPrice = albumPrice;
        this.genreName = genreName;
        this.retailerName = retailerName;
        this.artistName = artistName;
        this.bookshelfId = bookshelfId;
        this.faceValue = faceValue;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
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

    public void setAlbumPrice(BigDecimal albumPrice) {
        this.albumPrice = albumPrice;
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

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
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
