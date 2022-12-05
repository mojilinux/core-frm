package com.core.framework.service.userGroup;

import com.core.framework.domain.group.Group;
import com.core.framework.domain.userGroup.UserGroup;
import com.core.framework.repository.IGenericRepository;
import com.core.framework.repository.userGroup.IUserGroupRepository;
import com.core.framework.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupService extends GenericService<UserGroup, String> implements IUserGroupService {

    @Autowired
    private IUserGroupRepository iUserGroupRepository;


    @Override
    protected IGenericRepository<UserGroup, String> getGenericRepo() {
        return iUserGroupRepository;
    }

    @Override
    public List<Group> loadByUser(String userId) {
        return iUserGroupRepository.loadByUser(userId);
    }
}
