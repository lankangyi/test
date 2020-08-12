package com.qf.boot.service;

import com.qf.boot.pojo.dto.PageDTO;
import com.qf.boot.pojo.dto.ResponseDTO;
import com.qf.boot.pojo.entity.User;
import com.qf.boot.pojo.query.UserQuery;
import com.qf.boot.pojo.vo.UserVo;

import java.util.List;


public interface UserService {
    Object getUserById(long l);

    PageDTO ajaxUserList(UserQuery query);

    UserVo showUserInfo(UserQuery query);

    ResponseDTO editUser(User user);

    ResponseDTO addUser(User user);

    ResponseDTO deleteByIds(List<Long> ids);

    UserVo selectUserByQuery(UserQuery query);
}
