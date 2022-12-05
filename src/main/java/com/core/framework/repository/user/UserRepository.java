package com.core.framework.repository.user;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

	/*@Override
	protected Class<User> getDomainClass() {
		return User.class;
	}

	@PersistenceContext
	private EntityManager em;

	@Override
	public User findByUserName(String username) {
		String hql = "select e from " + getDomainClass().getSimpleName() + " e where e.username = :username ";
		Query query = em.createQuery(hql).setParameter("username", username);
		return (User) query.getSingleResult();
	}*/

}
