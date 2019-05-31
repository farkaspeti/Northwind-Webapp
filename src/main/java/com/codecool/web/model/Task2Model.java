package com.codecool.web.model;

public class Task2Model {
    private String companyName;
    private int numberOfProducts;
    
    public Task2Model(String companyName, int numberOfProducts) {
        this.companyName = companyName;
        this.numberOfProducts = numberOfProducts;
    }
    
    public String getCompanyName() {
        return companyName;
    }
    
    public int getNumberOfProducts() {
        return numberOfProducts;
    }
}
