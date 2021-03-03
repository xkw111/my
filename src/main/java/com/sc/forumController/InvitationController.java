package com.sc.forumController;

import com.github.pagehelper.PageInfo;
import com.sc.bean.Admin;
import com.sc.forumEntity.Invitation;
import com.sc.forumEntity.Review;
import com.sc.forumService.InvitationService;
import com.sc.forumService.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/invitation")
public class InvitationController {
    @Autowired
    private InvitationService invitationService;
    @Autowired
    private ReviewService reviewService;

    //首页按条件查询
    @RequestMapping("/getInvitationlist")
    public String getInvitationlist(@RequestParam(defaultValue = "1") Integer pageNum,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                    String title,
                                    String content,
                                    String author,
                                    String type,
                                    Model model){
        PageInfo<Invitation> invitationlist = invitationService.getInvitationlist(pageNum, pageSize, title, content, author, type);
        model.addAttribute("invitationlist",invitationlist);
        model.addAttribute("title",title);
        model.addAttribute("content",content);
        model.addAttribute("author",author);
        model.addAttribute("type",type);
        return "/forumIndex.jsp";
    }

    //用户新增发帖
    @RequestMapping("/addForumInvitation")
    public String addForumInvitation(Invitation invitation, HttpSession session){
        Admin user = (Admin) session.getAttribute("user");
        invitation.setAuthor(user.getName());
        invitation.setTime(new Date());
        if (invitation.getQuintessence()==null||invitation.getQuintessence().equals("")){
            invitation.setQuintessence(0L);
        }
        if (invitation.getStick()==null||invitation.getStick().equals("")){
            invitation.setStick(0L);
        }
        if (invitation.getStatus()==null||invitation.getStatus().equals("")){
            invitation.setStatus(0L);
        }

        invitationService.addInvitation(invitation);
        return "redirect:/invitation/getInvitationlist";
    }

    //修改时先查询出来，根据id查询对象
    @RequestMapping("getInvitationById")
        public String getInvitationById( String  invitationid, Model model){
        Invitation invitation = invitationService.getInvitationById(Long.parseLong(invitationid));
        model.addAttribute("invitation",invitation);
        return "/updateForumInvitation.jsp";
    }

    //用户修改自己的帖子
    @RequestMapping("/updateForumInvitation")
    public String updateForumInvitation(Invitation invitation){
        invitationService.updateInvitation(invitation,invitation.getId());
        return "redirect:/invitation/getUserInvitations";
    }

    //用户根据自己的用户名查询所有帖子
    @RequestMapping("/getUserInvitations")
    public String getUserInvitations(@RequestParam(defaultValue = "1") Integer pageNum,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                    String title,
                                    String content,
                                    String type,
                                    HttpSession session,
                                    Model model){
        PageInfo<Invitation> invitationlist = invitationService.getUserInvitations(pageNum, pageSize, title, content, type,session);
        model.addAttribute("invitationlist",invitationlist);
        model.addAttribute("title",title);
        model.addAttribute("content",content);
        model.addAttribute("type",type);
        return "/userIndex.jsp";
    }

    //用户删除帖子
    @RequestMapping("/deleteForumInvitationById")
    public String deleteForumInvitationById(String invitationid){
        invitationService.deleteForumInvitationById(invitationid);
        return "redirect:/invitation/getUserInvitations";
    }

    //用户删除多张帖子
    @RequestMapping("/deleteInvitations")
    public String deleteInvitations(HttpServletRequest request){
        invitationService.deleteInvitations(request);
        return "redirect:/invitation/getUserInvitations";
    }

    //根据id查询对象,查看帖子的详细内容
    @RequestMapping("getInvitationContentById")
    public String getInvitationContentById( Long invitationid, Model model){
        Invitation invitation = invitationService.getInvitationById(invitationid);
        List<Review> reviews = reviewService.getReviewById(invitationid);
        model.addAttribute("reviews",reviews);
        model.addAttribute("invitation",invitation);
        return "/Invitation.jsp";
    }

    @RequestMapping("/getInvitationslist")
    public String getInvitationslist(@RequestParam(defaultValue = "1") Integer pageNum,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                    String id,
                                    String content,
                                    String author,
                                    String status,
                                    Model model){
        PageInfo<Invitation> invitationslist = invitationService.getInvitationslist(pageNum, pageSize, id, content, author, status);
        model.addAttribute("invitationslist",invitationslist);
        model.addAttribute("id",id);
        model.addAttribute("content",content);
        model.addAttribute("author",author);
        model.addAttribute("status",status);
        return "/admin/forum/invitation.jsp";
    }

    @RequestMapping("/updateInvitationByStatus")
    public String updateInvitationByStatus(Long invitationid){
        Invitation invitationById = invitationService.getInvitationById(invitationid);
        invitationById.setStatus(1L);
        invitationService.updateInvitationByStatus(invitationById,invitationid);
        return "redirect:/invitation/getInvitationslist";
    }

    @RequestMapping("/updateInvitationByArray")
    public String updateInvitationByArray(HttpServletRequest request){
        List<Invitation> invitations = invitationService.selectInvitation(request);
        for (Invitation invitation : invitations) {
            invitation.setStatus(1L);
        }
        invitationService.updateInvitationByArray(invitations);
        return "redirect:/invitation/getInvitationslist";
    }

    @RequestMapping("/updateInvitationByStick")
    public String updateInvitationByStick(Long invitationid){
        Invitation invitationById = invitationService.getInvitationById(invitationid);
        invitationById.setStick(1L);
        invitationService.updateInvitationByStick(invitationById,invitationid);
        return "redirect:/invitation/getInvitationslist";
    }

    @RequestMapping("/updateInvitationByStick2")
    public String updateInvitationByStick2(Long invitationid){
        Invitation invitationById = invitationService.getInvitationById(invitationid);
        invitationById.setStick(0L);
        invitationService.updateInvitationByStick(invitationById,invitationid);
        return "redirect:/invitation/getInvitationslist";
    }

    @RequestMapping("/updateInvitationByQuintessence")
    public String updateInvitationByQuintessence(Long invitationid){
        Invitation invitationById = invitationService.getInvitationById(invitationid);
        invitationById.setQuintessence(1L);
        invitationService.updateInvitationByQuintessence(invitationById,invitationid);
        return "redirect:/invitation/getInvitationslist";
    }

    @RequestMapping("/updateInvitationByQuintessence2")
    public String updateInvitationByQuintessence2(Long invitationid){
        Invitation invitationById = invitationService.getInvitationById(invitationid);
        invitationById.setQuintessence(0L);
        invitationService.updateInvitationByQuintessence(invitationById,invitationid);
        return "redirect:/invitation/getInvitationslist";
    }
}
