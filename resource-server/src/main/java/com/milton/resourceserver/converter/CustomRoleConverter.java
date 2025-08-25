package com.milton.resourceserver.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        // Roles are stored in a claim called "roles"
        Collection<String> roles = jwt.getClaimAsStringList("roles");

        if (roles == null) {
            return java.util.Collections.emptyList();
        }

        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role)) // Prefix with "ROLE_" if needed
                .collect(Collectors.toList());
    }
}
