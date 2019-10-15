package pe.isil.dao;

import java.util.List;

public interface DAO <T, K> {

    public void create(T t);
    public void delete(T t);
    public void update(T t);

    public T findOne(K k);
    public List<T> findAll();

}
