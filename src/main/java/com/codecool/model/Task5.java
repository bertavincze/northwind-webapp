package com.codecool.model;

public class Task5 {

    private String companyName;
    private String productName;
    private double price;

    public Task5(String companyName, String productName, double price) {
        this.companyName = companyName;
        this.productName = productName;
        this.price = price;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
}
