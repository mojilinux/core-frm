package com.core.framework.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

public interface IGenericRepository<T, PK extends Serializable> extends PagingAndSortingRepository<T, PK> {
}
