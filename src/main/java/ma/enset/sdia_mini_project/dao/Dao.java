package ma.enset.sdia_mini_project.dao;

import java.util.List;

public interface Dao<T>{
    List<T> findAll();
    T findByID(long id);
    T save(T o);
    boolean delete(T o);
    T update(T o);
}
