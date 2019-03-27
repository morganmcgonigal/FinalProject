package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Console {

    @Id
    private int consoleId;

    private String consoleName;

    public int getConsoleId() {
        return consoleId;
    }

    public String getConsoleName() {
        return consoleName;
    }
}
