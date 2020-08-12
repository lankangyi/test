package com.qf.boot.service;

import com.qf.boot.pojo.vo.PermissionVO;

import java.util.List;
import java.util.Set;

public interface PermissionService {
    List<PermissionVO> selectByCollection(Set<String> permissionsIdsSet);
}
