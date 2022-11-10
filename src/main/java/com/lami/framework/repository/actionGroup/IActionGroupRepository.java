package com.lami.framework.repository.actionGroup;

import com.lami.framework.domain.action.Action;
import com.lami.framework.domain.actionGroup.ActionGroup;
import com.lami.framework.repository.IGenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IActionGroupRepository extends IGenericRepository<ActionGroup, Long> {

    @Query(value = "select e.action from ActionGroup e  where e.group.id = :groupId")
    List<Action> loadActionsByGroup(@Param("groupId") Long groupId);

}
