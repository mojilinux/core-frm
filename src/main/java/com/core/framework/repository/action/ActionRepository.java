package com.core.framework.repository.action;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ActionRepository  {

//	@Override
//	protected Class<Action> getDomainClass() {
//		return Action.class;
//	}

	@PersistenceContext
	private EntityManager em;


}
