package com.lami.framework.domain.user;

import com.lami.framework.service.actionGroup.IActionGroupService;
import com.lami.framework.service.userGroup.IUserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

	public static UserPrincipal userToPrincipal(User user) {

		UserPrincipal userPrincipal = new UserPrincipal();
		List<SimpleGrantedAuthority> authorities = user.getActions().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getCode())).collect(Collectors.toList());
		userPrincipal.setUsername(user.getUsername());
		userPrincipal.setPassword(user.getPassword());
		userPrincipal.setAuthorities(authorities);
		userPrincipal.setId(user.getId());
		return userPrincipal;
	}
}
