package com.qf.boot.service;

import com.qf.boot.pojo.vo.RoleVO;

import java.util.List;
import java.util.Set;

public interface RoleService {
    List<RoleVO> selectByCollections(Set<String> stringSet);
}
