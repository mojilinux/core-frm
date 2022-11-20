package com.lami.framework.service.user;

import com.lami.framework.domain.user.User;
import com.lami.framework.service.IGenericService;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserService extends IGenericService<User, Long> {
	//	Optional<User> findByUserName(String username);

	public UserDetails loadUserByUsername(String username);

	void loginInformationRegistration(String user);
}
