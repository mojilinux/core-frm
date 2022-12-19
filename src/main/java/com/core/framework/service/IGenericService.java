package com.core.framework.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface IGenericService<T, PK extends Serializable> {

	T load(PK id);

	List<T> getAll();

	Page<T> getAllGrid(Pageable pageable);

	PK save(T t);

	boolean deleteById(PK id);
}
