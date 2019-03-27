package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.text.NumberFormat;

@Entity
public class Disc {

    @Id
    private int discId;

    private String discName;
    private BigDecimal discPrice;
    private int discTypeId;
    private int genreId;
    private int retailerId;
    private int bookshelfId;
    private String artistName;

    public int getDiscId() {
        return discId;
    }

    public String getDiscName() {
        return discName;
    }

    public BigDecimal getDiscPrice() {
        return discPrice;
    }

    public int getDiscTypeId() {
        return discTypeId;
    }

    public int getGenreId() {
        return genreId;
    }

    public int getRetailerId() {
        return retailerId;
    }

    public int getBookshelfId() {
        return bookshelfId;
    }

    public String getArtistName() {
        return artistName;
    }
}
