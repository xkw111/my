package com.sc.service;

import com.github.pagehelper.PageInfo;
import com.sc.bean.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {
    public PageInfo<Role> getRoleList(Integer pageNum,Integer pageSize,String rolename,String status);

    public int addRole(Role role);

    public int deleteRole(Long id);

    public void insertRoleMenu(Map<String,Object> map);

    public List<Role> queryRole();
}
