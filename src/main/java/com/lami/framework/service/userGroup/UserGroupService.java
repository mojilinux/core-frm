package com.lami.framework.service.userGroup;

import com.lami.framework.domain.group.Group;
import com.lami.framework.domain.userGroup.UserGroup;
import com.lami.framework.repository.IGenericRepository;
import com.lami.framework.repository.userGroup.IUserGroupRepository;
import com.lami.framework.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupService extends GenericService<UserGroup, Long> implements IUserGroupService {

    @Autowired
    private IUserGroupRepository iUserGroupRepository;


    @Override
    protected IGenericRepository<UserGroup, Long> getGenericRepo() {
        return iUserGroupRepository;
    }

    @Override
    public List<Group> loadByUser(Long userId) {
        return iUserGroupRepository.loadByUser(userId);
    }
}
