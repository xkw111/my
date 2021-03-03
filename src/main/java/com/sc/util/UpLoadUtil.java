package com.sc.util;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UpLoadUtil {

    public static  String upLoad(MultipartFile pic, HttpServletRequest request){
        String filename = pic.getOriginalFilename();//上传文件的文件名  如果没有上传文件  返回空字符串
        if (filename.equals("")){
            return null;
        }

        //1 准备新的文件名 UUID 32位 实际36位
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //2 准备文件后缀
        String extension = FilenameUtils.getExtension(filename);
        //3 准备文件上传路径
        ServletContext servletContext = request.getServletContext();
        String realPath = servletContext.getRealPath("/upLoad");

        File file = new File(realPath);
        if (!file.exists()){
            file.mkdirs();
        }
        try {
            pic.transferTo(new File(realPath,uuid+"."+extension));
            return uuid+"."+extension;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
