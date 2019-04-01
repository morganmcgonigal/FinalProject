package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookGenre {

    @Id
    private int bookGenreId;

    private String genreName;

    public int getBookGenreId() {
        return bookGenreId;
    }

    public void setBookGenreId(int bookGenreId) {
        this.bookGenreId = bookGenreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
