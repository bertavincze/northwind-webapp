package com.codecool.servlet;

import com.codecool.dao.Task4Dao;
import com.codecool.service.Task4Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/task4")
public final class Task4Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task4Dao task4Dao = new Task4Dao(connection);
            Task4Service task4Service = new Task4Service(task4Dao);
            req.setAttribute("data", task4Service.loadTask4Data());

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task_4.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task4Dao task4Dao = new Task4Dao(connection);
            Task4Service task4Service = new Task4Service(task4Dao);

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        doGet(req, resp);
    }
}
