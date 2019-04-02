package com.codecool.model;

public class Task4 {

    private String companyName;
    private Short[] orderIDs;

    public Task4(String companyName, Short[] orderIDs) {
        this.companyName = companyName;
        this.orderIDs = orderIDs;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Short[] getOrderIDs() {
        return orderIDs;
    }
}
