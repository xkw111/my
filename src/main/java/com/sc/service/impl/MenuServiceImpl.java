package com.sc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.Menu;
import com.sc.bean.MenuExample;
import com.sc.bean.Role;
import com.sc.bean.RoleExample;
import com.sc.mapper.MenuMapper;
import com.sc.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    public PageInfo<Menu> getRoleList(Integer pageNum, Integer pageSize, String name, String status) {
        PageHelper.startPage(pageNum,pageSize);

        MenuExample menuExample =new MenuExample();
        menuExample.setOrderByClause("id asc");
        MenuExample.Criteria criteria = menuExample.createCriteria();
        if (name!=null&&!name.trim().equals("")){
            criteria.andNameLike("%" + name + "%");
        }
        if (status!=null&&!status.trim().equals("")){
            criteria.andStatusEqualTo(status);
        }
        List<Menu> menus = menuMapper.selectByExample(menuExample);

        return new PageInfo<Menu>(menus,5);
    }

    public int insertMenu(Menu menu) {
        return menuMapper.insert(menu);
    }

    public int deleteMenu(Long ids) {
        return menuMapper.deleteByPrimaryKey(ids);
    }

    public List<Menu> fatherMenuList() {
        List<Menu> menus = menuMapper.selectByExample(null);
        return menus;
    }

    @Override
    public List<Long> getMenuByRoleId(Long roleId) {
        List<Long> role = menuMapper.getMenuByRole(roleId);
        return role;
    }

    @Override
    public List<Menu> getMenuByRoleIds(Long roleId) {
        return menuMapper.getMenuByRoleIds(roleId);
    }
}
