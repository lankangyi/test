package com.qf.boot.dao;

import com.qf.boot.pojo.dto.PageDTO;
import com.qf.boot.pojo.entity.User;
import com.qf.boot.pojo.query.UserQuery;
import com.qf.boot.pojo.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserDao {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<UserVo> ajaxUserList(UserQuery query);

    Integer ajaxUserListCount(UserQuery query);

    UserVo selectByPK(UserQuery query);

    int deleteByIds(@Param("ids") List<Long> ids);

    UserVo selectUserByQuery(UserQuery query);
}
