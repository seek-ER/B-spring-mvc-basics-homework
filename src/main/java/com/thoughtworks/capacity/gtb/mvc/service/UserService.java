package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.bo.UserBO;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.error.UserExistException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<String, UserBO> userBOMap = new HashMap<>();

    public void registUser(User user) {
        if (userBOMap.containsKey(user.getUsername())) {
            throw new UserExistException("该用户已经存在");
        }
        UserBO registUserBO = UserBO.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .username(user.getUsername())
                .id(userBOMap.size() + 1).build();
        userBOMap.put(registUserBO.getUsername(), registUserBO);
    }


    public UserBO login(String username, String password) {
        UserBO userBO = userBOMap.get(username);
        if (userBO.getPassword().equals(password)) {
            return userBO;
        } else {
            return null;
        }
    }
}
