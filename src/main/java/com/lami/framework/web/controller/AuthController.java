package com.lami.framework.web.controller;

import com.lami.framework.config.security.AuthProvider;
import com.lami.framework.config.security.HashUtil;
import com.lami.framework.config.security.jwt.JWTProvider;
import com.lami.framework.config.security.jwt.JwtResponse;
import com.lami.framework.service.user.IUserService;
import com.lami.framework.web.viewModel.user.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("auth")
public class AuthController {

	@Autowired
	private IUserService iUserService;

	@Autowired
	private AuthProvider authenticationManager;

	@Autowired
	private JWTProvider tokenProvider;

	@PostMapping("/sign-in")
	public ResponseEntity<JwtResponse> authenticateUser(@RequestBody UserViewModel entity, HttpServletRequest request) throws AuthenticationException {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(entity.getUsername(), HashUtil.hashPassword(entity.getPassword())));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = tokenProvider.generateToken(authentication);
		return ResponseEntity.ok(new JwtResponse(jwt));
	}

}
