package ru.innowise.danko.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<E> {

    void save(E entity);

    void saveOrUpdate(E entity);

    void delete(E entity);

    void deleteAll();

    List<E> findAll();

    E findById(final Serializable id);
}
