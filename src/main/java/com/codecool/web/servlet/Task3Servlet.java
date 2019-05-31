package com.codecool.web.servlet;


import com.codecool.web.dao.Task3Dao;
import com.codecool.web.dao.database.DatabaseTask3Dao;
import com.codecool.web.model.Task3Model;
import com.codecool.web.service.simple.SimpleTask3Service;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet({"/task3"})
public class Task3Servlet extends AbstractServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection connection = getConnection(req.getServletContext())){
            Task3Dao task3Dao = new DatabaseTask3Dao(connection);
            SimpleTask3Service simpleTask3Service = new SimpleTask3Service(task3Dao);
            List<Task3Model> task3Results = simpleTask3Service.findAll();
            
            req.setAttribute("task3Results",task3Results);
            req.getRequestDispatcher("task3.jsp").forward(req,resp);
        } catch (SQLException ex){
            throw new ServletException(ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        String companyName = req.getParameter("companyName");
        
        try(Connection connection = getConnection(req.getServletContext())){
            Task3Dao task3Dao = new DatabaseTask3Dao(connection);
            SimpleTask3Service simpleTask3Service = new SimpleTask3Service(task3Dao);
            Task3Model task3FResults = simpleTask3Service.findByCompanyName(companyName);
            
            req.setAttribute("task3FResults",task3FResults);
            req.getRequestDispatcher("task3.jsp").forward(req,resp);
        }   catch (SQLException ex){
            throw new ServletException(ex);
        }
    }
}
