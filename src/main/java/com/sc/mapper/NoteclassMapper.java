package com.sc.mapper;

import com.sc.bean.Noteclass;
import com.sc.bean.NoteclassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoteclassMapper {
    long countByExample(NoteclassExample example);

    int deleteByExample(NoteclassExample example);

    int deleteByPrimaryKey(Long ncid);

    int insert(Noteclass record);

    int insertSelective(Noteclass record);

    List<Noteclass> selectByExample(NoteclassExample example);

    Noteclass selectByPrimaryKey(Long ncid);

    int updateByExampleSelective(@Param("record") Noteclass record, @Param("example") NoteclassExample example);

    int updateByExample(@Param("record") Noteclass record, @Param("example") NoteclassExample example);

    int updateByPrimaryKeySelective(Noteclass record);

    int updateByPrimaryKey(Noteclass record);
}