package com.sc.controller;

import com.github.pagehelper.PageInfo;
import com.sc.bean.Admin;
import com.sc.bean.Files;
import com.sc.bean.User;
import com.sc.service.FileService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/files")
public class FilesController {
    @Autowired
    private FileService fileService;

    @RequestMapping("/uploadFile")
    public void uploadFile(Files files, MultipartFile f, HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception {

        String filename = f.getOriginalFilename();//上传文件的文件名 如果没有上传文件 返回“”空字符串
//        System.out.println(filename+"!!!");
        if (filename.equals("")) {

            response.sendRedirect("/files/filelist");
        }else{
            //1 准备新的文件名 UUID 32位
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //准备文件后缀
            String ext = FilenameUtils.getExtension(filename);
            //3 准备上传文件路径
            ServletContext servletContext = request.getServletContext();
            String path = servletContext.getRealPath("/upload");
            System.out.println(path);
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                f.transferTo(new File(path, uuid + "." + ext));
                files.setFname(uuid + "." + ext);
                files.setFtime(new Date());
                files.setFurl("/upload/" + uuid + "." + ext);
                Admin user = (Admin) session.getAttribute("user");
                files.setAdminid(user.getId());
                fileService.addFile(files);

            } catch (IOException e) {
                e.printStackTrace();

            }
            response.sendRedirect("/files/filelist");
        }

    }

    @RequestMapping("/downloadFile")
    public void download(String fname, HttpServletRequest request, HttpServletResponse response) {
        ServletContext servletContext = request.getServletContext();

        String mimeType = servletContext.getMimeType(fname);
        response.setContentType(mimeType);

        response.setHeader("Content-Disposition", "attachment;filename=" + fname);

        //获取文件路径  得到输入流
        String path = servletContext.getRealPath("/upload");
        System.out.println(path);
        try {
            FileInputStream fis = new FileInputStream(new File(path, fname));
            //得到输出流
            OutputStream os = response.getOutputStream();
            //开始读取文件
            byte[] b = new byte[1024];
            int t;
            while ((t = fis.read(b)) != -1) {
                os.write(b, 0, t);
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //  http://localhost:8080/files/filelist  http://localhost:8080/admin/login-2.jsp
    @RequestMapping("/filelist")
    public String filelist(Model model, @RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "3") Integer pageSize,HttpSession session) {
        String fshares="1";
        Admin user = (Admin) session.getAttribute("user");
        PageInfo<Files> pageInfo = fileService.getFiles(pageNum, pageSize,fshares,user.getId());
        List<Files> list = pageInfo.getList();

        for (Files files : list) {

            System.out.println(files.getAdmin());
        }
        model.addAttribute("pageInfo",pageInfo);

        return "/admin/study/files.jsp";
    }

    @RequestMapping("/deleteFile")
    public String deleteFile(Files files, Model model) {
        fileService.deleteFile(files.getFid());
        return "redirect:/files/filelist";
    }

    @RequestMapping("/shareFile")
    public String shareFile(Long fid) {
        Files files = fileService.getFilesByFid(fid);
        files.setFshares("1");
        fileService.updateFileShares(files);
        return "redirect:/files/filelist";
    }
}
