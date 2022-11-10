package com.lami.framework.service.actionGroup;

import com.lami.framework.domain.action.Action;
import com.lami.framework.domain.actionGroup.ActionGroup;
import com.lami.framework.domain.group.Group;
import com.lami.framework.domain.userGroup.UserGroup;
import com.lami.framework.repository.IGenericRepository;
import com.lami.framework.repository.actionGroup.IActionGroupRepository;
import com.lami.framework.repository.userGroup.IUserGroupRepository;
import com.lami.framework.service.GenericService;
import com.lami.framework.service.userGroup.IUserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionGroupService extends GenericService<ActionGroup, Long> implements IActionGroupService {

	@Autowired
	private IActionGroupRepository iActionGroupRepository;

	@Override
	protected IGenericRepository<ActionGroup, Long> getGenericRepo() {
		return iActionGroupRepository;
	}

	@Override
	public List<Action> loadActionsByGroup(Long groupId) {
		return iActionGroupRepository.loadActionsByGroup(groupId);
	}
}
