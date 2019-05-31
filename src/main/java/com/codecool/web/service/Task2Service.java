package com.codecool.web.service;

import com.codecool.web.model.Task2Model;


import java.sql.SQLException;
import java.util.List;

public interface Task2Service {
    
    List<Task2Model> findAll() throws SQLException;
    
    Task2Model findByNumberOfProducts(String numberOfProducts) throws SQLException;
}
