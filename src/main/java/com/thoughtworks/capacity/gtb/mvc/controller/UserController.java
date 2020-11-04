package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.bo.UserBO;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RestController
@Validated
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
    public UserBO login(@Pattern(regexp = "\\w{3,10}", message = "用户名不合法") @RequestParam(name = "username") String username,
                        @Size(min = 5, max = 12, message = "密码不合法") @RequestParam(name = "password") String password) {
        return userService.login(username, password);
    }

}
