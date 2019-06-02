package com.codecool.web.dao;

import com.codecool.web.model.Task3Model;

import java.sql.SQLException;
import java.util.List;

public interface Task3Dao {
    
    List<Task3Model> getResult() throws SQLException;
    
    List<Task3Model> findByCompanyName(String companyName) throws SQLException;
    
}
