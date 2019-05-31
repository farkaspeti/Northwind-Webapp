package com.codecool.web.servlet;


import com.codecool.web.dao.Task5Dao;
import com.codecool.web.dao.database.DatabaseTask5Dao;
import com.codecool.web.model.Task5Model;
import com.codecool.web.service.simple.SimpleTask5Service;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet({"/task5"})
public class Task5Servlet extends AbstractServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection connection = getConnection(req.getServletContext())){
            Task5Dao task5Dao = new DatabaseTask5Dao(connection);
            SimpleTask5Service simpleTask5Service = new SimpleTask5Service(task5Dao);
            List<Task5Model> task5Results = simpleTask5Service.findAll();
            
            req.setAttribute("task5Results",task5Results);
            req.getRequestDispatcher("task5.jsp").forward(req,resp);
        } catch (SQLException ex){
            throw new ServletException(ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        String productName = req.getParameter("productName");
        
        try(Connection connection = getConnection(req.getServletContext())){
            Task5Dao task5Dao = new DatabaseTask5Dao(connection);
            SimpleTask5Service simpleTask5Service = new SimpleTask5Service(task5Dao);
            Task5Model task5FResults = simpleTask5Service.findByProductName(productName);
            
            req.setAttribute("task5FResults",task5FResults);
            req.getRequestDispatcher("task5.jsp").forward(req,resp);
        }   catch (SQLException ex){
            throw new ServletException(ex);
        }
    }
}
