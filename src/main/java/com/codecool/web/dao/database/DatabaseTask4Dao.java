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
        String sqlString = "SELECT company_name AS companyname,ARRAY_AGG(order_id) AS orderidarray FROM customers " +
            "FULL JOIN orders " +
            "ON customers.customer_id = orders.customer_id " +
            "GROUP BY companyname " +
            "ORDER BY companyname ASC;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlString)) {
            while (resultSet.next()) {
                task4Query.add(fetchQuery(resultSet));
            }
        }
        return task4Query;
    }
    
    @Override
    public Task4Model findByCompanyName(String companyName) throws SQLException {
        
        String sqlString = "SELECT company_name AS companyname,ARRAY_AGG(order_id) AS orderarray FROM customers " +
            "FULL JOIN orders " +
            "ON customers.customer_id = orders.customer_id " +
            "WHERE company_name = ? " +
            "GROUP BY companyname " +
            "ORDER BY companyname ASC;";
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
    
    public Task4Model fetchQuery(ResultSet resultSet) throws SQLException {
        String companyName = resultSet.getString("companyName");
        Array orderIDArray = resultSet.getArray("orderIDArray");
        return new Task4Model(companyName, orderIDArray);
    }
}
