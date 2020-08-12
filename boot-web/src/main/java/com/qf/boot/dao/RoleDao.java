package com.qf.boot.dao;

import com.qf.boot.pojo.entity.Role;
import com.qf.boot.pojo.vo.RoleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface RoleDao {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<RoleVO> selectByCollections(@Param("ids") Set<String> stringSet);
}