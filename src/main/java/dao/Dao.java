package dao;

import java.util.List;


public interface Dao<Drug> {
    Drug get(double id);

    List <Drug> getAll();

    void update(double id);

    void delete(double id);

    void save (Drug drug);
}
