package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class FinalAlbumCollectionTable {

    @Id
    private int bookshelfId;

    private int albumId;
    private String albumName;
    private String artistName;
    private BigDecimal albumPrice;
    private String albumGenreName;
    private String retailerName;

    public FinalAlbumCollectionTable(int bookshelfId, int albumId, String albumName,
                                     String artistName, BigDecimal albumPrice,
                                     String albumGenreName, String retailerName) {
        this.bookshelfId = bookshelfId;
        this.albumId = albumId;
        this.albumName = albumName;
        this.artistName = artistName;
        this.albumPrice = albumPrice;
        this.albumGenreName = albumGenreName;
        this.retailerName = retailerName;
    }

    public int getBookshelfId() {
        return bookshelfId;
    }

    public int getAlbumId() {
        return albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public BigDecimal getAlbumPrice() {
        return albumPrice;
    }

    public String getAlbumGenreName() {
        return albumGenreName;
    }

    public String getRetailerName() {
        return retailerName;
    }
}
