package com.sc.forumController;

import com.github.pagehelper.PageInfo;
import com.sc.bean.Admin;
import com.sc.bean.User;
import com.sc.forumEntity.Report;
import com.sc.forumEntity.Review;
import com.sc.forumService.ReportService;
import com.sc.forumService.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;
    @Autowired
    private ReviewService reviewService;

    @RequestMapping("/addReport")
    //用户新增举报
    public String addReport(Report report, HttpSession session,Long reviewid,Long invitationid){
        Admin user = (Admin) session.getAttribute("user");
        Long id = user.getId();
        report.setStatus(0L);
        report.setpId(id);
        if (invitationid==null){
            report.setrId(reviewid);
            reportService.addReport(report);
        }else {
            report.setiId(invitationid);
            reportService.addReport(report);
        }

        if (report.getiId()==null) {
            List<Review> reviews = reviewService.getReview(report.getrId());
            for (Review review : reviews) {
                return "forward:/user/getAdmin?invitationid=" + review.getiId();
            }
        }
        return "forward:/user/getAdmin?invitationid="+report.getiId();
    }

    //根据用户id和帖子id获取举报结果
    @RequestMapping("getReportByIid")
    public String getReportByIid(String invitationid,HttpSession session, Model model){
        Admin user = (Admin) session.getAttribute("user");
        Long id = user.getId();
        List<Report> reports = reportService.getReportByIid(id, invitationid);
        if (reports.size()>0){
            for (Report report : reports) {
                model.addAttribute("report",report);
                return "/updateReport.jsp";
            }
        }
        return "/addReport.jsp";
    }

    //根据用户id和评论id获取举报结果
    @RequestMapping("getReportByRid")
    public String getReportByRid(String reviewid,HttpSession session, Model model){
        Admin user = (Admin) session.getAttribute("user");
        Long id = user.getId();
        List<Report> reports = reportService.getReportByRid(id, reviewid);
        if (reports.size()>0){
            for (Report report : reports) {
                model.addAttribute("report",report);
                return "/updateReport.jsp";
            }
        }
        return "/addReport.jsp";
    }

    //用户修改举报
    @RequestMapping("updateReport")
    public String updateReport(Report report){
        reportService.updateReport(report,report.getId());
        return "redirect:/report/getReports";
    }

    //根据用户id查询所有举报
    @RequestMapping("getReports")
    public String getReports(@RequestParam(defaultValue = "1") Integer pageNum,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                    String cause,
                                    String content,
                                    String type,
                                    HttpSession session,
                                    Model model){
        Admin user = (Admin) session.getAttribute("user");
        Long id = user.getId();
        PageInfo<Report> reportlist = reportService.getReports(pageNum, pageSize, cause, content, type, id);
        model.addAttribute("reportlist",reportlist);
        model.addAttribute("cause",cause);
        model.addAttribute("content",content);
        model.addAttribute("type",type);
        return "/reportIndex.jsp";
    }

    //用户删除举报
    @RequestMapping("/deleteForumReportById")
    public String deleteForumReportById(String reportid){
        reportService.deleteForumReportById(reportid);
        return "redirect:/report/getReports";
    }

    //用户删除多个举报
    @RequestMapping("/deleteReports")
    public String deleteReports(HttpServletRequest request){
        reportService.deleteReport(request);
        return "redirect:/report/getReports";
    }

    //根据举报id查看举报对象
    @RequestMapping("getReport")
    public String getReport(Long reportid, Model model){
        List<Report> reports = reportService.getReport(reportid);
        for (Report report : reports) {
            model.addAttribute("report",report);
        }
        return "/updateReport.jsp";
    }


    @RequestMapping("/getReportslist")
    public String getReportslist(@RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 String id,
                                 String pId,
                                 String cause,
                                 String content,
                                 String status,
                                 Model model){
        PageInfo<Report> reportslist = reportService.getReportslist(pageNum, pageSize, id,pId,cause, content,status);
        model.addAttribute("reportslist",reportslist);
        model.addAttribute("id",id);
        model.addAttribute("pId",pId);
        model.addAttribute("cause",cause);
        model.addAttribute("content",content);
        model.addAttribute("status",status);
        return "/admin/forum/report.jsp";
    }

    @RequestMapping("/updateReportByStatus")
    public String updateReportByStatus(Long reportid){
        List<Report> report = reportService.getReport(reportid);
        for (Report report1 : report) {
            report1.setStatus(1L);
            reportService.updateReport(report1,report1.getId());
        }
        return "/report/getReportslist";
    }

    @RequestMapping("/updateReportByStatus2")
    public String updateReportByStatus2(Long reportid){
        List<Report> report = reportService.getReport(reportid);
        for (Report report1 : report) {
            report1.setStatus(2L);
            reportService.updateReport(report1,report1.getId());
        }
        return "/report/getReportslist";
    }

    @RequestMapping("/deleteReportById")
    public String deleteReportById(String reportid){
        reportService.deleteForumReportById(reportid);
        return "redirect:/report/getReportslist";
    }

    @RequestMapping("/deleteReportsArray")
    public String deleteReportsArray(HttpServletRequest request){
        reportService.deleteReport(request);
        return "redirect:/report/getReportslist";
    }

}
