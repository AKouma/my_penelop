package Dao;

import java.util.List;

public interface Idao<T> {

    public T create(T t);

    public boolean delete(T t);

    public T update(T t);

    public List<T> findAll();

    public List<T> findByCriteria(String criteria, Object value);

    public T findById(Object id);
}
