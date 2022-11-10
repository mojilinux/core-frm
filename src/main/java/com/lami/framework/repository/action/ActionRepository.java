package com.lami.framework.repository.action;

import com.lami.framework.domain.action.Action;
import com.lami.framework.repository.GenericRepository;
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
