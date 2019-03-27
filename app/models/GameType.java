package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GameType {

    @Id
    private int gameTypeId;

    private String gameTypeName;
}
