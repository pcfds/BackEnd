package com.IntegradorRemasterizado.IntegradorRemasterizado.service;

import java.util.List;

public interface IDao<T> {
    T register(T t);

    T findById(Integer id);

    T finByEmail(String email);

    List<T> findAll();

    T update(T t, Integer id);

    void delete(Integer id);
}
