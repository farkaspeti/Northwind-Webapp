package com.codecool.web.dao.database;

import com.codecool.web.dao.Task3Dao;
import com.codecool.web.model.Task3Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTask3Dao extends AbstractDao implements Task3Dao {
    
    public DatabaseTask3Dao(Connection connection) {
        super(connection);
    }
    
    @Override
    public List<Task3Model> getResult() throws SQLException {
        
        List<Task3Model> task3Query = new ArrayList<>();
        String sqlString = "SELECT company_name AS company,COUNT(DISTINCT product_name) AS numberofproducts FROM products " +
            "JOIN suppliers " +
            "ON suppliers.supplier_id = products.supplier_id " +
            "GROUP BY company  " +
            "HAVING COUNT(DISTINCT product_name) = 5 " +
            "ORDER BY company;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlString)) {
            while (resultSet.next()) {
                task3Query.add(fetchQuery(resultSet));
            }
        }
        return task3Query;
    }
    
    @Override
    public Task3Model findByCompanyName(String companyName) throws SQLException {
        
        
        String sqlString = "SELECT company_name AS company,COUNT(DISTINCT product_name) AS numberofproducts FROM products " +
            "JOIN suppliers " +
            "ON suppliers.supplier_id = products.supplier_id " +
            "WHERE company_name = ? " +
            "GROUP BY company " +
            "HAVING COUNT(DISTINCT product_name) = 5 " +
            "ORDER BY company;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
            preparedStatement.setString(1, companyName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchQuery(resultSet);
                }
            }
        }
        return null;
    }
    
    private Task3Model fetchQuery(ResultSet resultSet) throws SQLException {
        String companyName = resultSet.getString("companyName");
        return new Task3Model(companyName);
    }
}
