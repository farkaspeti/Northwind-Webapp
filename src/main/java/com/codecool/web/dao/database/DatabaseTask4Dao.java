package com.codecool.web.dao.database;

import com.codecool.web.dao.Task4Dao;
import com.codecool.web.model.Task4Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTask4Dao extends AbstractDao implements Task4Dao {
    
    public DatabaseTask4Dao(Connection connection) {
        super(connection);
    }
    
    @Override
    public List<Task4Model> getResult() throws SQLException {
        
        List<Task4Model> task4Query = new ArrayList<>();
        String sqlString = "SELECT company_name AS company,ARRAY_AGG(order_id) AS orderIds FROM customers " +
            "FULL JOIN orders " +
            "ON customers.customer_id = orders.customer_id " +
            "GROUP BY company " +
            "ORDER BY company ASC;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlString)) {
            while (resultSet.next()) {
                task4Query.add(fetchQuery(resultSet));
            }
        }
        return task4Query;
    }
    
    @Override
    public List<Task4Model> findByCompanyName(String companyName) throws SQLException {
        
        List<Task4Model> task4Query = new ArrayList<>();
        String sqlString = "SELECT company_name AS company,ARRAY_AGG(order_id) AS orderIds FROM customers " +
            "FULL JOIN orders " +
            "ON customers.customer_id = orders.customer_id " +
            "WHERE company_name = ? " +
            "GROUP BY company " +
            "ORDER BY company ASC;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
            preparedStatement.setString(1, companyName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    task4Query.add(fetchQuery(resultSet));
                }
            }
        }
        return task4Query;
    }
    
    public Task4Model fetchQuery(ResultSet resultSet) throws SQLException {
        String companyName = resultSet.getString("company");
        Array orderIDArray = resultSet.getArray("orderIds");
        return new Task4Model(companyName, orderIDArray);
    }
}
