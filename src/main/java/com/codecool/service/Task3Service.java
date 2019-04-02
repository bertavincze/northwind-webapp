package com.codecool.service;

import com.codecool.dao.Task3Dao;
import com.codecool.model.Task3;

import java.sql.SQLException;
import java.util.List;

public class Task3Service {

    private final Task3Dao task3Dao;

    public Task3Service(Task3Dao task3Dao) {
        this.task3Dao = task3Dao;
    }

    public List<Task3> loadTask3Data() throws SQLException {
        return task3Dao.loadQueryData();
    }

}
