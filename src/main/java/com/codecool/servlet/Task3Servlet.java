package com.codecool.servlet;

import com.codecool.dao.Task3Dao;
import com.codecool.service.Task3Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/task3")
public final class Task3Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task3Dao task3Dao = new Task3Dao(connection);
            Task3Service task3Service = new Task3Service(task3Dao);
            req.setAttribute("data", task3Service.loadTask3Data());

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task_3.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task3Dao task3Dao = new Task3Dao(connection);
            Task3Service task3Service = new Task3Service(task3Dao);

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        doGet(req, resp);
    }
}
