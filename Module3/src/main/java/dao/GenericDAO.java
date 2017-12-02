package dao;

import java.util.List;
import java.util.Set;

public interface GenericDAO<T> {

    int create(T t);

    void update(T t);

    boolean delete(int id);

    T getById(int id);

    T getByName(String name);

    Set<T> getSetByIds(int[] ids_list);

    List<T> listAll();
}
