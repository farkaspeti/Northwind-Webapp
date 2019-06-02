package com.codecool.web.service;

import com.codecool.web.model.Task4Model;


import java.sql.SQLException;
import java.util.List;

public interface Task4Service {
    
    List<Task4Model> findAll() throws SQLException;
    
    List<Task4Model> findByCompanyName(String companyName) throws SQLException;
}
