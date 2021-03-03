package com.sc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.Role;
import com.sc.bean.RoleExample;
import com.sc.mapper.RoleMapper;
import com.sc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public PageInfo<Role> getRoleList(Integer pageNum,Integer pageSize,String rolename,String status) {
        PageHelper.startPage(pageNum,pageSize);

        RoleExample roleExample = new RoleExample();
        roleExample.setOrderByClause("id asc");
        RoleExample.Criteria criteria = roleExample.createCriteria();
        if (rolename!=null&&!rolename.trim().equals("")){
            criteria.andRolenameLike("%" + rolename + "%");
        }
        if (status!=null&&!status.trim().equals("")){
            criteria.andStatusEqualTo(status);
        }
        List<Role> roles = roleMapper.selectByExample(roleExample);

        return new PageInfo<Role>(roles,5);
    }

    public int addRole(Role role) {
        return roleMapper.insert(role);
    }

    public int deleteRole(Long id) {

        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insertRoleMenu(Map<String, Object> map) {
        roleMapper.deleteRoleMenu(map);
        roleMapper.insertRoleMenu(map);
    }

    @Override
    public List<Role> queryRole() {
        return roleMapper.selectByExample(null);
    }
}
