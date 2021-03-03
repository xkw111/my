package com.sc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.Admin;
import com.sc.bean.AdminExample;
import com.sc.bean.Pogo;
import com.sc.mapper.AdminMapper;
import com.sc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    //根据用户名和密码查找用户
    public Admin selectAdmin(String name, String password) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andPasswordEqualTo(password);
        System.out.println(name+"==>"+password);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if (admins==null || admins.size()==0){
            return null;
        }else {
            return admins.get(0);
        }
    }

    public int addAdmin(Admin admin) {
        int i = adminMapper.insert(admin);
        return i;
    }

    public PageInfo<Admin> selectAllAdmins(Integer pageNum,Integer pageSize,String name,String status) {
        PageHelper.startPage(pageNum,pageSize);

        AdminExample adminExample = new AdminExample();
        adminExample.setOrderByClause("id asc");
        AdminExample.Criteria criteria = adminExample.createCriteria();
        if (name!=null&&!name.trim().equals("")){
            criteria.andNameLike("%" + name + "%");
        }
        if (status!=null&&!status.trim().equals("")){
            criteria.andStatusEqualTo(status);
        }

        List<Admin> admins = adminMapper.selectByExample(adminExample);

        return new PageInfo<Admin>(admins,5);
    }

    public int deleteAdmin(Long[] id) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        List<Long> list = Arrays.asList(id);
        criteria.andIdIn(list);
        int i = adminMapper.deleteByExample(adminExample);
        return i;
    }

    public int updateAdmin(Admin admin) {
        int i = adminMapper.updateByPrimaryKey(admin);
        return i;
    }

    public int updateAdminInfo(Admin admin) {
        int i = adminMapper.updateByPrimaryKey(admin);
        return i;
    }


}
