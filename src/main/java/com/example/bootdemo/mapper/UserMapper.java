package com.example.bootdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bootdemo.bean.User;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Resource;

/**
 * @author Chenchenx
 * @version v1.0
 * @date 2021/12/317:29
 */

public interface UserMapper extends BaseMapper<User> {
}
