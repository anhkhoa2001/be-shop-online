package com.spring.modules.authentication.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticationSystem {
	
	public static boolean isLogged() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return null != authentication && !authentication.getName().equals("anonymousUser");
    }

    public static String getUsernameCurrent() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        return username;
    }


}
