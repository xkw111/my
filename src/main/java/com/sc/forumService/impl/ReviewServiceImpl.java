package com.sc.forumService.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.forumEntity.Review;
import com.sc.forumEntity.ReviewExample;
import com.sc.forumMapper.ReviewMapper;
import com.sc.forumService.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewMapper reviewMapper;

    @Override
    public List<Review> getReview(Long reviewid) {
        ReviewExample reviewExample=new ReviewExample();
        ReviewExample.Criteria criteria = reviewExample.createCriteria();
        criteria.andIdEqualTo(reviewid);
        return reviewMapper.selectByExample(reviewExample);
    }

    @Override
    public PageInfo<Review> getReviewlist(Integer pageNum, Integer pageSize, String content, Long id) {
        PageHelper.startPage(pageNum,pageSize);
        ReviewExample reviewExample=new ReviewExample();
        reviewExample.setOrderByClause("id asc");
        ReviewExample.Criteria criteria = reviewExample.createCriteria();
        if (content!=null&&!content.trim().equals("")){
            criteria.andContentLike("%"+content+"%");
        }
        if (id!=null&&!id.equals("")){
            criteria.andPIdEqualTo(id);
        }
        criteria.andFIdEqualTo(0L);
        List<Review> reports = reviewMapper.selectByExample(reviewExample);
        return new PageInfo<Review>(reports,10);
    }

    @Override
    public int addReview(Review review) {
        return reviewMapper.insert(review);
    }

    @Override
    public int deleteReview(Long reviewid) {
        ReviewExample reviewExample=new ReviewExample();
        ReviewExample.Criteria criteria = reviewExample.createCriteria();
        if (reviewid!=null&&!reviewid.equals("")){
            criteria.andIdEqualTo(reviewid);
        }
        return reviewMapper.deleteByExample(reviewExample);
    }

    @Override
    public int deleteReviewByArray(HttpServletRequest request) {
        String[] ids = request.getParameterValues("ids");
        ReviewExample reviewExample=new ReviewExample();
        ReviewExample.Criteria criteria = reviewExample.createCriteria();
        List<Long> list=new ArrayList<Long>();
        int i=0;
        if (ids!=null){
            for (String id : ids) {
                long parseLong = Long.parseLong(id);
                list.add(parseLong);
            }
            criteria.andIdIn(list);
            i= reviewMapper.deleteByExample(reviewExample);
        }
        return i;
    }

    @Override
    public List<Review> getReviewById(Long invitationid) {
        ReviewExample reviewExample = new ReviewExample();
        ReviewExample.Criteria criteria = reviewExample.createCriteria();
        if (invitationid!=null&&!invitationid.equals("")){
           criteria.andIIdEqualTo(invitationid);
        }
        List<Review> reviews = reviewMapper.selectByExample(reviewExample);
        return reviews;
    }


    //后端
    @Override
    public PageInfo<Review> getReviewslist(Integer pageNum, Integer pageSize, String id, String content, String pId, String fId) {
        PageHelper.startPage(pageNum,pageSize);
        ReviewExample reviewExample=new ReviewExample();
        reviewExample.setOrderByClause("id asc");
        ReviewExample.Criteria criteria = reviewExample.createCriteria();
        if (id!=null&&!id.trim().equals("")){
            criteria.andIdEqualTo(Long.parseLong(id));
        }
        if (content!=null&&!content.trim().equals("")){
            criteria.andContentLike("%"+content+"%");
        }
        if (pId!=null&&!pId.trim().equals("")){
            criteria.andPIdEqualTo(Long.parseLong(pId));
        }
        if (fId!=null&&!fId.trim().equals("")){
            criteria.andFIdEqualTo(Long.parseLong(fId));
        }
        List<Review> reports = reviewMapper.selectByExample(reviewExample);
        return new PageInfo<Review>(reports,10);
    }


    @Override
    public int updateReviewByFId(Review review, Long reviewid) {
        ReviewExample reviewExample =new ReviewExample();
        ReviewExample.Criteria criteria = reviewExample.createCriteria();
        criteria.andIdEqualTo(reviewid);
        return reviewMapper.updateByExample(review,reviewExample);
    }

    @Override
    public List<Review> selectReview(HttpServletRequest request) {
        String[] ids = request.getParameterValues("ids");
        ReviewExample reviewExample = new ReviewExample();
        ReviewExample.Criteria criteria = reviewExample.createCriteria();
        List<Long> list = new ArrayList<Long>();
        int i = 0;
        if (ids != null) {
            for (String id : ids) {
                long parseLong = Long.parseLong(id);
                list.add(parseLong);
            }
            criteria.andIdIn(list);
        }
        return reviewMapper.selectByExample(reviewExample);
    }

    @Override
    public int updateReviewByArray(List<Review> reviews) {
        return reviewMapper.updateReviewByArray(reviews);
    }

    @Override
    public Review getReviewByRid(Long reviewid) {
        return reviewMapper.getReview(reviewid);
    }


}
