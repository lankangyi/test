package com.qf.boot.controller.pages.back.user;


import com.qf.boot.pojo.dto.PageDTO;
import com.qf.boot.pojo.dto.ResponseDTO;
import com.qf.boot.pojo.entity.User;
import com.qf.boot.pojo.query.UserQuery;
import com.qf.boot.pojo.vo.UserVo;
import com.qf.boot.service.UserService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/pages/back/user")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("ajaxUserList")
    @ResponseBody
    PageDTO ajaxUserList(UserQuery query) {
        return userService.ajaxUserList(query);
    }


    @RequestMapping("showUserInfo/{userId}")
    @ResponseBody
    UserVo showUserInfo(@PathVariable Long userId, UserQuery query) {
        return userService.showUserInfo(query);
    }

    @RequestMapping("editUser")
    @ResponseBody
    ResponseDTO editUser(User user) {
        return userService.editUser(user);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */

    @RequestMapping("addUser")
    @ResponseBody
    ResponseDTO addUser(User user) {
        return userService.addUser(user);
    }
    @RequestMapping("deleteByIds")
    @ResponseBody
    @RequiresRoles({"user","caiwu"})
    ResponseDTO deleteByIds(@RequestBody List<Long> ids) {

        return userService.deleteByIds(ids);
    }


}
