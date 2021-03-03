package com.sc.forumService;

import com.github.pagehelper.PageInfo;
import com.sc.forumEntity.Report;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ReportService {
    public int addReport(Report report);
    public List<Report> getReportByIid(Long id,String invitationid);
    public List<Report> getReportByRid(Long id,String reviewid);
    public int updateReport(Report report,Long reportid);
    public PageInfo<Report> getReports(@RequestParam(defaultValue = "1") Integer pageNum,
                                       @RequestParam(defaultValue = "10") Integer pageSize,
                                       String cause,
                                       String content,
                                       String type,
                                       Long id);
    public int deleteForumReportById(String reportid);
    public int deleteReport(HttpServletRequest request);
    public List<Report> getReport(Long reportid);


    public PageInfo<Report> getReportslist(@RequestParam(defaultValue = "1") Integer pageNum,
                                       @RequestParam(defaultValue = "10") Integer pageSize,
                                       String id,
                                       String pId,
                                       String cause,
                                       String content,
                                       String status);


}
