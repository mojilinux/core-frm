package com.lami.framework.repository;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

public interface IGenericRepository<T, PK extends Serializable> extends CrudRepository<T, PK> {
   /* T load(PK entityId);

    List<T> getAll();

    PK add(T t);

    void update(T t);

    void deleteById(PK entityId);*/

}
