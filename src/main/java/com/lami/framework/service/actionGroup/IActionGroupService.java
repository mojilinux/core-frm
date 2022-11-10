package com.lami.framework.service.actionGroup;

import com.lami.framework.domain.action.Action;
import com.lami.framework.domain.actionGroup.ActionGroup;
import com.lami.framework.domain.group.Group;
import com.lami.framework.domain.userGroup.UserGroup;
import com.lami.framework.service.IGenericService;

import java.util.List;

public interface IActionGroupService extends IGenericService<ActionGroup, Long> {

	List<Action> loadActionsByGroup(Long groupId);

}
