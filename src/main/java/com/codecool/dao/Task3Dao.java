package com.codecool.dao;

import com.codecool.model.Task3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class Task3Dao extends AbstractDao {

    public Task3Dao(Connection connection) {
        super(connection);
    }

    public List<Task3> loadQueryData() throws SQLException {
        List<Task3> taskList = new ArrayList<>();
        String sql = "SELECT company_name AS company FROM products JOIN suppliers ON " +
            "products.supplier_id = suppliers.supplier_id GROUP BY company_name HAVING COUNT(product_name) >= 5 " +
            "ORDER BY company ASC";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Task3 task = new Task3(
                    resultSet.getString("company"));
                taskList.add(task);
            }
        }
        return taskList;
    }

}

