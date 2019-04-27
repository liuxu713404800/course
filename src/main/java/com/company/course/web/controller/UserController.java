package com.company.course.web.controller;

import com.company.course.web.common.*;
import com.company.course.web.entity.Token;
import com.company.course.web.entity.User;
import com.company.course.web.service.TokenService;
import com.company.course.web.service.UserService;
import com.company.course.web.utils.StringUtils;
import com.company.course.web.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController extends BaseController {
    @Resource
    private UserService userService = null;
    @Resource
    private TokenService tokenService = null;

    @Value("${base-file-folder}")
    public String baseFilePath;

    @RequestMapping("/user/{id}")
    ApiResult<User> findById(@PathVariable("id") Integer id){
        User user = userService.findById(id);
        return new ApiResult<User>(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), user);
    }

    @RequestMapping("/user/list")
    ApiResult<List<User>> findList() {
        List list = userService.findList();
        return new ApiResult<List<User>>(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), list);
    }

    @RequestMapping("/user/login")
    ApiResult<Map<String, String>> login(HttpServletRequest request) throws NoSuchAlgorithmException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 空值校验
        if (StringUtils.isEmpty(username)) {
            return new ApiError(StatusCode.NAME_EMPTY);
        }
        if (StringUtils.isEmpty(password)) {
            return new ApiError(StatusCode.PASSWORD_EMPTY);
        }

        // 校验用户存在
        User user = userService.findByName(username);
        if (user == null) {
            return new ApiError(StatusCode.USER_NOT_EXIST);
        }

        // 校验密码是否正确
        String encryptPassword = StringUtils.encryptPassword(password);
        if (!encryptPassword.equals(user.getPassword())) {
            System.out.println(encryptPassword);
            return new ApiError(StatusCode.PASSWORD_UNCORRECT);
        }

        // 将之前的token置为失效
        tokenService.updateUneffective(user.getId());

        // 产生新的token并插入数据库
        String tokenStr = StringUtils.generateToken(user.getId());
        int created = TimeUtils.getSecondTimestamp(new Date());
        int updated = created;
        Token token = new Token(created, updated, user.getId(), tokenStr, 1);
        tokenService.create(token);

        // 将对象转入数组返回
        Map<String, String> map = new HashMap<String, String>();
        map.put("token", token.getToken());

        return new ApiResult<Map<String, String>>(map);
    }

    @RequestMapping("/user/logout")
    ApiResult<String> logout(HttpServletRequest request){
        // 校验token合法
        String tokenParam = request.getParameter("token");
        Token token = tokenService.getByToken(tokenParam);
        if (token == null || token.getEffective() != 1) { return new ApiError(StatusCode.LOGIN_EXPIRED); }

        // 将本人的所有token置为失效
        tokenService.updateUneffective(token.getUid());
        return new ApiResult<String>("退出成功");
    }

}
