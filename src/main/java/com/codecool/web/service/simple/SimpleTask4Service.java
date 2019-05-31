package com.codecool.web.service.simple;

import com.codecool.web.dao.Task4Dao;
import com.codecool.web.model.Task4Model;
import com.codecool.web.service.Task4Service;


import java.sql.SQLException;
import java.util.List;

public class SimpleTask4Service implements Task4Service {
    
    private final Task4Dao task4Dao;
    
    public SimpleTask4Service(Task4Dao task4Dao) {
        this.task4Dao = task4Dao;
    }
    
    @Override
    public List<Task4Model> findAll() throws SQLException {
        return task4Dao.getResult();
    }
    
    @Override
    public Task4Model findByCompanyName(String companyName) throws SQLException {
        
        return task4Dao.findByCompanyName(companyName);
    }
}
