package com.codecool.service;

import com.codecool.dao.Task5Dao;
import com.codecool.model.Task5;

import java.sql.SQLException;
import java.util.List;

public class Task5Service {

    private final Task5Dao task5Dao;

    public Task5Service(Task5Dao task5Dao) {
        this.task5Dao = task5Dao;
    }

    public List<Task5> loadTask5Data() throws SQLException {
        return task5Dao.loadQueryData();
    }

}
