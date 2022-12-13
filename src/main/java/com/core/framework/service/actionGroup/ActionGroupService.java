package com.core.framework.service.actionGroup;

import com.core.framework.domain.action.Action;
import com.core.framework.domain.actionGroup.ActionGroup;
import com.core.framework.repository.IGenericRepository;
import com.core.framework.repository.actionGroup.IActionGroupRepository;
import com.core.framework.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionGroupService extends GenericService<ActionGroup, String> implements IActionGroupService {

	@Autowired
	private IActionGroupRepository iActionGroupRepository;

	@Override
	protected IGenericRepository<ActionGroup, String> getGenericRepo() {
		return iActionGroupRepository;
	}

	@Override
	public List<Action> loadActionsByGroup(String groupId) {
		return iActionGroupRepository.loadActionsByGroup(groupId);
	}
}
