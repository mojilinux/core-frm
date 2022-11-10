package com.lami.framework.repository.group;

import com.lami.framework.domain.group.Group;
import com.lami.framework.repository.IGenericRepository;
import org.springframework.data.repository.CrudRepository;

public interface IGroupRepository extends IGenericRepository<Group, Long> {
}
