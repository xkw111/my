package com.sc.forumMapper;

import com.sc.forumEntity.Report;
import com.sc.forumEntity.ReportExample;
import java.util.List;

import com.sc.forumEntity.UserReview;
import org.apache.ibatis.annotations.Param;

public interface ReportMapper {
    long countByExample(ReportExample example);

    int deleteByExample(ReportExample example);

    int insert(Report record);

    int insertSelective(Report record);

    List<Report> selectByExample(ReportExample example);

    int updateByExampleSelective(@Param("record") Report record, @Param("example") ReportExample example);

    int updateByExample(@Param("record") Report record, @Param("example") ReportExample example);


}