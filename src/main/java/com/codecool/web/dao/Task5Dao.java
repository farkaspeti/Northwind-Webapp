package com.codecool.web.dao;

import com.codecool.web.model.Task5Model;

import java.sql.SQLException;
import java.util.List;

public interface Task5Dao {
    
    List<Task5Model> getResult() throws SQLException;
    
    Task5Model findByProductName(String productName) throws SQLException;
    
    Task5Model findByCompanyName(String companyName) throws SQLException;
    
}
