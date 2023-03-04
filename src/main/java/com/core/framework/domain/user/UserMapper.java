package com.core.framework.domain.user;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

	public static UserPrincipal userToPrincipal(User user) {

		UserPrincipal userPrincipal = new UserPrincipal();
		List<SimpleGrantedAuthority> authorities = user.getActions().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getCode())).collect(Collectors.toList());
		List<Role> roles = user.getRoles();
		authorities.addAll(user.getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role)).collect(Collectors.toList()));
		userPrincipal.setUsername(user.getUsername());
		userPrincipal.setPassword(user.getPassword());
		userPrincipal.setPerson(user.getPerson());
		userPrincipal.setAuthorities(authorities);
		userPrincipal.setRoles(roles);
		userPrincipal.setId(user.getId());
		return userPrincipal;
	}
}
