package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DiscType {

    @Id
    private int discTypeId;

    private String discTypeName;
}
