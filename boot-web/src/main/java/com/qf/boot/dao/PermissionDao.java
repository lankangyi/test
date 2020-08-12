package com.qf.boot.dao;

import com.qf.boot.pojo.entity.Permission;
import com.qf.boot.pojo.vo.PermissionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface PermissionDao {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<PermissionVO> selectByCollection(@Param("ids") Set<String> permissionsIdsSet);
}