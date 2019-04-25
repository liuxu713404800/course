package com.company.course.web.service;

import com.company.course.web.entity.User;
import com.company.course.web.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper = null;

    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    public List<User> findList() {
        return userMapper.findList();
    }

}
