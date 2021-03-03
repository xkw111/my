package com.sc.service;

import com.github.pagehelper.PageInfo;
import com.sc.bean.Note;
import com.sc.bean.Noteclass;
import com.sc.bean.User;

import java.util.List;

public interface NoteService {
    public int addNote(Note note);
    public PageInfo<Note> getNoteList(Long adminid, String shares, Integer pageNum, Integer pageSize,String title);
    public List<Noteclass> getNoteclassList();
    public List<Note> getMyNotes(Long adminid);
    public int deleteNote(Long id);
    public int updateNote(Note note);
    public Note getNoteByNid(Long nid);
}
