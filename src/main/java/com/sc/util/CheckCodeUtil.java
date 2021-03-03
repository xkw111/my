package com.sc.util;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class CheckCodeUtil {

    public static  void checkCode(HttpServletRequest request, HttpServletResponse response) {
        // 1 创建对象        代表验证码图片
        //image 代表内存中的图片
        // 1 width  2 height  3 图片类型
        int width = 100;
        int height = 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 2 通过对象方法对验证图片美化  填充背景颜色 写四个字符 写干扰线

        //画笔工具
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.pink);
        // x y 填充背景色的初始下标  0,0 以矩形的左上角开始
        // width height
        graphics.fillRect(0, 0, width, height);

        // x y 填充背景色边框的初始下标  0,0 以矩形的左上角开始
        // width height
        graphics.setColor(Color.blue);
        graphics.drawRect(0, 0, width - 1, height - 1);

        //
        String value = "";
        graphics.setColor(Color.black);
        String info = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxxcvbnm0123456789";
        Random random = new Random();
        for (int i = 1; i < 5; i++) {
            int index = random.nextInt(info.length());//0-(指定值info.length())
            char c = info.charAt(index);
            graphics.drawString(c + "", width / 5 * i, height / 2);
            value = value + c;
        }

        //graphics.drawString("a",20,25);
        //graphics.drawString("b",40,25);
        //graphics.drawString("c",60,25);
        //graphics.drawString("d",80,25);

        for (int i = 0; i < 3; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);

            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1, y1, x2, y2);
        }

        //graphics.drawLine(20,0,50,18);

        // 3 通过字节输出流 响应浏览器
        try {
            ImageIO.write(image, "jpg", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //http://127.0.0.1:8090/jsp01/code/checkcode.jsp

        request.getSession().setAttribute("login_code", value);
    }
}
