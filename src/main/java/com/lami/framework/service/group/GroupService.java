package com.lami.framework.service.group;

import com.lami.framework.domain.group.Group;
import com.lami.framework.repository.IGenericRepository;
import com.lami.framework.repository.group.IGroupRepository;
import com.lami.framework.service.GenericService;
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
