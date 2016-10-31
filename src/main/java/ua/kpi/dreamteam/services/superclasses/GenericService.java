package ua.kpi.dreamteam.services.superclasses;

import java.util.List;

public interface GenericService<T, ID> {
    T save(T entity);

    Iterable<T> save(Iterable<T> entities);

    T find(ID id);

    boolean exist(ID id);

    void delete(ID id);

    List<T> findAll();
}