package com.codecool.servlet;

import com.codecool.dao.Task1Dao;
import com.codecool.service.Task1Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/task1")
public final class Task1Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task1Dao task1Dao = new Task1Dao(connection);
            Task1Service task1Service = new Task1Service(task1Dao);
            req.setAttribute("data", task1Service.loadTask1Data());

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task_1.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task1Dao task1Dao = new Task1Dao(connection);
            Task1Service task1Service = new Task1Service(task1Dao);

        } catch (SQLException ex) {

            throw new ServletException(ex);
        }
        doGet(req, resp);
    }
}

