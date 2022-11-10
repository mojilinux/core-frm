package com.lami.framework.service.user;

import com.lami.framework.domain.user.User;
import com.lami.framework.service.IGenericService;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface IUserService extends IGenericService<User, Long> {
	//	Optional<User> findByUserName(String username);

	public UserDetails loadUserByUsername(String username);
}
