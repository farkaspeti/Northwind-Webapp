package com.codecool.web.dao;

import com.codecool.web.model.Task1Model;

import java.sql.SQLException;
import java.util.List;

public interface Task1Dao {
    
    List<Task1Model> getResult() throws SQLException;
    
    List<Task1Model> findByCompanyName(String companyName) throws SQLException;
    
}
