package com.sc.service;

import com.github.pagehelper.PageInfo;
import com.sc.bean.Admin;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface AdminService {

    public Admin selectAdmin(String name, String password);

    public int addAdmin(Admin admin);

    public PageInfo<Admin> selectAllAdmins(Integer pageNum,Integer pageSize,String name,String status);

    public int deleteAdmin(Long[] id);

    public int updateAdmin(Admin admin);

    public int updateAdminInfo(Admin admin);
}
