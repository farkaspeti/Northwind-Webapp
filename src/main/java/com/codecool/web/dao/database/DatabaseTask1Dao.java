package com.codecool.web.dao.database;

import com.codecool.web.dao.Task1Dao;
import com.codecool.web.model.Task1Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTask1Dao extends AbstractDao implements Task1Dao {
    
    public DatabaseTask1Dao(Connection connection) {
        super(connection);
    }
    
    @Override
    public List<Task1Model> getResult() throws SQLException {
        
        List<Task1Model> task1Query = new ArrayList<>();
        String sqlString = "SELECT company_name,product_name FROM suppliers " +
            "LEFT JOIN products " +
            "ON suppliers.supplier_id = products.supplier_id " +
            "ORDER BY company_name,product_name ASC;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlString)) {
            while (resultSet.next()) {
                task1Query.add(fetchQuery(resultSet));
            }
            return task1Query;
        }
    }
    
    @Override
    public List<Task1Model> findByCompanyName(String companyName) throws SQLException {
        
        List<Task1Model> task1Query = new ArrayList<>();
        String sqlString = "SELECT company_name,product_name FROM suppliers " +
            "LEFT JOIN products " +
            "ON suppliers.supplier_id = products.supplier_id " +
            "WHERE company_name = ?" +
            " ORDER BY product_name, company_name ASC;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
            preparedStatement.setString(1, companyName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    task1Query.add(fetchQuery(resultSet));
                }
                return task1Query;
            }
        }
    }
    
    private Task1Model fetchQuery(ResultSet resultSet) throws SQLException {
        String productName = resultSet.getString("product_name");
        String companyName = resultSet.getString("company_name");
        return new Task1Model(companyName, productName);
    }
}
