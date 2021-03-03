package com.sc.controller;



import com.sc.bean.Admin;
import com.sc.service.UserService;

import com.sc.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.sun.mail.util.MailSSLSocketFactory;

import java.io.ObjectInputStream.GetField;
import java.util.Date;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.text.html.MinimalHTMLWriter;



import java.util.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginPageController {
    //登录界面的请求这个类的方法处理
    @Autowired
    private UserService userService;



//    @RequestMapping("/captcha")      //获取验证码
//    public void getVerificationCode(HttpServletResponse response, HttpSession session)
//    {
//        //1.创建对象 代表验证码图片
//        //image代表内存中的图片
//        //1.宽 2.高 3.图片类型
//        int width=90;
//        int height=30;
//        //该图片默认样式一片漆黑
//        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
//        //2.通过对象的方法对验证码图片美化。填充背景色，写4个字符，写干扰线
//        Graphics graphics = image.getGraphics();    //画笔工具
//        graphics.setColor(Color.LIGHT_GRAY);
//        // x  y   填充背景色的初始下标
//        // width  height
//        graphics.fillRect(0,0,width,height);
//        graphics.setColor(Color.MAGENTA);
//        graphics.drawRect(0,0,width-1,height-1);
//        //写文本
//        graphics.setColor(Color.black);
//        graphics.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//        //48-57   0-9
//        //65-90 A-Z
//        //97-122 a-z
//        Random r=new Random();
//        Character a=null;
//        String s="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//        StringBuffer sb=new StringBuffer();
//        int lf=10;  // 30  50  70
//        int he=20;  //高度
//        for(int i=0;i<4;i++)
//        {
//            a=s.charAt(r.nextInt(s.length()));
//            sb.append(a);
//            int left=lf;
//            lf+=20;
//            int right=he;
//            graphics.drawString(a.toString(),left,right);
//        }
//        //最终的验证码内容
//        String captchaCode=sb.toString().toLowerCase();
//        //循环生成干扰线，两点一线
//        graphics.drawLine(10,10,90,40);
//        graphics.drawLine(15,25,80,10);
//        graphics.drawLine(80,25,4,10);
//        graphics.drawLine(15,23,60,25);
//        //将验证码存入session域
//
//        session.setAttribute("captchaCode",captchaCode);
//        //3.通过字节输出流响应浏览器
//        try{
//            ImageIO.write(image,"jpg",response.getOutputStream());
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
//    @RequestMapping("/login")
//    @ResponseBody        //用于处理ajax请求
//    public String login(String username,String password,String yzm,HttpSession session)
//    {
//        System.out.println("session域已存的验证码是验证码:"+session.getAttribute("captchaCode"));
//        System.out.println(username);
//        System.out.println(password);
//        System.out.println("前台传来的验证码是:"+yzm);
//
//        //将username转小写
//        String name=username.toLowerCase();
//        //先检查验证码
//        String captchaCode = (String)session.getAttribute("captchaCode");
//        if(yzm.toLowerCase().equals(captchaCode))
//        {
//            //再判断用户名和密码,将加密后的密码传入
//            User user = userService.selectUser(username, MD5.MD5Code(password));
//            System.out.println("查询得到的用户对象是:"+user);
//            if(user!=null)
//            {
//                //将User对象存入Session域
//                session.setAttribute("user",user);
//                return "1";
//            }else{
//                return "0";
//            }
//        }
//        else
//        {
//            return "0";
//        }
//
//
//    }

    @RequestMapping("/jianyan")
    @ResponseBody
    public String jianyan(String name)
    {
        int i=0;
        System.out.println("后端获取到的检验数据是:"+name);
        //发往后端检查是否有次用户
        if(name!="")
        {
            i = userService.selectUser(name);
            System.out.println(i+"i是");
        }
        return ""+i;
    }

    @ResponseBody
    @RequestMapping("/sendEmail")
    public String sendEmail(String email, HttpSession session1)    //获取到需要给哪个邮箱发验证码
    {

        try{
            System.out.println("收件人email:"+email);
            //随机生成6位验证码
            String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
            System.out.println("随机生成的六位验证码是:"+verifyCode);
            //将六位验证码存入session
            session1.setAttribute("verifyCode",verifyCode);
            //实现发邮件

            // 收件人电子邮箱
            String to = email;
            // 发件人电子邮箱
            String from = "1056336765@qq.com";
            // 指定发送邮件的主机为 smtp.qq.com
            String host = "smtp.qq.com";  //QQ 邮件服务器
            // 获取系统属性
            Properties properties = System.getProperties();
            // 设置邮件服务器
            properties.setProperty("mail.smtp.host", host);
            properties.put("mail.smtp.auth", "true");

            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);
            // 获取默认session对象
            Session session = Session.getDefaultInstance(properties,new Authenticator(){
                public PasswordAuthentication getPasswordAuthentication()
                {
                    return new PasswordAuthentication("1056336765@qq.com", "rmymdsouopbmbcgg"); //发件人邮件用户名、密码
                }
            });
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));
            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: 头部头字段
            message.setSubject("思成注册邮件");
            // 设置消息体
            message.setText("您的注册码是:"+verifyCode);
            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully....from runoob.com");
        }catch (Exception mex) {
            mex.printStackTrace();
        }
        finally {
            return "1";
        }

//        try {
//           Properties pro=new Properties();
//            //这里我们设置的是要访问的邮箱主机，下面示例是QQ邮箱，如果是163邮箱你就要把这个qq.com替换为163.com了。
//            pro.setProperty("mail.host", "smtp.qq.com");//服务器地址
//            pro.setProperty("mail.smtp.auth", "true");//是否认证
//            Authenticator authenticator=new Authenticator() {
//                @Override
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication("1056336765",    "rmymdsouopbmbcgg");
//                }
//            };
//            Session session = Session.getInstance(pro, authenticator);
//            MimeMessage mimeMessage = new MimeMessage(session);
//            mimeMessage.setFrom(new InternetAddress("1056336765@qq.com"));//发件人
//            mimeMessage.addRecipients(Message.RecipientType.TO,email);//收件人
//            mimeMessage.setSubject("注册邮件");//标题
//            mimeMessage.setContent("您的6位注册验证码是:"+verifyCode,"text/plain;charset=utf-8");//正文
//            Transport.send(mimeMessage);
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }finally {
//            return ""+1;
//        }
    }

    @RequestMapping("/zhuce")
    @ResponseBody
    public String zhuce(@RequestBody Map<String,String> map,HttpSession session)
    {
        System.out.println(map);
        //接收前端传来的数据
        String name=map.get("cellphone");   //账号
        String pass=map.get("password");    //密码
        String ema=map.get("nickname");     //邮箱
        String code=map.get("vercode");     //验证码
        //先判断验证码是否正确
        String verifyCode = (String) session.getAttribute("verifyCode");
        if(verifyCode.equals(code))
        {
            //验证码相同,判断该账号是否已被注册
            int i = userService.selectUser(name);
            if(i==1)
            {
                //该用户名已被注册
                return "0";
            }else{
                //该用户名没有注册,执行注册操作
                Admin admin=new Admin();
                admin.setName(name);
                admin.setPassword(MD5.MD5Code(pass));
                admin.setEmail(ema);
                //将该对象插入数据表
                int i1 = userService.insertIntoAdmin(admin);
                if(i1==1)
                {
                    System.out.println("注册成功");
                    return "1";
                }else{
                    System.out.println("注册失败");
                    return "0";
                }
            }
        }else{
            //验证码不对
            return "0";
        }
    }



}
