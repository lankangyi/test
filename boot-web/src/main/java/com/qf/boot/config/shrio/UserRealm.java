package com.qf.boot.config.shrio;

import com.qf.boot.pojo.entity.Permission;
import com.qf.boot.pojo.entity.Role;
import com.qf.boot.pojo.query.UserQuery;
import com.qf.boot.pojo.vo.PermissionVO;
import com.qf.boot.pojo.vo.RoleVO;
import com.qf.boot.pojo.vo.UserVo;
import com.qf.boot.service.PermissionService;
import com.qf.boot.service.RoleService;
import com.qf.boot.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserRealm extends AuthorizingRealm {

    @Resource
    UserService userService;

    @Resource
    RoleService roleService;
    @Resource
    PermissionService permissionService;

    @Override//授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();

        UserQuery userQuery = new UserQuery();
        userQuery.setPrincipal(primaryPrincipal.toString());
        //查询出所有的角色id
        UserVo userVo = userService.selectUserByQuery(userQuery);
        String roles = userVo.getRoles();
        Set<String> roleSet = StringUtils.commaDelimitedListToSet(roles);
        //更加角色id 查询出所有的角色
        if (!CollectionUtils.isEmpty(roleSet)){
            List<RoleVO> roleVOS = roleService.selectByCollections(roleSet);
            //获取所有角色flag
            Set<String> collect = roleVOS.stream().map(Role::getFlag).collect(Collectors.toSet());
            simpleAuthorizationInfo.setRoles(collect);
            //获取所有的权限flag
            StringBuffer stringBuffer = new StringBuffer();
            for (RoleVO r : roleVOS) {
                stringBuffer.append(r.getPermissions()).append(",");
            }
            Set<String> permissionIds = StringUtils.commaDelimitedListToSet(stringBuffer.toString());
            if (!CollectionUtils.isEmpty(permissionIds)){
                List<PermissionVO> permissionVOS = permissionService.selectByCollection(permissionIds);
                Set<String> permissionSet = permissionVOS.stream().map(PermissionVO::getFlag).collect(Collectors.toSet());
                simpleAuthorizationInfo.setStringPermissions(permissionSet);
            }
        }


            return simpleAuthorizationInfo;
    }

    @Override//认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = authenticationToken.getPrincipal().toString();
        Object credentials = authenticationToken.getCredentials();
        String password = new String((char[]) credentials);
        UserQuery userQuery = new UserQuery();
        userQuery.setPrincipal(principal);
        UserVo dbUser = userService.selectUserByQuery(userQuery);
        if (dbUser == null) {
            throw new UnknownAccountException("账户不存在");
        }
        if (!password.equals(dbUser.getPassword())) {
            throw new CredentialsException("密码错误");
        }
        return new SimpleAuthenticationInfo(authenticationToken.getPrincipal(), authenticationToken.getCredentials(), "userRealm");
    }
}
