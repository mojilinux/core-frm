package com.core.framework.config.security;

import com.core.framework.common.exception.ApplicationException;
import com.core.framework.config.security.jwt.JWTProvider;
import com.core.framework.service.user.IUserService;
import com.core.framework.utils.HashUtil;
import com.core.framework.web.viewModel.user.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthProvider implements AuthenticationProvider {
    @Autowired
    private IUserService userDetailsService;

    @Autowired
    private JWTProvider tokenProvider;

    public String authenticateUser(LoginDto entity, HttpServletRequest request) {
        Authentication authentication = authenticate(new UsernamePasswordAuthenticationToken(entity.getUsername(), HashUtil.hashPassword(entity.getPassword())));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return tokenProvider.generateToken(authentication, request);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String providedUsername = authentication.getPrincipal().toString();
        UserDetails user = userDetailsService.loadUserByUsernameForAuthenticate(providedUsername);
        String providedPassword = authentication.getCredentials().toString();
        String correctPassword = user.getPassword();
        if (!providedPassword.equals(correctPassword)) {
            throw new ApplicationException("Incorrect Credentials", 401);
        }
        return new UsernamePasswordAuthenticationToken(user, authentication.getCredentials(), user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        System.out.println("In MyAuthProvider.supports(): ");
        System.out.println("Checking whether MyAuthProvider supports Authentication type\n");
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}