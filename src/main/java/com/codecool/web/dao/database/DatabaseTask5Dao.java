package com.codecool.web.dao.database;

import com.codecool.web.dao.Task5Dao;
import com.codecool.web.model.Task5Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTask5Dao extends AbstractDao implements Task5Dao {
    
    public DatabaseTask5Dao(Connection connection) {
        super(connection);
    }
    
    @Override
    public List<Task5Model> getResult() throws SQLException {
        
        List<Task5Model> task5Query = new ArrayList<>();
        String sqlString = "SELECT suppliers.company_name, products.product_name, products.unit_price FROM products " +
            "JOIN suppliers ON suppliers.supplier_id = products.supplier_id " +
            "JOIN (SELECT products.supplier_id, max(products.unit_price) AS unit_price " +
            "FROM products " +
            "GROUP BY products.supplier_id) AS maxquery " +
            "ON products.supplier_id = maxquery.supplier_id AND products.unit_price = maxquery.unit_price " +
            "ORDER BY unit_price DESC;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlString)) {
            while (resultSet.next()) {
                task5Query.add(fetchQuery(resultSet));
            }
        }
        return task5Query;
    }
    
    @Override
    public List<Task5Model> findByProductName(String productName) throws SQLException {
    
        List<Task5Model> task5Query = new ArrayList<>();
        String sqlString = "SELECT suppliers.company_name, products.product_name, products.unit_price FROM products " +
            "JOIN suppliers ON suppliers.supplier_id = products.supplier_id " +
            "JOIN (SELECT products.supplier_id, max(products.unit_price) AS unit_price " +
            "FROM products " +
            "GROUP BY products.supplier_id) AS maxquery " +
            "ON products.supplier_id = maxquery.supplier_id AND products.unit_price = maxquery.unit_price " +
            "WHERE product_name = ? " +
            "ORDER BY unit_price DESC;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
            preparedStatement.setString(1, productName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    task5Query.add(fetchQuery(resultSet));
                }
            }
        }
        return task5Query;
    }
    
    @Override
    public List<Task5Model> findByCompanyName(String companyName) throws SQLException {
        
        List<Task5Model> task5Query = new ArrayList<>();
        String sqlString = "SELECT suppliers.company_name, products.product_name, products.unit_price FROM products " +
            "JOIN suppliers ON suppliers.supplier_id = products.supplier_id " +
            "JOIN (SELECT products.supplier_id, max(products.unit_price) AS unit_price " +
            "FROM products " +
            "GROUP BY products.supplier_id) AS maxquery " +
            "ON products.supplier_id = maxquery.supplier_id AND products.unit_price = maxquery.unit_price " +
            "WHERE company_name = ? " +
            "ORDER BY unit_price DESC;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
            preparedStatement.setString(1, companyName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    task5Query.add(fetchQuery(resultSet));
                }
            }
        }
        return task5Query;
    }
    
    public Task5Model fetchQuery(ResultSet resultSet) throws SQLException {
        String companyName = resultSet.getString("company_name");
        String productName = resultSet.getString("product_name");
        double productPrice = resultSet.getDouble("unit_price");
        return new Task5Model(companyName, productName, productPrice);
    }
}
