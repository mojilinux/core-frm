package com.lami.framework.repository;

import com.lami.framework.domain.BaseEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Repository
public abstract class GenericRepository<T extends BaseEntity, PK extends Serializable> implements IGenericRepository<T, PK> {
	protected Class<T> domainClass = getDomainClass();

	@PersistenceContext
	protected EntityManager em;

	protected abstract Class<T> getDomainClass();

	protected Session getSession() {
		return em.unwrap(Session.class);
	}

	/*@Override
	public T load(PK entityId) {
		Session session = getSession();
		return session.load(getDomainClass(), entityId);
	}

	@Override
	public List<T> getAll() {
		Session session = getSession();
		return session.createCriteria(this.domainClass).list();
	}

	@Transactional
	@Override
	public PK add(T entity) {
		Session session = getSession();
		return (PK) session.save(entity);
	}

	@Override
	public void update(T entity) {
		Session session = getSession();
		entity = (T) session.merge(entity);
		session.update(entity);
	}

	@Override
	public void deleteById(PK entityId) {
		Session session = getSession();
		session.delete(load(entityId));
	}*/

}
