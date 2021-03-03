package com.sc.controller;

import com.github.pagehelper.PageInfo;
import com.sc.bean.*;
import com.sc.service.AdminService;
import com.sc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    //查询当前用户的好友列表
    @RequestMapping("/getUsers")
    public String getUsers(Model model, HttpSession session,String relation){
        Admin user = (Admin) session.getAttribute("user");
        Long id = user.getId();
        System.out.println(relation);
        if(relation==null){
            relation="1";
        }
        if(relation.equals("false")){
            relation="1";
        }else if(relation.equals("true")){
            relation="2";
        }

        List<Pogo> userslist = userService.getUsers(id,Long.valueOf(relation));
        model.addAttribute("userlist",userslist);

        return "/admin/friend_list.jsp";
    }
    //模糊查询
    @RequestMapping("/getUsersByNameOrRelation")
    public String getUsersByNameOrRelation(HttpSession session,Model model,String name,Integer relation){
        Admin user = (Admin) session.getAttribute("user");
        Long id = user.getId();
        System.out.println(name+"==>"+relation);
        List<Pogo> userlist = userService.getUsersByNameOrRelation(id,name, relation);
        System.out.println("AAAAAAAArelation:"+relation);
        session.setAttribute("name",name);
        session.setAttribute("relation",relation);
        session.setAttribute("userlist",userlist);
        return "redirect:/admin/friend_list.jsp";
    }
    //根据id删除好友
    @RequestMapping("/delectRelationById")
    public String delectRelationById(HttpSession session,Long id){
        Admin user = (Admin) session.getAttribute("user");
        Long userid = user.getId();
        userService.delectRelationById(userid,id);

        return "redirect:/getUsers";
    }

    @RequestMapping("/getUsersByPhone")
    public String getUsersByPhone(String phone,HttpSession session){
        Admin user = (Admin) session.getAttribute("user");
        System.out.println(user.getId()+"==>"+user.getName());
        Long userid = user.getId();//请求者id
        System.out.println("con"+userid+phone);
        List<Admin> usersByPhone = userService.getUsersByPhone(userid, phone);
        session.setAttribute("phone",phone);
        session.setAttribute("usersByPhone",usersByPhone);
        return "/admin/add_friend.jsp";
    }

    //发送好友请求
    @RequestMapping("addRequestCode")
    public String addRequestCode(HttpSession session,Long addid,@RequestBody Map<String,String> map){

        String rel = map.get("rel");
        Admin user = (Admin) session.getAttribute("user");
        Long userid = user.getId();//请求者id
        userService.addRequestCode(userid,addid,rel);
        return "redirect:/add_friend.jsp";
    }

    @RequestMapping("/getRelation")
    @ResponseBody
    public String getRelation(HttpSession session, String user2id){
        System.out.println("user2id:"+user2id);
        int a=0;//
        Admin user = (Admin) session.getAttribute("user");
        Long user1id = user.getId();
        Relational relation = userService.getRelation(user1id, Long.valueOf(user2id));
        System.out.println("relation:"+relation);
        if(relation==null){
            a=a;
            System.out.println("不是好友");
        }else{
            a=a+1;
            System.out.println("是好友："+relation);
        }
        System.out.println("a"+a);
        return a+"";
    }

    @RequestMapping("/deleteUserByArray")
    public String deleteUserByArray(HttpSession session, String[] id){
        List<String> user2id = new ArrayList<String>();
        for (String s : id) {
            user2id.add(s);
        }
        Admin user = (Admin) session.getAttribute("user");
        Long user1id = user.getId();

        userService.deleteUserByArray(user1id,id);
        return "redirect:/getUsers";
    }

    //得到的好友请求
    @RequestMapping("/getRequests")
    public String getRequests(HttpSession session){
        Admin user = (Admin) session.getAttribute("user");
        Long userid = user.getId();
        System.out.println("当前用户id"+userid);
        List<Pogo1> requests = userService.getRequests(userid);
        session.setAttribute("requests",requests);

        return "/admin/relation.jsp";
    }

    //同意请求，成为好友
    @RequestMapping("/agreeRelation")
    @ResponseBody
    public String agreeRelation(HttpSession session,String id,String read){

        System.out.println("id:"+id);
        System.out.println("read:"+read);
        Admin user = (Admin) session.getAttribute("user");
        Long userid = user.getId();
        System.out.println("当前用户id"+userid);
        int a = 0;
        userService.upadteRelation( Long.valueOf(id),userid, Long.valueOf(read));
        if(read.equals("1")){
            a = userService.agreeRelation(userid, Long.valueOf(id));
            a =a+ userService.agreeRelation(Long.valueOf(id), userid);

        }
        return a+"";
    }

    //查关系
    @RequestMapping("/getRelationById")
    public String getRelationById(HttpSession session,String user2id){
        Admin user = (Admin) session.getAttribute("user");
        Long id = user.getId();

        Relational relational = userService.getRelationById(id, Long.valueOf(user2id));

        Integer relation = relational.getRelation();

        session.setAttribute("Crelation",relation);

        return "/admin/updateRelation.jsp";
    }
    //修改关系
    @RequestMapping("/updateRelationById")
    public String updateRelationById(HttpSession session,String user2id, String relation){

        System.out.println("jjjj");
        Admin user = (Admin) session.getAttribute("user");
        Long id = user.getId();

        System.out.println("relationaaaaaaaaaaaaaaa:"+relation);

        if(relation.equals("false")){
            relation="2";
        }else if(relation.equals("true")){
            relation="1";
        }

        System.out.println("relationbbbbbbbbbb:"+relation);

        System.out.println("user2id:"+user2id);

        int i = userService.upadteRelationById(id, Long.valueOf(user2id), Long.valueOf(relation));
        System.out.println(i);
        return "/getUsers";
    }

    //判断是否为好友
    @RequestMapping("/checkRelation")
    @ResponseBody
    public String checkRelation(HttpSession session,String acceptname){
        Admin user = (Admin) session.getAttribute("user");
        Long id = user.getId();//发送者id
        int a = 0;//默认值 状态
        Admin admin = userService.getIdByName(acceptname);

        Long  acceptid = admin.getId();//接受者

        Relational relational = userService.getRelationById(id, acceptid);//查是否为好友

        Integer relation = relational.getRelation();

        if(relation==1){
            a=1;//是好友
        }
        return a+"";
    }
    //发送邮件
    @RequestMapping("/addEmail")
    public String addEmail(HttpSession session,Email email){

        System.out.println("前台传到后台的数据："+email.getAccept()+"==>"+email.getTitle()+"==>"+email.getMsgcontent()+"==>"+email.getSend());

        email.setMsgCreateData(new Date());
        Long state=Long.valueOf(0);
        email.setState(state);
        userService.addEmail(email);
        session.setAttribute("success","发送成功！");
        return "redirect:/admin/message.jsp";
    }
    //分页
    @RequestMapping("/emaillist")
    public String rolelist(@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "2") Integer pageSize,
                           Model model,HttpSession session){
        Admin user = (Admin) session.getAttribute("user");
        String accept = user.getName();//收件人

        PageInfo<Email> pageInfo = userService.emaillist(pageNum, pageSize,accept);


        model.addAttribute("pageInfo",pageInfo);

        System.out.println("AAAAAA"+pageInfo);


        return "/admin/email.jsp";
    }

    //删除一条邮件记录
    @RequestMapping("/deleteEmail")
    public String deleteEmail(HttpSession session,String send){

        Admin user = (Admin) session.getAttribute("user");
        String accept = user.getName();//收件人
        userService.deleteEmail(send,accept);

        return "/emaillist";
    }
    //修改阅读状态
    @RequestMapping("/updateReadStatus")
    public String updateReadStatus(HttpSession session,String state,String send){

        Admin user = (Admin) session.getAttribute("user");
        String accept = user.getName();//收件人
        System.out.println(state+"==>"+send+"==>"+accept);
        userService.updateReadStatus(state,send,accept);

        return "/emaillist";
    }
}
