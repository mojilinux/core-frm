package com.core.framework.repository.actionGroup;

import org.springframework.stereotype.Repository;

@Repository
public class ActionGroupRepository /*extends GenericRepository<ActionGroup, Long> implements IActionGroupRepository*/ {
/*
	@Override
	protected Class<ActionGroup> getDomainClass() {
		return ActionGroup.class;
	}


	@Override
	public List<Action> loadActionsByGroup(Long groupId) {
		String hql = "select e.action from " + getDomainClass().getName() + " e  where e.group.id = :groupId";
		Session session = getSession();
		Query query = session.createQuery(hql).setParameter("groupId", groupId);
		return query.list();
	}*/
}
