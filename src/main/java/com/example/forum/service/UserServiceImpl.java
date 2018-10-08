/*
 * Copyright (c) 2018. Lex
 */

package com.example.forum.service;


import com.example.forum.persistence.entity.Role;
import com.example.forum.persistence.entity.User;
import com.example.forum.persistence.repository.RoleRepository;
import com.example.forum.persistence.repository.UserRepository;
import com.example.forum.security.details.PermissionUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * {@link UserDetailsService} implementation which handles also roles permissions.
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(
            UserRepository userRepository,
            RoleRepository roleRepository,
            @Qualifier("passwordEncoder")
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(final String login) {
        log.info("Authenticating {}", login);
        String lcLogin = login.toLowerCase();
        Optional<User> dbUser = userRepository.findOneByName(lcLogin);
        return dbUser
            .map(u -> {
                List<GrantedAuthority> grantedRoles = u.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toList());
                return new PermissionUserDetails(lcLogin, u.getId(), u.getPasswordHash(),
                                                        grantedRoles, u.getRoles());
            })
            .orElseThrow(() -> new UsernameNotFoundException("No such user: " + lcLogin));
    }

    @Override
    public void create(String username, String lastName, String firstName, String password) {
        Role role = roleRepository.findByName("USER");
        User user = new User(username, lastName, firstName, passwordEncoder.encode(password), role);
        userRepository.save(user);
        log.info("User: {} create", username);
    }
}
