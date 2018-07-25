package com.ywt.com.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.ywt.com.entity.User;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping(value = "/quary")
    @JsonView(User.UserSimpleView.class)
    public List<User> quary(){
        List<User> users = new ArrayList<>();
        users.add(new User("1","aa","1234"));
        users.add(new User("2","bb","1234"));
        users.add(new User("3","cc","1234"));
        return users;
    }

    @GetMapping(value = "get/{id}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable String id){
        User user = new User("1","aa","1234");
        return user;
    }
}
