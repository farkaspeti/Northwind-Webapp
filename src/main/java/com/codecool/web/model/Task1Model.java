package com.codecool.web.model;

public class Task1Model {
    private String companyName;
    private String productName;
    
    public Task1Model(String companyName, String productName) {
        this.companyName = companyName;
        this.productName = productName;
    }
    
    public String getCompanyName() {
        return companyName;
    }
    
    public String getProductName() {
        return productName;
    }
}
