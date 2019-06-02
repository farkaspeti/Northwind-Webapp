package com.codecool.web.service.simple;

import com.codecool.web.dao.Task5Dao;
import com.codecool.web.model.Task5Model;
import com.codecool.web.service.Task5Service;


import java.sql.SQLException;
import java.util.List;

public class SimpleTask5Service implements Task5Service {
    
    private final Task5Dao task5Dao;
    
    public SimpleTask5Service(Task5Dao task5Dao) {
        this.task5Dao = task5Dao;
    }
    
    @Override
    public List<Task5Model> findAll() throws SQLException {
        return task5Dao.getResult();
    }
    
    @Override
    public List<Task5Model> findByProductName(String productName) throws SQLException {
        
        return task5Dao.findByProductName(productName);
        
    }
    
    @Override
    public List<Task5Model> findByCompanyName(String companyName) throws SQLException {
        
        return task5Dao.findByCompanyName(companyName);
        
    }
    
}
