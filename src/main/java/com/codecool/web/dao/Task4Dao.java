package com.codecool.web.dao;

import com.codecool.web.model.Task4Model;

import java.sql.SQLException;
import java.util.List;

public interface Task4Dao {
    
    List<Task4Model> getResult() throws SQLException;
    
    List<Task4Model> findByCompanyName(String companyName) throws SQLException;
    
}
