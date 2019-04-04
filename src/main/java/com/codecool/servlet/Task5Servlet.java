package com.codecool.servlet;

import com.codecool.dao.Task5Dao;
import com.codecool.service.Task5Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/task5")
public final class Task5Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task5Dao task5Dao = new Task5Dao(connection);
            Task5Service task5Service = new Task5Service(task5Dao);
            req.setAttribute("data", task5Service.loadTask5Data());

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task_5.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task5Dao task5Dao = new Task5Dao(connection);
            Task5Service task5Service = new Task5Service(task5Dao);
            String companyName = req.getParameter("company");
            req.setAttribute("data", task5Service.loadFilteredData(companyName));

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task_5.jsp").forward(req, resp);
    }
}
