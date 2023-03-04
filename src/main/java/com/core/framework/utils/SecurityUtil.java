package com.core.framework.utils;

import com.core.framework.domain.user.Role;
import com.core.framework.domain.user.User;
import com.core.framework.domain.user.UserPrincipal;
import com.core.framework.service.user.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
import java.util.List;

public class SecurityUtil {

	public static User getAuthenticatedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return (User) authentication.getPrincipal();
	}

	public static String getAuthenticatedUserId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User principal = (User) authentication.getPrincipal();
		return principal.getId();
	}

	public static Collection<? extends GrantedAuthority> getAuthenticatedUserAuthorities() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
		return principal.getAuthorities();
	}

	public static boolean hasCurrentUserThisAuthority(String authority) {
		authority = "ROLE_" + authority;
		return getAuthenticatedUserAuthorities().stream().map(GrantedAuthority::getAuthority).anyMatch(authority::equals);
	}

	public static List<Role> getAuthenticatedUserRoles() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
		return principal.getRoles();
	}
}
