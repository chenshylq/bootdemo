package com.example.bootdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bootdemo.bean.User;
import com.example.bootdemo.mapper.UserMapper;
import com.example.bootdemo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Chenchenx
 * @version v1.0
 * @date 2021/12/317:56
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
}
