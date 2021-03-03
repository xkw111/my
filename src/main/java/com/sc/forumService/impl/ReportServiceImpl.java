package com.sc.forumService.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.forumEntity.Report;
import com.sc.forumEntity.ReportExample;
import com.sc.forumMapper.ReportMapper;
import com.sc.forumService.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;

    @Override
    public int addReport(Report report) {
        return reportMapper.insert(report);
    }

    @Override
    public List<Report> getReportByIid(Long id, String invitationid) {
        ReportExample reportExample=new ReportExample();
        ReportExample.Criteria criteria = reportExample.createCriteria();
        if (id!=null){
            criteria.andPIdEqualTo(id);
        }
        if (invitationid!=null){
            criteria.andIIdEqualTo(Long.parseLong(invitationid));
        }
        return reportMapper.selectByExample(reportExample);
    }

    @Override
    public List<Report> getReportByRid(Long id, String reviewid) {
        ReportExample reportExample=new ReportExample();
        ReportExample.Criteria criteria = reportExample.createCriteria();
        if (id!=null){
            criteria.andPIdEqualTo(id);
        }
        if (reviewid!=null){
            criteria.andRIdEqualTo(Long.parseLong(reviewid));
        }
        return reportMapper.selectByExample(reportExample);
    }

    @Override
    public int updateReport(Report report,Long reportid) {
        ReportExample reportExample =new ReportExample();
        ReportExample.Criteria criteria = reportExample.createCriteria();
        criteria.andIdEqualTo(reportid);
        return reportMapper.updateByExampleSelective(report,reportExample);
    }

    @Override
    public PageInfo<Report> getReports(Integer pageNum, Integer pageSize, String cause, String content, String type, Long id) {
        PageHelper.startPage(pageNum,pageSize);
        ReportExample reportExample=new ReportExample();
        reportExample.setOrderByClause("id asc");
        ReportExample.Criteria criteria = reportExample.createCriteria();
        if (cause!=null&&!cause.trim().equals("")){
            criteria.andCauseLike("%"+cause+"%");
        }
        if (content!=null&&!content.trim().equals("")){
            criteria.andContentLike("%"+content+"%");
        }
        if (type!=null&&!type.trim().equals("")){
            criteria.andTypeEqualTo(Long.parseLong(type));
        }
        if (id!=null&&!id.equals("")){
            criteria.andTypeEqualTo(id);
        }
        List<Report> reports = reportMapper.selectByExample(reportExample);
        return new PageInfo<Report>(reports,10);
    }

    @Override
    public int deleteForumReportById(String reportid) {
        ReportExample reportExample=new ReportExample();
        ReportExample.Criteria criteria = reportExample.createCriteria();
        if (reportid!=null&&!reportid.trim().equals("")){
            criteria.andIdEqualTo(Long.parseLong(reportid));
        }
        return reportMapper.deleteByExample(reportExample);
    }

    @Override
    public int deleteReport(HttpServletRequest request) {
        String[] ids = request.getParameterValues("ids");
        ReportExample reportExample=new ReportExample();
        ReportExample.Criteria criteria = reportExample.createCriteria();
        List<Long> list=new ArrayList<Long>();
        int i=0;
        if (ids!=null){
            for (String id : ids) {
                long parseLong = Long.parseLong(id);
                list.add(parseLong);
            }
            criteria.andIdIn(list);
            i= reportMapper.deleteByExample(reportExample);
        }
        return i;
    }

    @Override
    public List<Report> getReport(Long reportid) {
        ReportExample reportExample=new ReportExample();
        ReportExample.Criteria criteria = reportExample.createCriteria();
        if (reportExample!=null&&!reportid.equals("")){
            criteria.andIdEqualTo(reportid);
        }
        return reportMapper.selectByExample(reportExample);
    }




    //后端

    @Override
    public PageInfo<Report> getReportslist(Integer pageNum, Integer pageSize, String id, String pId, String cause, String content, String status) {
        PageHelper.startPage(pageNum,pageSize);
        ReportExample reportExample=new ReportExample();
        reportExample.setOrderByClause("id asc");
        ReportExample.Criteria criteria = reportExample.createCriteria();
        if (id!=null&&!id.trim().equals("")){
            criteria.andIdEqualTo(Long.parseLong(id));
        }
        if (pId!=null&&!pId.trim().equals("")){
            criteria.andPIdEqualTo(Long.parseLong(pId));
        }
        if (cause!=null&&!cause.trim().equals("")){
            criteria.andCauseLike("%"+cause+"%");
        }
        if (content!=null&&!content.trim().equals("")){
            criteria.andContentLike("%"+content+"%");
        }
        if (status!=null&&!status.trim().equals("")){
            criteria.andStatusEqualTo(Long.parseLong(status))  ;
        }

        List<Report> reports = reportMapper.selectByExample(reportExample);
        return new PageInfo<Report>(reports,10);
    }
}
