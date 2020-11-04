package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.bo.UserBO;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registUser(@RequestBody @Valid User user) {
        userService.registUser(user);
    }

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public UserBO login(@PathParam("username") String username, @PathParam("password") String password) {
        return userService.login(username, password);
    }

}
