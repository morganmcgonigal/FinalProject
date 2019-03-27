package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookType {

    @Id
    private int bookTypeId;

    private String bookTypeName;

    public int getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(int bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public String getBookTypeName() {
        return bookTypeName;
    }

    public void setBookTypeName(String bookTypeName) {
        this.bookTypeName = bookTypeName;
    }
}
