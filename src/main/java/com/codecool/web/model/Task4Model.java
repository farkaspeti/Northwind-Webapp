package com.codecool.web.model;


import java.sql.Array;
import java.util.List;

public class Task4Model {
    private String companyName;
    private Array orderIDArray;
    
    public Task4Model(String companyName, Array orderIDArray) {
        this.companyName = companyName;
        this.orderIDArray = orderIDArray;
    }
    
    public String getCompanyName() {
        return companyName;
    }
    
    public Array getOrderIDArray() {
        return orderIDArray;
    }
}
