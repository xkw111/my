package com.sc.mapper;

import com.sc.bean.Note;
import com.sc.bean.NoteExample;
import java.util.List;

import com.sc.bean.User;
import org.apache.ibatis.annotations.Param;

public interface NoteMapper {
    long countByExample(NoteExample example);

    int deleteByExample(NoteExample example);

    int deleteByPrimaryKey(Long nid);

    int insert(Note record);

    int insertSelective(Note record);

    List<Note> selectByExample(NoteExample example);

    Note selectByPrimaryKey(Long nid);

    int updateByExampleSelective(@Param("record") Note record, @Param("example") NoteExample example);

    int updateByExample(@Param("record") Note record, @Param("example") NoteExample example);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKey(Note record);

    public List<Note> getMyNotes(Long adminid);
    public List<Note> getMyOrShare(@Param("shares")String shares,@Param("adminid") Long adminid,@Param("title")String title);
}