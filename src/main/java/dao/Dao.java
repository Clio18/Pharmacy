package dao;
import exception.DrugNotFoundException;

import java.util.List;


public interface Dao<T> {
    T findById(int id) throws CloneNotSupportedException;

    List <T> getAll();

    void update(T t) throws DrugNotFoundException;

    boolean delete(int id);

    boolean save (T t);
}
