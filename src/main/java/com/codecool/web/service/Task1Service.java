package com.codecool.web.service;

import com.codecool.web.model.Task1Model;

import java.sql.SQLException;
import java.util.List;

public interface Task1Service {
    
    List<Task1Model> findAll() throws SQLException;
    
    List<Task1Model> findByCompanyName(String companyName) throws SQLException;
}
