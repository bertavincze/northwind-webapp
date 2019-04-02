package com.codecool.servlet;

import com.codecool.dao.Task2Dao;
import com.codecool.service.Task2Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/task2")
public final class Task2Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task2Dao task2Dao = new Task2Dao(connection);
            Task2Service task2Service = new Task2Service(task2Dao);
            req.setAttribute("data", task2Service.loadTask2Data());

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task_2.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task2Dao task2Dao = new Task2Dao(connection);
            Task2Service task2Service = new Task2Service(task2Dao);

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        doGet(req, resp);
    }
}
