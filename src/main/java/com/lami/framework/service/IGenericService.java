package com.lami.framework.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface IGenericService<T, PK extends Serializable> {

	T load(PK id);

	List<T> getAll();

	PK save(T t);

	boolean deleteById(PK id);
}
