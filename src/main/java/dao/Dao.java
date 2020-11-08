package dao;
import exception.DrugNotFoundException;
import java.util.List;

public interface Dao<T extends Cloneable> {
    T findById(int id);

    List <T> getAll();

    void update(T t) throws DrugNotFoundException;

    boolean delete(int id);

    T save (T t);
}
