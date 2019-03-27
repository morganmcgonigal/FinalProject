package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DiscType {

    @Id
    private int discTypeId;

    private String discTypeName;

    public int getDiscTypeId() {
        return discTypeId;
    }

    public void setDiscTypeId(int discTypeId) {
        this.discTypeId = discTypeId;
    }

    public String getDiscTypeName() {
        return discTypeName;
    }

    public void setDiscTypeName(String discTypeName) {
        this.discTypeName = discTypeName;
    }
}
