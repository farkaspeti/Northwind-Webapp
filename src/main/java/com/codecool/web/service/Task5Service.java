package com.codecool.web.service;

import com.codecool.web.model.Task5Model;


import java.sql.SQLException;
import java.util.List;

public interface Task5Service {
    
    List<Task5Model> findAll() throws SQLException;
    
    List<Task5Model> findByProductName(String productName) throws SQLException;
    
    List<Task5Model> findByCompanyName(String companyName) throws SQLException;
}
