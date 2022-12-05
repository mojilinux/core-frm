package com.core.framework.service;

import java.io.Serializable;
import java.util.List;

public interface IGenericService<T, PK extends Serializable> {

	T load(PK id);

	List<T> getAll();

	PK save(T t);

	boolean deleteById(PK id);
}
