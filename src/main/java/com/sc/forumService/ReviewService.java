package com.sc.forumService;

import com.github.pagehelper.PageInfo;
import com.sc.forumEntity.Review;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ReviewService {
    public List<Review> getReview(Long reviewid);
    public PageInfo<Review> getReviewlist(@RequestParam(defaultValue = "1") Integer pageNum,
                                          @RequestParam(defaultValue = "10") Integer pageSize,
                                          String content,
                                          Long id);
    public int addReview(Review review);
    public int deleteReview(Long reviewid);
    public int deleteReviewByArray(HttpServletRequest request);
    public List<Review> getReviewById(Long invitationid);
    public PageInfo<Review> getReviewslist(@RequestParam(defaultValue = "1") Integer pageNum,
                                      @RequestParam(defaultValue = "10") Integer pageSize,
                                      String id,
                                      String content,
                                      String pId,
                                      String fId);

    public int updateReviewByFId(Review review,Long reviewid);
    public List<Review> selectReview(HttpServletRequest request);
    public int updateReviewByArray(List<Review> reviews);
    public Review getReviewByRid(Long reviewid);
}
