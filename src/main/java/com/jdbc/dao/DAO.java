package com.jdbc.dao;

import java.util.List;

public interface DAO<T> {
    T get(int id);

    void add(T t);

    void remove(int id);

    List<T> getAll();
}
