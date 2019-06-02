package com.codecool.web.dao;

import com.codecool.web.model.Task2Model;

import java.sql.SQLException;
import java.util.List;

public interface Task2Dao {
    
    List<Task2Model> getResult() throws SQLException;
    
    List<Task2Model> findByNumberOfProducts(int numberOfProducts) throws SQLException;
    
}
