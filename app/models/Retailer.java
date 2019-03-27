package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Retailer {

    @Id
    private int retailerId;

    private String retailerName;

    public int getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(int retailerId) {
        this.retailerId = retailerId;
    }

    public String getRetailerName() {
        return retailerName;
    }

    public void setRetailerName(String retailerName) {
        this.retailerName = retailerName;
    }
}
