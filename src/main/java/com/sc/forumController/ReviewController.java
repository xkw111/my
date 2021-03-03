package com.sc.forumController;

import com.github.pagehelper.PageInfo;
import com.sc.bean.Admin;
import com.sc.bean.User;
import com.sc.forumEntity.Invitation;
import com.sc.forumEntity.Review;
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
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    //查询用户所有评论
    @RequestMapping("getReviewlist")
    public String getReviewlist(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             String content,
                             HttpSession session,
                             Model model){
        Admin user = (Admin) session.getAttribute("user");
        Long id = user.getId();
        PageInfo<Review> reviewlist = reviewService.getReviewlist(pageNum, pageSize, content, id);
        model.addAttribute("reviewlist",reviewlist);
        model.addAttribute("content",content);
        return "/reviewIndex.jsp";
    }

    //根据id删除评论
    @RequestMapping("/deleteReview")
    public String deleteReview(String reviewid){
        reviewService.deleteReview(Long.parseLong(reviewid));
        return "redirect:/review/getReviewlist";
    }

    //用户删除多个评论
    @RequestMapping("/deleteReviewByArray")
    public String deleteReviewByArray(HttpServletRequest request){
        reviewService.deleteReviewByArray(request);
        return "redirect:/review/getReviewlist";
    }
    //用户新增评论
    @RequestMapping("/addReview")
    public String addReview(Review review, String invitationid, HttpSession session,String content){
        Admin user = (Admin) session.getAttribute("user");
        review.setpId(user.getId());
        review.setTime(new Date());
        review.setfId(0L);
        review.setiId(Long.parseLong(invitationid));
        if (content!=null&&!content.trim().equals("")){
            review.setContent(content);
            reviewService.addReview(review);
        }
        return "forward:/user/getAdmin?invitationid="+review.getiId();
    }

    @RequestMapping("/getReviewslist")
    public String getReviewslist(@RequestParam(defaultValue = "1") Integer pageNum,
                                     @RequestParam(defaultValue = "10") Integer pageSize,
                                     String id,
                                     String content,
                                     String pId,
                                     String fId,
                                     Model model){
        PageInfo<Review> reviewslist = reviewService.getReviewslist(pageNum, pageSize, id, content, pId,fId);
        model.addAttribute("reviewslist",reviewslist);
        model.addAttribute("id",id);
        model.addAttribute("pId",pId);
        model.addAttribute("content",content);
        model.addAttribute("fId",fId);
        return "/admin/forum/review.jsp";
    }

    @RequestMapping("/updateReviewByFId")
    public String updateReviewByFId(Long reviewid){
        Review review = reviewService.getReviewByRid(reviewid);
        review.setfId(1L);
        reviewService.updateReviewByFId(review,review.getId());
        return "redirect:/review/getReviewslist";
    }

    @RequestMapping("/updateReviewByArray")
    public String updateReviewByArray(HttpServletRequest request){
        List<Review> reviews = reviewService.selectReview(request);
        for (Review review : reviews) {
            review.setfId(1L);
        }
        reviewService.updateReviewByArray(reviews);
        return "redirect:/review/getReviewslist";
    }

}
