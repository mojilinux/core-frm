package com.core.framework.service.user;

import com.core.framework.common.exception.ApplicationException;
import com.core.framework.domain.action.Action;
import com.core.framework.domain.group.Group;
import com.core.framework.domain.user.User;
import com.core.framework.domain.user.UserMapper;
import com.core.framework.repository.IGenericRepository;
import com.core.framework.repository.user.IUserRepository;
import com.core.framework.service.GenericService;
import com.core.framework.service.actionGroup.IActionGroupService;
import com.core.framework.service.userGroup.IUserGroupService;
import com.core.framework.utils.HashUtil;
import com.core.framework.utils.SecurityUtil;
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
public class UserService extends GenericService<User, String> implements IUserService, UserDetailsService {

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private IUserGroupService iUserGroupService;

    @Autowired
    private IActionGroupService iActionGroupService;

    @Override
    protected IGenericRepository<User, String> getGenericRepo() {
        return iUserRepository;
    }

    @Transactional
    @Override
    public String save(User entity) {
        entity.setPassword(HashUtil.hashPassword(entity.getPassword()));
        return super.save(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
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

    @Override
    public UserDetails loadUserByUsernameForAuthenticate(String username) throws UsernameNotFoundException {
        User user = iUserRepository.findByUserName(username);
        if (user == null) {
            throw new ApplicationException("Incorrect Credentials", 401);
        }
        if (!user.isActivated()) {
            throw new ApplicationException("User " + username + " was not activated", 401);
        }
        if (user.isLock()) {
            throw new ApplicationException("User " + username + " Locked.", 401);
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

    @Override
    public List<String> authenticatedUserAuthoritiesList() {
        List<String> authorities = new ArrayList<>();
        SecurityUtil.getAuthenticatedUserAuthorities().forEach(a -> {
            authorities.add(a.getAuthority());
        });
        return authorities;
    }

}
