package com.core.framework.service.userGroup;

import com.core.framework.domain.group.Group;
import com.core.framework.domain.user.User;
import com.core.framework.domain.userGroup.UserGroup;
import com.core.framework.service.IGenericService;

import java.util.List;

public interface IUserGroupService extends IGenericService<UserGroup, String> {

    List<Group> loadByUser(String userId);

    List<UserGroup> getAllByGroupId(String groupId);

    List<User> getAllOutsideUsers(String groupId);
}
