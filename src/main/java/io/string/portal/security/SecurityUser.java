package io.string.portal.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

public class SecurityUser extends User {
    private static final String ROLE_PREFIX = "ROLE_";

    public SecurityUser(String userId, List<String> roles) {
        super(userId, userId, makeGrantedAuthority(roles));
    }

    private static List<GrantedAuthority> makeGrantedAuthority(List<String> roles) {
        List<GrantedAuthority> list = new ArrayList<>();
        for (String role : roles) {
            list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role));
        }
        return list;
    }
}
