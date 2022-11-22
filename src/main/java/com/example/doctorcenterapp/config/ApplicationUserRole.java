package com.example.doctorcenterapp.config;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.doctorcenterapp.config.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    USER(Sets.newHashSet(USER_READ, USER_WRITE)),
    DOCTOR(Sets.newHashSet(DOCTOR_READ, DOCTOR_WRITE)),
    ADMIN(Sets.newHashSet(USER_READ, USER_WRITE, DOCTOR_READ, DOCTOR_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissionSet = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissionSet.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissionSet;
    }
}
