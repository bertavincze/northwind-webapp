package com.codecool.dao;

import com.codecool.model.Task5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class Task5Dao extends AbstractDao {

    public Task5Dao(Connection connection) {
        super(connection);
    }

    public List<Task5> loadQueryData() throws SQLException {
        List<Task5> taskList = new ArrayList<>();
        String sql = "SELECT s.company_name, p.product_name, p.unit_price\n" +
            "FROM products AS p\n" +
            "JOIN suppliers AS s ON p.supplier_id = s.supplier_id\n" +
            "LEFT JOIN products AS pp ON p.supplier_id = pp.supplier_id AND p.unit_price < pp.unit_price\n" +
            "WHERE pp.product_id IS NULL\n" +
            "ORDER BY p.unit_price DESC, product_name ASC, company_name ASC";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Task5 task = new Task5(
                    resultSet.getString("company_name"),
                    resultSet.getString("product_name"),
                    resultSet.getDouble("unit_price"));
                taskList.add(task);
            }
        }
        return taskList;
    }

    public List<Task5> loadFilteredData(String companyName) throws SQLException {
        List<Task5> taskList = new ArrayList<>();
        String sql = "SELECT s.company_name, p.product_name, p.unit_price\n" +
            "FROM products AS p\n" +
            "JOIN suppliers AS s ON p.supplier_id = s.supplier_id\n" +
            "LEFT JOIN products AS pp ON p.supplier_id = pp.supplier_id AND p.unit_price < pp.unit_price\n" +
            "WHERE pp.product_id IS NULL AND company_name LIKE ?\n" +
            "ORDER BY p.unit_price DESC, product_name ASC, company_name ASC";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + companyName + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Task5 task = new Task5(
                    resultSet.getString("company_name"),
                    resultSet.getString("product_name"),
                    resultSet.getDouble("unit_price"));
                taskList.add(task);
            }

        } return taskList;

    }

}

