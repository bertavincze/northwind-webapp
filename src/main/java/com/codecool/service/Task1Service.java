package com.codecool.service;

import com.codecool.dao.Task1Dao;

public final class Task1Service {

    private final Task1Dao task1Dao;

    public Task1Service(Task1Dao task1Dao) {
        this.task1Dao = task1Dao;
    }
}
