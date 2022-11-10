package com.lami.framework.service.user;

import com.lami.framework.common.exception.ApplicationException;
import com.lami.framework.config.security.HashUtil;
import com.lami.framework.domain.action.Action;
import com.lami.framework.domain.group.Group;
import com.lami.framework.domain.user.User;
import com.lami.framework.domain.user.UserMapper;
import com.lami.framework.repository.IGenericRepository;
import com.lami.framework.repository.user.IUserRepository;
import com.lami.framework.service.GenericService;
import com.lami.framework.service.actionGroup.IActionGroupService;
import com.lami.framework.service.userGroup.IUserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService extends GenericService<User, Long> implements IUserService, UserDetailsService {

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private IUserGroupService iUserGroupService;

    @Autowired
    private IActionGroupService iActionGroupService;

    @Override
    protected IGenericRepository<User, Long> getGenericRepo() {
        return iUserRepository;
    }

    @Transactional
    @Override
    public Long save(User entity) {
        entity.setPassword(HashUtil.hashPassword(entity.getPassword()));
        return super.save(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserRepository.findByUserName(username);
        if (user == null) {
            throw new ApplicationException("Incorrect Credentials", 401);
        }
        List<Group> groups = iUserGroupService.loadByUser(user.getId());
        List<Action> actionsList = new ArrayList<>();
        groups.forEach(g -> {
            List<Action> actions = iActionGroupService.loadActionsByGroup(g.getId());
            actionsList.addAll(actions);
        });
        Set<Action> set = new HashSet<>(actionsList);
        actionsList.clear();
        actionsList.addAll(set);
        user.setActions(actionsList);
        return UserMapper.userToPrincipal(user);
    }

}
