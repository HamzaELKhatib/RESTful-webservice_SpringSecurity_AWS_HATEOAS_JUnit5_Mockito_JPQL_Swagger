package com.rest.service.impl;

import com.rest.UserRepository;
import com.rest.io.entity.UserEntity;
import com.rest.service.UserService;
import com.rest.shared.Utils;
import com.rest.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Override
    public UserDto createUser(UserDto user) {

        UserEntity userInDb = userRepository.findByEmail(user.getEmail());

        if(userInDb != null) throw new RuntimeException("User already exists");

        UserEntity userEntity = new UserEntity();

        // Populating userEntity with info from dto
        BeanUtils.copyProperties(user, userEntity);

        // Populating the required fields that aren't put in by the user
        userEntity.setUserId(utils.generateUserId(10));

        userEntity.setEncryptedPassword("hardcodedPassword");

        // saving info from userEntity to the database using the repo
        UserEntity storedUserDetails = userRepository.save(userEntity);

        // return:
        // creating a dto to return
        UserDto returnValue = new UserDto();

        // Population the return dto from the entity
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        // Returning the dto
        return returnValue;

    }


}
