package com.core.framework.repository.userGroup;

import com.core.framework.domain.group.Group;
import com.core.framework.domain.user.User;
import com.core.framework.domain.userGroup.UserGroup;
import com.core.framework.repository.IGenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserGroupRepository extends IGenericRepository<UserGroup, String> {
    @Query(value = "select e.group from UserGroup e  where e.user.id = :userId")
    List<Group> loadByUser(@Param("userId") String userId);

    @Query(value = "select e from UserGroup e  where e.group.id = :groupId")
    List<UserGroup> getAllByGroupId(@Param("groupId") String groupId);

    @Query(value = "select u from User u where u.id not in (select ug.user.id from  UserGroup ug where  ug.group.id = :groupId )")
    List<User> getAllOutsideUsers(@Param("groupId") String groupId);
}
