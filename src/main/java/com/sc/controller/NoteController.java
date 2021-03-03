package com.sc.controller;

import com.github.pagehelper.PageInfo;
import com.sc.bean.Admin;
import com.sc.bean.Note;
import com.sc.bean.Noteclass;
import com.sc.bean.User;
import com.sc.service.NoteService;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @RequestMapping("/addNote")
    public void addNote(HttpSession session, Note note, HttpServletResponse response, HttpServletRequest request) throws Exception {
        note.setReleasetime(new Date());
        Admin user = (Admin)session.getAttribute("user");
        note.setAdminid(user.getId());
        noteService.addNote(note);
        response.sendRedirect("/note/getNoteList");
    }

    @RequestMapping("/getNoteclassList")
    @ResponseBody
    public List<Noteclass> getNoteclassList(Model model) {
        List<Noteclass> noteclassList = noteService.getNoteclassList();
        return noteclassList;
    }

    @RequestMapping("/getNoteList")
    public void getNoteList(@RequestParam(defaultValue = "1") Integer pageNum,HttpSession session, HttpServletResponse response, HttpServletRequest request,
                            @RequestParam(defaultValue = "3") Integer pageSize,String title) throws Exception {
        String shares = "1";
        Admin user = (Admin) session.getAttribute("user");
        PageInfo<Note> pageInfo = noteService.getNoteList(user.getId(), shares,pageNum,pageSize,title);
        session.setAttribute("pageInfo", pageInfo);
        session.setAttribute("title",title);
        response.sendRedirect("/admin/study/note.jsp");
    }

    @RequestMapping("/deleteNote")
    public String deleteNote(Long nid, Model model) {
        noteService.deleteNote(nid);
        return "/note/getNoteList";
    }

    @RequestMapping("/shareNote")
    public String shareNote(Long nid) {
        Note note = noteService.getNoteByNid(nid);
        note.setShares("1");
        noteService.updateNote(note);
        return "redirect:/note/getNoteList";
    }

}

