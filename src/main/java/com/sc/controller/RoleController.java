package com.sc.controller;

import com.github.pagehelper.PageInfo;
import com.sc.bean.Admin;
import com.sc.bean.Role;
import com.sc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;

    //分页查找角色
    @RequestMapping("/getRoleList")
    public String getRoleList(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "3") Integer pageSize,
            String rolename,
            String status,
            Model model
    ){
        PageInfo<Role> pageInfo = roleService.getRoleList(pageNum, pageSize, rolename, status);

        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("rolename",rolename);
        model.addAttribute("status",status);


        return "/admin/role/list.jsp";
    }


    //新增角色
    @RequestMapping("/addRole")
    public String addRole(Role role, HttpSession session){
        role.setCreatetime(new Date());
        Admin user = (Admin) session.getAttribute("user");
        Long id = user.getId();
        role.setOperator(id);
        roleService.addRole(role);
        return "redirect:/getRoleList";
    }

    //删除角色
    @RequestMapping("/deleteRole")
    public String deleteRole(Long ids){
        int i = roleService.deleteRole(ids);
        return "redirect:/getRoleList";
    }

    //分配权限
    @RequestMapping("/allotMenu")
    @ResponseBody
    public String allotMenu(Integer roleid, Integer[] menuid){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("roleid",roleid);
        map.put("menuid",menuid);
        System.out.println(menuid.length);

        String s;
        try {
            roleService.insertRoleMenu(map);
            s="true";
        }catch (Exception e){
            s="false";
        }
        return s;
    }
}
