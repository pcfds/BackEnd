package DAO;

import java.util.List;

public interface iDao<T> {

    public T guardar(T t);
    public void eliminar(Long id);
    public T buscar(Long id);
    public T modificar(Long id)
    public List<T> buscarTodos();
}
