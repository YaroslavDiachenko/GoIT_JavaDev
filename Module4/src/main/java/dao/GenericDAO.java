package dao;

import java.util.List;
import java.util.UUID;

public interface GenericDAO<T> {

    boolean add(T t);

    boolean edit(T t);

    boolean delete(UUID id);

    T getById(UUID id);

    List<T> getAll();

}
