package com.codecool.web.servlet;

import com.codecool.web.dao.Task1Dao;
import com.codecool.web.dao.database.DatabaseTask1Dao;
import com.codecool.web.model.Task1Model;
import com.codecool.web.service.simple.SimpleTask1Service;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet({"/task1"})
public class Task1Servlet extends AbstractServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection connection = getConnection(req.getServletContext())){
            Task1Dao task1Dao = new DatabaseTask1Dao(connection);
            SimpleTask1Service simpleTask1Service = new SimpleTask1Service(task1Dao);
            List<Task1Model> task1Results = simpleTask1Service.findAll();
            
            req.setAttribute("task1Results",task1Results);
            req.getRequestDispatcher("task1.jsp").forward(req,resp);
        } catch (SQLException ex){
            throw new ServletException(ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        String companyName = req.getParameter("companyName");
        
        try(Connection connection = getConnection(req.getServletContext())){
            Task1Dao task1Dao = new DatabaseTask1Dao(connection);
            SimpleTask1Service simpleTask1Service = new SimpleTask1Service(task1Dao);
            List<Task1Model> task1FResults = simpleTask1Service.findByCompanyName(companyName);
            req.setAttribute("task1FResults",task1FResults);
            req.getRequestDispatcher("task1.jsp").forward(req,resp);
            
        }   catch (SQLException ex){
            throw new ServletException(ex);
        }
    }
}
