package com.rest.service;

import com.rest.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto user);

    UserDto updateUser(String id, UserDto user);

    UserDto getUser(String email);

    UserDto getUserByUserId(String userId);

    void deleteUser(String id);
}
