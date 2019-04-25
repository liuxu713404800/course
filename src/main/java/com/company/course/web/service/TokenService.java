package com.company.course.web.service;

import com.company.course.web.entity.Token;
import com.company.course.web.mapper.TokenMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TokenService {
    @Resource
    private TokenMapper tokenMapper = null;

    public void updateUneffective(Integer uid) {
        tokenMapper.updateUneffective(uid);
    }

    public void create(Token token) {
        tokenMapper.create(token);
    }

    public Token getByToken(String token){
        return tokenMapper.getByToken(token);
    }
}
