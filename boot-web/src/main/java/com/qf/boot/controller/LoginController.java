package com.qf.boot.controller;


import com.qf.boot.pojo.dto.PageDTO;
import com.qf.boot.pojo.dto.ResponseDTO;
import com.qf.boot.pojo.entity.User;
import com.qf.boot.pojo.query.UserQuery;
import com.qf.boot.pojo.vo.UserVo;
import com.qf.boot.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller

public class LoginController {
    @RequestMapping("loginPage")
    String loginPage() {
        return "login-Page";
    }

    @PostMapping("login")
    @ResponseBody
    ResponseDTO login(@RequestBody UserQuery user) {

        UsernamePasswordToken token = new UsernamePasswordToken(user.getPrincipal(),user.getPassword());

        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return ResponseDTO.fail();
        }

        return ResponseDTO.success();
    }
}
