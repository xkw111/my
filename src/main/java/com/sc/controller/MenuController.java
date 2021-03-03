package com.sc.controller;

import com.github.pagehelper.PageInfo;
import com.sc.bean.Admin;
import com.sc.bean.Menu;
import com.sc.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("getMenuList")
    public String getMenuList(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "3") Integer pageSize,
            String name,
            String status,
            Model model
            ){
        PageInfo<Menu> pageInfo = menuService.getRoleList(pageNum, pageSize, name, status);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("name",name);
        model.addAttribute("status",status);

        return "/admin/menu/list.jsp";
    }

    @RequestMapping("/addMenu")
    public String addMenu(Menu menu, HttpSession session, HttpServletRequest request){
        Admin name = (Admin) session.getAttribute("user");
        String father = request.getParameter("father");
        menu.setCreateTime(new Date());
        menu.setCreateBy(name.getId());
        if (father.equals("0")){
            menu.setParentid(-1l);
        }
        menuService.insertMenu(menu);
        return "redirect:/getMenuList";
    }

    @RequestMapping("deleteMenu")
    public String deleteMenu(Long ids){
        menuService.deleteMenu(ids);

        return "redirect:/getMenuList";
    }

    @RequestMapping("/fatherMenuList")
    @ResponseBody
    public List<Menu> fatherMenuList(){
        List<Menu> menus = menuService.fatherMenuList();
        return menus;
    }

    @RequestMapping("/menuList")
    @ResponseBody
    public List<Menu> menuList(Long roleid){
        //结果集合
        List<Menu> result = new ArrayList<Menu>();
        //获取到角色的id获取到该角色的权限id集合
        List<Long> menuIdList = menuService.getMenuByRoleId(roleid);
        //获取到菜单的具体信息集合
        List<Menu> menuList = menuService.fatherMenuList();
        //key为权限id  value为权限对象
        Map<Long,Menu> map = new HashMap<Long, Menu>();

        for (Menu menu : menuList) {
            //该角色拥有该权限  选中 反之不选中
            if (menuIdList.contains(menu.getId())){
                menu.setChecked(true);
            }
            map.put(menu.getId(),menu);
        }
        for (Menu menu : menuList) {
            Menu child = menu;
            //该菜单没有父级菜单
            if (child.getParentid()==-1){
                result.add(child);
            }else {
                Menu parent = map.get(child.getParentid());
                parent.getChildren().add(child);
            }
        }

        return result;
    }

}
