package com.Integrative.IntegrativeWork.Repository;

import java.util.List;

public interface iDao<T> {

    public T register(T t);

    public T search(Integer id);

    public T searchEmail(String email);

    public T update(Integer id, T t);

    public void delete(Integer id);

    public List<T> searchAll();

}
