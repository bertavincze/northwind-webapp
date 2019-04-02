package com.codecool.service;

import com.codecool.dao.Task2Dao;
import com.codecool.model.Task2;

import java.sql.SQLException;
import java.util.List;

public class Task2Service {

    private final Task2Dao task2Dao;

    public Task2Service(Task2Dao task2Dao) {
        this.task2Dao = task2Dao;
    }

    public List<Task2> loadTask2Data() throws SQLException {
        return task2Dao.loadQueryData();
    }

}
