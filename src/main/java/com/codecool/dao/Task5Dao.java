package com.codecool.dao;

import com.codecool.model.Task5;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class Task5Dao extends AbstractDao {

    public Task5Dao(Connection connection) {
        super(connection);
    }

    public List<Task5> loadQueryData() throws SQLException {
        List<Task5> taskList = new ArrayList<>();
        String sql = "SELECT suppliers.company_name, products.product_name, products.unit_price FROM products " +
            "INNER JOIN suppliers ON suppliers.supplier_id = products.supplier_id " +
            "JOIN (SELECT products.supplier_id, MAX(products.unit_price) as max_unit_price FROM products " +
            "GROUP BY products.supplier_id) AS temp ON products.supplier_id = temp.supplier_id AND products.unit_price = temp.max_unit_price " +
            "ORDER BY unit_price DESC";
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

}

