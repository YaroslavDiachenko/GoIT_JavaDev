package dao;

import java.sql.SQLException;

public interface GenericDAO<T> {

    void create(T t) throws SQLException;

    T get(int id) throws SQLException;

    void update(T t);

    void delete(T t);
}
