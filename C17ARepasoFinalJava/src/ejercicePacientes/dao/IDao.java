package ejercicePacientes.dao;

import java.util.List;

public interface IDao<T>{

    public T save(T t);
    public T findById(Long id);
    public void deleteById(Long id);
    public List<T> findAll();


}

