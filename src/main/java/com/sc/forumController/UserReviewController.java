package com.sc.forumController;

import com.sc.bean.Admin;
import com.sc.forumEntity.Invitation;
import com.sc.forumEntity.Review;
import com.sc.forumEntity.UserReview;
import com.sc.forumService.InvitationService;
import com.sc.forumService.ReviewService;
import com.sc.forumService.UserReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserReviewController {
    @Autowired
    private InvitationService invitationService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserReviewService userReviewService;

    @RequestMapping("/getAdmin")
    public String getAdmin(Long invitationid, Model model){
        Invitation invitation = invitationService.getInvitationById(invitationid);
        List<Review> reviews = reviewService.getReviewById(invitationid);
        List<Long> list=new ArrayList<Long>();
        if (reviews.size()>0){
            for (Review review : reviews) {
                list.add(review.getpId());
            }
            List<UserReview> userReviews=new ArrayList<UserReview>();
            List<Admin> admins = userReviewService.getAdmins(list);
            for (Admin admin : admins) {
                for (Review review : reviews) {
                    if (review.getpId()==admin.getId()){
                        UserReview userReview=new UserReview();
                        userReview.setId(review.getId());
                        userReview.setName(admin.getName());
                        userReview.setContent(review.getContent());
                        userReview.setHeadPic(admin.getHeadPic());
                        userReview.setTime(review.getTime());
                        userReviews.add(userReview);
                    }
                }
            }
            model.addAttribute("userReviews",userReviews);
        }

        model.addAttribute("invitation",invitation);

        return "/Invitation.jsp";
    }

}
