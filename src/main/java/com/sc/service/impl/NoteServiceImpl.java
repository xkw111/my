package com.sc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.Note;
import com.sc.bean.NoteExample;
import com.sc.bean.Noteclass;
import com.sc.mapper.NoteMapper;
import com.sc.mapper.NoteclassMapper;
import com.sc.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteMapper noteMapper;
    @Autowired
    private NoteclassMapper noteclassMapper;

    public int addNote(Note note) {
        int i = noteMapper.insert(note);
        return i;
    }


    public PageInfo<Note> getNoteList(Long adminid, String shares, Integer pageNum, Integer pageSize,String title) {
        PageHelper.startPage(pageNum,pageSize);
        List<Note> noteList = noteMapper.getMyOrShare(shares,adminid,title);
        return new PageInfo<Note>(noteList);
    }


    public List<Noteclass> getNoteclassList() {
        List<Noteclass> noteclassList = noteclassMapper.selectByExample(null);
        return noteclassList;
    }


    public List<Note> getMyNotes(Long adminid) {
        List<Note> myNotes = noteMapper.getMyNotes(adminid);
        return myNotes;
    }


    public int deleteNote(Long nid) {
        int i = noteMapper.deleteByPrimaryKey(nid);
        return i;
    }


    public int updateNote(Note note) {
        int i = noteMapper.updateByPrimaryKey(note);
        return i;
    }


    public Note getNoteByNid(Long nid) {
        Note note = noteMapper.selectByPrimaryKey(nid);
        return note;
    }

}
