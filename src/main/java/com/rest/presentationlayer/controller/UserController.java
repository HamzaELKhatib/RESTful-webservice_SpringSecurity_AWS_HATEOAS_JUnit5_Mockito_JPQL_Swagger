package com.rest.presentationlayer.controller;

import com.rest.presentationlayer.model.request.UserDetailsRequestModel;
import com.rest.presentationlayer.model.response.UserRest;
import com.rest.service.UserService;
import com.rest.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/{name}") //Front requesting from backend
    public String getUser(@PathVariable String name){
        return "Hello " + name;
    }

    // @RequestBody allows createUser to read the body from the http request and convert that body to a java object
    // UserDetailsRequestModel is the class we're using to create a java object out of this body
    // UserDetailsRequestModel will have fields that match the request body
    // UserRest will be used a response model class
    @PostMapping //sending to the backend
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails){

        // The information to be returned
        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();

        // Populating the dto with information received from the request body
        BeanUtils.copyProperties(userDetails, userDto);

        // Creating a new dto (createdUser) for the response and applying createUser method from userService to it
        // createUser is a method for creating elements that will be used to fill up the fields in the response(UserRest)
        UserDto createdUser = userService.createUser(userDto);

        // Populating returnValue with information from the createdUser Dto
        BeanUtils.copyProperties(createdUser, returnValue);


        return returnValue;
    }

    @PutMapping //sending/updating
    public void updateUser(){
        return;
    }

    @DeleteMapping //delete
    public void deleteUser(){
        return;
    }
}
