package com.codecool.dao;

import com.codecool.model.Task1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class Task1Dao extends AbstractDao {

    public Task1Dao(Connection connection) {
        super(connection);
    }

    public List<Task1> loadQueryData() throws SQLException {
        List<Task1> task1List = new ArrayList<>();
        String sql = "SELECT product_name AS product, company_name AS company " +
            "FROM products JOIN suppliers ON products.supplier_id = suppliers.supplier_id ORDER BY product ASC";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Task1 task = new Task1(
                    resultSet.getString("product"),
                    resultSet.getString("company"));
                task1List.add(task);
            }
        }
        return task1List;
    }

}
