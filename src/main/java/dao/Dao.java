package dao;
import java.util.List;


public interface Dao<T> {
    T get(int id) throws CloneNotSupportedException;

    List <T> getAll();

    void update(T t);

    void delete(int id);

    void save (T t);
}
