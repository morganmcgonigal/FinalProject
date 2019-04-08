package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookGenre {

    @Id
    private int bookGenreId;

    private String bookGenreName;

    public int getBookGenreId() {
        return bookGenreId;
    }

    public void setBookGenreId(int bookGenreId) {
        this.bookGenreId = bookGenreId;
    }

    public String getBookGenreName() {
        return bookGenreName;
    }

    public void setBookGenreName(String bookGenreName) {
        this.bookGenreName = bookGenreName;
    }
}
