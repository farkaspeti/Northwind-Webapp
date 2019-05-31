package com.codecool.web.model;

public class Task5Model {
    private String companyName;
    private String productName;
    private double productPrice;
    
    public Task5Model(String companyName, String productName, double productPrice) {
        this.companyName = companyName;
        this.productName = productName;
        this.productPrice = productPrice;
    }
    
    public String getCompanyName() {
        return companyName;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public double getProductPrice() {
        return productPrice;
    }
}
