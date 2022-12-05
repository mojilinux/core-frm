package com.core.framework.service.actionGroup;

import com.core.framework.domain.action.Action;
import com.core.framework.domain.actionGroup.ActionGroup;
import com.core.framework.service.IGenericService;

import java.util.List;

public interface IActionGroupService extends IGenericService<ActionGroup, Long> {

	List<Action> loadActionsByGroup(Long groupId);

}
