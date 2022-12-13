package com.core.framework.config.security;

import com.core.framework.domain.user.User;

public class SecurityUtil {

    public static User getAuthenticatedUser() {
        User user = new User();
        user.setId("1");
        return user;
    }
}
