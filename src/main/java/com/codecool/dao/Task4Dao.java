package com.codecool.dao;

import com.codecool.model.Task4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class Task4Dao extends AbstractDao {

    public Task4Dao(Connection connection) {
        super(connection);
    }

    public List<Task4> loadQueryData() throws SQLException {
        List<Task4> taskList = new ArrayList<>();
        String sql = "SELECT company_name AS company, ARRAY_AGG(order_id) AS order_id " +
            "FROM customers LEFT JOIN orders ON customers.customer_id = orders.customer_id " +
            "GROUP BY customers.company_name " +
            "ORDER BY company ASC";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Task4 task = new Task4(
                    resultSet.getString("company"),
                    (Short[]) resultSet.getArray("order_id").getArray());
                taskList.add(task);
            }
        }
        return taskList;
    }

    public List<Task4> loadFilteredData(String companyName) throws SQLException {
        List<Task4> taskList = new ArrayList<>();
        String sql = "SELECT company_name AS company, ARRAY_AGG(order_id) AS order_id " +
            "FROM customers LEFT JOIN orders ON customers.customer_id = orders.customer_id " +
            "WHERE company_name LIKE ? GROUP BY customers.company_name " +
            "ORDER BY company ASC";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + companyName + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Task4 task = new Task4(
                    resultSet.getString("company"),
                    (Short[]) resultSet.getArray("order_id").getArray());
                taskList.add(task);
            }

        } return taskList;

    }

}

