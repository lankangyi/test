package com.qf.boot.service.impl;

import com.qf.boot.dao.PermissionDao;
import com.qf.boot.pojo.entity.Permission;
import com.qf.boot.pojo.vo.PermissionVO;
import com.qf.boot.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
@Service
public class PermissionServiceImpl implements PermissionService {
    @Resource
    PermissionDao permissionDao;
    @Override
    public List<PermissionVO> selectByCollection(Set<String> permissionsIdsSet) {
        return permissionDao.selectByCollection( permissionsIdsSet);
    }
}
