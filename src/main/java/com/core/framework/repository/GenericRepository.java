package com.core.framework.repository;

import com.core.framework.domain.BaseEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@Repository
public abstract class GenericRepository<T extends BaseEntity, PK extends Serializable> implements IGenericRepository<T, PK> {
	protected Class<T> domainClass = getDomainClass();

	@PersistenceContext
	protected EntityManager em;

	protected abstract Class<T> getDomainClass();

	protected Session getSession() {
		return em.unwrap(Session.class);
	}

}
