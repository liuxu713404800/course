package com.company.course.web.mapper;

import com.company.course.web.entity.Token;


public interface TokenMapper {
//    public Token findByUid(Integer uid);
//
//    public Token findEffectiveByUid(Integer uid);

    public void create(Token token);

    public void updateUneffective(Integer uid);

    public Token getByToken(String token);
}

