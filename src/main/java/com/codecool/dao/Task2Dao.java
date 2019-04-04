package com.codecool.dao;

import com.codecool.model.Task2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class Task2Dao extends AbstractDao {

    public Task2Dao(Connection connection) {
        super(connection);
    }

    public List<Task2> loadQueryData() throws SQLException {
        List<Task2> taskList = new ArrayList<>();
        String sql = "SELECT company_name AS company, COUNT(product_name) as products " +
            "from products JOIN suppliers on products.supplier_id = suppliers.supplier_id " +
            "GROUP BY suppliers.company_name ORDER BY Products DESC, Company ASC";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Task2 task = new Task2(
                    resultSet.getString("company"),
                    resultSet.getInt("products"));
                taskList.add(task);
            }
        }
        return taskList;
    }

    public List<Task2> loadFilteredData(String companyName) throws SQLException {
        List<Task2> taskList = new ArrayList<>();
        String sql = "SELECT company_name AS company, COUNT(product_name) as products " +
            "from products JOIN suppliers on products.supplier_id = suppliers.supplier_id " +
            "WHERE company_name LIKE ? GROUP BY suppliers.company_name ORDER BY Products DESC, Company ASC";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + companyName + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Task2 task = new Task2(
                    resultSet.getString("company"),
                    resultSet.getInt("products"));
                taskList.add(task);
            }

        } return taskList;

    }

}

