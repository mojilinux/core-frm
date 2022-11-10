package com.lami.framework.service;

import com.lami.framework.domain.BaseEntity;
import com.lami.framework.repository.IGenericRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@org.springframework.transaction.annotation.Transactional(readOnly = true)
public abstract class GenericService<T extends BaseEntity, PK extends Serializable> implements IGenericService<T, PK> {

	public GenericService() {

	}

	protected abstract IGenericRepository<T, PK> getGenericRepo();

	@Override
	public T load(PK entityId) {
		return (T) this.getGenericRepo().findById(entityId).get();
	}

	@Override
	public List<T> getAll() {
		return toList(this.getGenericRepo().findAll());
	}

	@Transactional
	@Override
	public PK save(T entity) {
		return (PK) this.getGenericRepo().save(entity);
	}

	@Transactional
	@Override
	public boolean deleteById(PK id) {
		this.getGenericRepo().deleteById(id);
		return true;
	}


	public static <T> List<T> toList(final Iterable<T> iterable) {
		return StreamSupport.stream(iterable.spliterator(), false)
				.collect(Collectors.toList());
	}
}
