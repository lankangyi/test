package com.qf.boot.service.impl;

import com.qf.boot.dao.RoleDao;
import com.qf.boot.pojo.entity.Role;
import com.qf.boot.pojo.vo.RoleVO;
import com.qf.boot.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    RoleDao roleDao;

    @Override
    public List<RoleVO> selectByCollections(Set<String> stringSet) {
        return  roleDao.selectByCollections(stringSet);
    }
}
