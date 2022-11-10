package com.lami.framework.service.action;

import com.lami.framework.domain.action.Action;
import com.lami.framework.domain.user.User;
import com.lami.framework.domain.user.UserMapper;
import com.lami.framework.repository.IGenericRepository;
import com.lami.framework.repository.action.IActionRepository;
import com.lami.framework.repository.user.IUserRepository;
import com.lami.framework.service.GenericService;
import com.lami.framework.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ActionService extends GenericService<Action, Long> implements IActionService {

    @Autowired
    private IActionRepository iActionRepository;

    @Override
    protected IGenericRepository<Action, Long> getGenericRepo() {
        return iActionRepository;
    }
}
