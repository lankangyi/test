package com.qf.boot.service.impl;

import com.qf.boot.dao.UserDao;
import com.qf.boot.pojo.dto.PageDTO;
import com.qf.boot.pojo.dto.ResponseDTO;
import com.qf.boot.pojo.entity.User;
import com.qf.boot.pojo.query.UserQuery;
import com.qf.boot.pojo.vo.UserVo;
import com.qf.boot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;

    @Override
    public Object getUserById(long l) {
        log.debug("我要执行用户查询了哦");

        return userDao.selectByPrimaryKey(l);
    }

    @Override
    public PageDTO ajaxUserList(UserQuery query) {
        List<UserVo> list = userDao.ajaxUserList(query);
        Integer count = userDao.ajaxUserListCount(query);
        return PageDTO.setPageData(count, list);
    }

    @Override
    public UserVo showUserInfo(UserQuery query) {

        return userDao.selectByPK(query);
    }

    @Override
    public ResponseDTO editUser(User user) {
        return ResponseDTO.get(userDao.updateByPrimaryKeySelective(user) == 1);
    }

    @Override
    public ResponseDTO addUser(User user) {
        return ResponseDTO.get(userDao.insertSelective(user) == 1);

    }

    @Override
    public ResponseDTO deleteByIds(List<Long> ids) {
        return ResponseDTO.get(userDao.deleteByIds(ids) == ids.size());
    }

    @Override
    public UserVo selectUserByQuery(UserQuery query) {
        return userDao.selectUserByQuery( query);
    }
}
