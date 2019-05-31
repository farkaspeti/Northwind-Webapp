package com.codecool.web.service.simple;

import com.codecool.web.dao.Task2Dao;
import com.codecool.web.model.Task2Model;
import com.codecool.web.service.Task2Service;


import java.sql.SQLException;
import java.util.List;

public class SimpleTask2Service implements Task2Service {
    private final Task2Dao task2Dao;
    
    public SimpleTask2Service(Task2Dao task2Dao) {
        this.task2Dao = task2Dao;
    }
    
    @Override
    public List<Task2Model> findAll() throws SQLException {
        return task2Dao.getResult();
    }
    
    @Override
    public Task2Model findByNumberOfProducts(String numberOfProducts) throws SQLException {
        
        return task2Dao.findByNumberOfProducts(Integer.parseInt(numberOfProducts));
    }
}
