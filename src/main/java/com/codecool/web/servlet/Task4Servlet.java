package com.codecool.web.servlet;


import com.codecool.web.dao.Task4Dao;
import com.codecool.web.dao.database.DatabaseTask4Dao;
import com.codecool.web.model.Task4Model;
import com.codecool.web.service.simple.SimpleTask4Service;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@WebServlet({"/task4"})
public class Task4Servlet extends AbstractServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection connection = getConnection(req.getServletContext())){
            Task4Dao task4Dao = new DatabaseTask4Dao(connection);
            SimpleTask4Service simpleTask4Service = new SimpleTask4Service(task4Dao);
            List<Task4Model> task4Results = simpleTask4Service.findAll();
            
            req.setAttribute("task4Results",task4Results);
            req.getRequestDispatcher("task4.jsp").forward(req,resp);
        } catch (SQLException ex){
            throw new ServletException(ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        String companyName = req.getParameter("companyName");
        
        try(Connection connection = getConnection(req.getServletContext())){
            Task4Dao task4Dao = new DatabaseTask4Dao(connection);
            SimpleTask4Service simpleTask4Service = new SimpleTask4Service(task4Dao);
            Task4Model task4FResults = simpleTask4Service.findByCompanyName(companyName);
            
            req.setAttribute("task4FResults",task4FResults);
            req.getRequestDispatcher("task4.jsp").forward(req,resp);
        }   catch (SQLException ex){
            throw new ServletException(ex);
        }
    }
}
