package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bookshelf {

    @Id
    private int bookshelfId;

    private String bookshelfName;

    public int getBookshelfId() {
        return bookshelfId;
    }

    public void setBookshelfId(int bookshelfId) {
        this.bookshelfId = bookshelfId;
    }

    public String getBookshelfName() {
        return bookshelfName;
    }

    public void setBookshelfName(String bookshelfName) {
        this.bookshelfName = bookshelfName;
    }
}
