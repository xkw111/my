package com.sc.service;

import com.github.pagehelper.PageInfo;
import com.sc.bean.Menu;

import java.util.List;


public interface MenuService {
    public PageInfo<Menu> getRoleList(Integer pageNum, Integer pageSize, String name, String status);
    //添加权限
    public int insertMenu(Menu menu);
    //删除权限
    public int deleteMenu(Long ids);
    //获取所有权限集合
    public List<Menu> fatherMenuList();
    //根据角色id获取查询到权限id集合
    public List<Long> getMenuByRoleId(Long roleId);
    //根据角色id查询到所有的权限信息集合
    public List<Menu> getMenuByRoleIds(Long roleId);
    //获取所有权限集合
    //public List<Menu> getAllMenus();
}
