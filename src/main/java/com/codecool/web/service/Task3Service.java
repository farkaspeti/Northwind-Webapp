package com.codecool.web.service;

import com.codecool.web.model.Task3Model;


import java.sql.SQLException;
import java.util.List;

public interface Task3Service {
    
    List<Task3Model> findAll() throws SQLException;
    
    List<Task3Model> findByCompanyName(String companyName) throws SQLException;
}
