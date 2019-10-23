package com.qt.service.impl;

import com.qt.entity.TUser;
import com.qt.mapper.TUserMapper;
import com.qt.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private TUserMapper userMapper;
    @Override
    public TUser getUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
