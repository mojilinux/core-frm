package com.core.framework.web.controller;

import com.core.framework.config.security.AuthProvider;
import com.core.framework.utils.HashUtil;
import com.core.framework.config.security.jwt.JWTProvider;
import com.core.framework.config.security.jwt.JwtResponse;
import com.core.framework.service.user.IUserService;
import com.core.framework.utils.SecurityUtil;
import com.core.framework.web.viewModel.user.LoginDto;
import com.core.framework.web.viewModel.user.UserViewModel;
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
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginDto entity, HttpServletRequest request) throws AuthenticationException {
        String jwt = authenticationManager.authenticateUser(entity, request);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

}
