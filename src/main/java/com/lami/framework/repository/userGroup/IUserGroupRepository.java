package com.lami.framework.repository.userGroup;

import com.lami.framework.domain.group.Group;
import com.lami.framework.domain.userGroup.UserGroup;
import com.lami.framework.repository.IGenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserGroupRepository extends IGenericRepository<UserGroup, Long> {
    @Query(value = "select e.group from UserGroup e  where e.user.id = :userId")
    List<Group> loadByUser(@Param("userId") Long userId);
}
