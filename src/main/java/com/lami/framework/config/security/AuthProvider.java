package com.lami.framework.config.security;

import com.lami.framework.common.exception.ApplicationException;
import com.lami.framework.domain.user.User;
import com.lami.framework.domain.user.UserPrincipal;
import com.lami.framework.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthProvider implements AuthenticationProvider {

	@Autowired
	private IUserService userDetailsService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String providedUsername = authentication.getPrincipal().toString();
		UserDetails user = userDetailsService.loadUserByUsername(providedUsername);

		String providedPassword = authentication.getCredentials().toString();
		String correctPassword = user.getPassword();

		if (!user.isEnabled()){
			throw new ApplicationException("User not Active.", 401);
		}

		if (!providedPassword.equals(correctPassword)) {
			throw new ApplicationException("Incorrect Credentials", 401);
		}
		Authentication authenticationResult = new UsernamePasswordAuthenticationToken(user, authentication.getCredentials(), user.getAuthorities());
		userDetailsService.loginInformationRegistration(user.getUsername());
		return authenticationResult;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		System.out.println("In MyAuthProvider.supports(): ");
		System.out.println("Checking whether MyAuthProvider supports Authentication type\n");
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}