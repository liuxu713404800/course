package com.company.course.web.mapper;

import com.company.course.web.entity.User;

import java.util.List;

public interface UserMapper {
    public User findById(Integer id);

    public User findByName(String name);

    public List findList();
}
