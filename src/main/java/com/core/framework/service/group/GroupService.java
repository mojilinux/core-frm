package com.core.framework.service.group;

import com.core.framework.domain.group.Group;
import com.core.framework.repository.IGenericRepository;
import com.core.framework.repository.group.IGroupRepository;
import com.core.framework.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService extends GenericService<Group, Long> implements IGroupService {

	@Autowired
	private IGroupRepository iGroupRepository;

	@Override
	protected IGenericRepository<Group, Long> getGenericRepo() {
		return iGroupRepository;
	}
}
