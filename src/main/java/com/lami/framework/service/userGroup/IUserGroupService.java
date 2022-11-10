package com.lami.framework.service.userGroup;

import com.lami.framework.domain.group.Group;
import com.lami.framework.domain.userGroup.UserGroup;
import com.lami.framework.service.IGenericService;

import java.util.List;

public interface IUserGroupService extends IGenericService<UserGroup, Long> {

	List<Group> loadByUser(Long userId);

}
