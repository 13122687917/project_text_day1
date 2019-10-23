package com.qt.controller;

import com.qt.entity.TUser;
import com.qt.service.IUserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@MapperScan("com.qt.mapper")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("{id}")
    public TUser getUserById(@PathVariable("id") Long id){
        return  userService.getUserById(id);
    }
}
