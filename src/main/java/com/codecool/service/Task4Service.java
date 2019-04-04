package com.codecool.service;

import com.codecool.dao.Task4Dao;
import com.codecool.model.Task4;

import java.sql.SQLException;
import java.util.List;

public class Task4Service {

    private final Task4Dao task4Dao;

    public Task4Service(Task4Dao task4Dao) {
        this.task4Dao = task4Dao;
    }

    public List<Task4> loadTask4Data() throws SQLException {
        return task4Dao.loadQueryData();
    }

    public List<Task4> loadFilteredData(String companyName) throws SQLException {
        return task4Dao.loadFilteredData(companyName);
    }

}
