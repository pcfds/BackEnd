package com.Integrative.IntegrativeWork.Repository;

import java.util.List;

public interface iDao<T> {

    public T register(T t);

    public T search(int id);

    public T update(int id, T t);

    public void delete(int id);

    public List<T> searchAll();

}
