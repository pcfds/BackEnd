package Parcial.DAO;

import java.util.List;

public interface iDao<T> {

    public T guardar(T t);
    public T buscar(int id);
    public void eliminar(int id);
    public List<T> buscarTodos();
}