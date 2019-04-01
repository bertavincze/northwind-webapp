package com.codecool.service;

import com.codecool.dao.Task1Dao;
import com.codecool.model.Task1;

import java.sql.SQLException;
import java.util.List;

public final class Task1Service {

    private final Task1Dao task1Dao;

    public Task1Service(Task1Dao task1Dao) {
        this.task1Dao = task1Dao;
    }

    public List<Task1> loadTask1Data() throws SQLException {
        return task1Dao.loadQueryData();
    }
}
