package com.codecool.web.servlet;

import com.codecool.web.dao.Task2Dao;
import com.codecool.web.dao.database.DatabaseTask2Dao;
import com.codecool.web.model.Task2Model;
import com.codecool.web.service.simple.SimpleTask2Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet({"/task2"})
public class Task2Servlet extends AbstractServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection connection = getConnection(req.getServletContext())){
            Task2Dao task2Dao = new DatabaseTask2Dao(connection);
            SimpleTask2Service simpleTask2Service = new SimpleTask2Service(task2Dao);
            List<Task2Model> task2Results = simpleTask2Service.findAll();
            
            req.setAttribute("task2Results",task2Results);
            req.getRequestDispatcher("task2.jsp").forward(req,resp);
        }catch (SQLException ex){
            throw new ServletException(ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        String numberOfProducts = req.getParameter("numberOfProducts");
        
        try(Connection connection = getConnection(req.getServletContext())){
            Task2Dao task2Dao = new DatabaseTask2Dao(connection);
            SimpleTask2Service simpleTask2Service = new SimpleTask2Service(task2Dao);
            Task2Model task2FResults = simpleTask2Service.findByNumberOfProducts(numberOfProducts);
            
            req.setAttribute("task2FResults",task2FResults);
            req.getRequestDispatcher("task2.jsp").forward(req,resp);
        }catch (SQLException ex){
            throw new ServletException(ex);
        }
    }
}
