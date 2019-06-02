package com.codecool.web.dao.database;

import com.codecool.web.dao.Task2Dao;
import com.codecool.web.model.Task2Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTask2Dao extends AbstractDao implements Task2Dao {
    
    public DatabaseTask2Dao(Connection connection) {
        super(connection);
    }
    
    @Override
    public List<Task2Model> getResult() throws SQLException {
        
        List<Task2Model> task2Query = new ArrayList<>();
        String sqlString = "SELECT company_name AS company, COUNT(product_name) AS numberofproducts FROM products " +
            "FULL JOIN suppliers " +
            "ON suppliers.supplier_id = products.supplier_id " +
            "GROUP BY company_name " +
            "ORDER BY numberofproducts DESC, company ASC;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlString)) {
            while (resultSet.next()) {
                task2Query.add(fetchQuery(resultSet));
            }
        }
        return task2Query;
    }
    
    @Override
    public List<Task2Model> findByNumberOfProducts(int numberOfProducts) throws SQLException {
        
        List<Task2Model> task2Query = new ArrayList<>();
        String sqlString = "SELECT company_name AS company, COUNT(product_name) AS numberofproducts FROM products " +
            "FULL JOIN suppliers " +
            "ON suppliers.supplier_id = products.supplier_id " +
            "GROUP BY company_name " +
            "HAVING COUNT(product_name) = ? " +
            "ORDER BY numberofproducts DESC, company ASC;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
            preparedStatement.setInt(1, numberOfProducts);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    task2Query.add(fetchQuery(resultSet));
                }
                return task2Query;
            }
        }
        
    }
    
    
    private Task2Model fetchQuery(ResultSet resultSet) throws SQLException {
        String companyName = resultSet.getString("company");
        int numberOfProducts = resultSet.getInt("numberofproducts");
        return new Task2Model(companyName, numberOfProducts);
    }
}
