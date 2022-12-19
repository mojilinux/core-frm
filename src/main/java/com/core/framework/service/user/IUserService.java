package com.core.framework.service.user;

import com.core.framework.domain.user.User;
import com.core.framework.service.IGenericService;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface IUserService extends IGenericService<User, String> {
    //	Optional<User> findByUserName(String username);

    public UserDetails loadUserByUsername(String username);

	List<String> authenticatedUserAuthoritiesList();
}
