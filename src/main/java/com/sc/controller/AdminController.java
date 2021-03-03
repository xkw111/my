package com.sc.controller;

import com.github.pagehelper.PageInfo;
import com.sc.bean.*;
import com.sc.bean.Menu;
import com.sc.service.AdminService;
import com.sc.service.MenuService;
import com.sc.service.RoleService;
import com.sc.util.CheckCodeUtil;
import com.sc.util.MD5;
import com.sc.util.UpLoadUtil;
import org.omg.PortableServer.POA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.List;

@Controller
public class AdminController {
   @Autowired
    AdminService adminService;
   @Autowired
    MenuService menuService;
   @Autowired
    RoleService roleService;

    //获取验证码
    @RequestMapping("/captcha")
    public void getVerificationCode(HttpServletResponse response, HttpSession session)
    {
        //1.创建对象 代表验证码图片
        //image代表内存中的图片
        //1.宽 2.高 3.图片类型
        int width=90;
        int height=30;
        //该图片默认样式一片漆黑
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //2.通过对象的方法对验证码图片美化。填充背景色，写4个字符，写干扰线
        Graphics graphics = image.getGraphics();    //画笔工具
        graphics.setColor(Color.LIGHT_GRAY);
        // x  y   填充背景色的初始下标
        // width  height
        graphics.fillRect(0,0,width,height);
        graphics.setColor(Color.MAGENTA);
        graphics.drawRect(0,0,width-1,height-1);
        //写文本
        graphics.setColor(Color.black);
        graphics.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        //48-57   0-9
        //65-90 A-Z
        //97-122 a-z
        Random r=new Random();
        Character a=null;
        String s="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuffer sb=new StringBuffer();
        int lf=10;  // 30  50  70
        int he=20;  //高度
        for(int i=0;i<4;i++)
        {
            a=s.charAt(r.nextInt(s.length()));
            sb.append(a);
            int left=lf;
            lf+=20;
            int right=he;
            graphics.drawString(a.toString(),left,right);
        }
        //最终的验证码内容
        String captchaCode=sb.toString().toLowerCase();
        //循环生成干扰线，两点一线
        graphics.drawLine(10,10,90,40);
        graphics.drawLine(15,25,80,10);
        graphics.drawLine(80,25,4,10);
        graphics.drawLine(15,23,60,25);
        //将验证码存入session域

        session.setAttribute("captchaCode",captchaCode);
        //3.通过字节输出流响应浏览器
        try{
            ImageIO.write(image,"jpg",response.getOutputStream());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //登录
    @RequestMapping("/login")
    @ResponseBody        //用于处理ajax请求
    public String login(String username,String password,String yzm,HttpSession session)
    {
        //将username转小写
        String name=username.toLowerCase();
        //先检查验证码
        String captchaCode = (String)session.getAttribute("captchaCode");
        if(yzm.toLowerCase().equals(captchaCode))
        {
            //再判断用户名和密码,将加密后的密码传入
            Admin user = adminService.selectAdmin(username, MD5.MD5Code(password));
            System.out.println("查询得到的用户对象是:"+user);
            if(user!=null)
            {
                //将User对象存入Session域
                session.setAttribute("user",user);


                List<Menu> menuList = menuService.getMenuByRoleIds(user.getRoleid());
                //获取User对象能访问的url集合
                Set<String> adminUrl = new HashSet<String>();
                for (Menu menu : menuList) {
                    if (menu.getUrl()!=null&&!menu.getUrl().equals("")){
                        adminUrl.add(menu.getUrl());
                    }
                }
                session.setAttribute("adminUrl",adminUrl);

                List<Menu> result = new ArrayList<Menu>();
                Map<Long,Menu> map = new HashMap<Long, Menu>();

                for (Menu menu : menuList) {
                    map.put(menu.getId(),menu);
                }
                for (Menu menu : menuList) {
                    Menu child = menu;
                    if (menu.getParentid()==-1){
                        result.add(child);
                    }else {
                        Menu parent = map.get(child.getParentid());
                        parent.getChildren().add(child);
                    }
                }
                session.setAttribute("adminMenus",result);
                return "1";
            }else{
                return "0";
            }
        }
        else
        {
            return "0";
        }


    }

    //查询角色
    @RequestMapping("/queryRole")
    @ResponseBody
    public List<Role> queryRole(){
        return roleService.queryRole();
    }

    //新增用户
   @RequestMapping("/addAdmin")
    public String addAdmin(Admin admin, MultipartFile picture, HttpServletRequest request){
       //保存照片的路径
       String filename = UpLoadUtil.upLoad(picture, request);
       admin.setCreatetime(new Date());
       admin.setHeadPic(filename);

       String s = MD5.MD5Code(admin.getPassword());//加密
       admin.setPassword(s);

       int i = adminService.addAdmin(admin);

       return "redirect:/selectAllAdmins";
   }


   //所有用户分页查询
    @RequestMapping("/selectAllAdmins")
    public String selectAllAdmins(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "3") Integer pageSize,
            String name,
            String status,
            Model model
    ){
        PageInfo<Admin> pageInfo = adminService.selectAllAdmins(pageNum, pageSize, name, status);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("name",name);
        model.addAttribute("status",status);


        return "/admin/admin/list.jsp";
    }

    //删除
    @RequestMapping("/deleteAdmin")
    public String deleteAdmin(Long[] ids){
        int i = adminService.deleteAdmin(ids);

        return "redirect:/selectAllAdmins";
    }

    //修改密码
    @RequestMapping("/updateAdmin")
    public String updateAdmin(String newpwd,HttpSession session){
        System.out.println(newpwd);
        Admin admin = (Admin) session.getAttribute("user");
        admin.setPassword( MD5.MD5Code(newpwd));
        adminService.updateAdmin(admin);

        return "redirect:/admin/login-2.jsp";
    }

    //验证密码是否正确
    @RequestMapping("/validation")
    public void validation(String old ,HttpSession session, HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            Admin user = (Admin) session.getAttribute("user");
            String info = null;
            if (old==null){
                info="密码不能为空!";
            }else if (!user.getPassword().equals(MD5.MD5Code(old))){
                info="密码不正确，请重新输入！";
            }
            PrintWriter writer = response.getWriter();
            writer.write(info);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //验证俩次密码是否一致
    @RequestMapping("/passwordAgain")
    public String passwordAgain(String newpwd ,String confirmpwd,HttpSession session){
        if (newpwd!=null&&!newpwd.trim().equals("")&&newpwd.equals(confirmpwd)){
            return null;
        }else {
            return "俩次密码不一致!";
        }
    }



    //修改个人信息
    @RequestMapping("/updateAdminInfo")
    public String updateAdminInfo(HttpSession session,HttpServletRequest request ,MultipartFile picture){
        Admin user = (Admin) session.getAttribute("user");

        String filename = UpLoadUtil.upLoad(picture, request);

        if (filename!=null&&!filename.trim().equals("")){
            user.setHeadPic(filename);
        }

        String name = request.getParameter("name");
        if (name!=null&&!name.trim().equals("")){
            user.setName(name);
        }
        String phone = request.getParameter("phone");
        if (phone!=null&&!phone.trim().equals("")){
            user.setPhone(phone);
        }
        String email = request.getParameter("email");
        if (email!=null&&!email.trim().equals("")){
            user.setEmail(email);
        }
        int i = adminService.updateAdminInfo(user);
        System.out.println(user.getPhone());
        System.out.println(user.getEmail());

        return "redirect:/admin/welcome-1.jsp";
    }


    //退出登录
    @RequestMapping("/exitAdmin")
    public String exitAdmin(HttpSession session){
        session.invalidate();
        return "redirect:/admin/login-2.jsp";
    }
}
