package com.core.framework.repository;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface IGenericRepository<T, PK extends Serializable> extends CrudRepository<T, PK> {
}
