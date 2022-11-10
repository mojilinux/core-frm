package com.lami.framework.repository.userGroup;

import com.lami.framework.domain.group.Group;
import com.lami.framework.domain.userGroup.UserGroup;
import com.lami.framework.repository.GenericRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserGroupRepository /*extends GenericRepository<UserGroup, Long> implements IUserGroupRepository*/ {

/*	@Override
	protected Class<UserGroup> getDomainClass() {
		return UserGroup.class;
	}

	@Override
	public List<Group> loadByUser(Long userId) {
		String hql = "select e.group from " + getDomainClass().getName() + " e  where e.user.id = :userId";
		Session session = getSession();
		Query query = session.createQuery(hql).setParameter("userId", userId);
		return query.list();
	}*/
}
