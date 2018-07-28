package com.ywt.com.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.ywt.com.entity.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping(value = "/quary")
    @JsonView(User.UserSimpleView.class)
    @ApiOperation(value = "用户查询")
    public List<User> quary(){
        List<User> users = new ArrayList<>();
        users.add(new User("1","aa","1234"));
        users.add(new User("2","bb","1234"));
        users.add(new User("3","cc","1234"));
        return users;
    }

    @PostMapping(value = "get/{id}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@ApiParam(value = "用户ID") @PathVariable String id){
        User user = new User("1","aa","1234");
        return user;
    }
}
