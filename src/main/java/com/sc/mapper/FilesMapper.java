package com.sc.mapper;

import com.sc.bean.Files;
import com.sc.bean.FilesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FilesMapper {
    long countByExample(FilesExample example);

    int deleteByExample(FilesExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(Files record);

    int insertSelective(Files record);

    List<Files> selectByExample(FilesExample example);

    Files selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") Files record, @Param("example") FilesExample example);

    int updateByExample(@Param("record") Files record, @Param("example") FilesExample example);

    int updateByPrimaryKeySelective(Files record);

    int updateByPrimaryKey(Files record);
    public List<Files> getMyAndShares(@Param("fshares") String fshares,@Param("adminid") Long adminid);
}