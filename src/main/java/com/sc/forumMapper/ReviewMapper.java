package com.sc.forumMapper;

import com.sc.forumEntity.Review;
import com.sc.forumEntity.ReviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReviewMapper {
    long countByExample(ReviewExample example);

    int deleteByExample(ReviewExample example);

    int insert(Review record);

    int insertSelective(Review record);

    Review getReview(Long reviewid);

    List<Review> selectByExample(ReviewExample example);

    int updateByExampleSelective(@Param("record") Review record, @Param("example") ReviewExample example);

    int updateByExample(@Param("record") Review record, @Param("example") ReviewExample example);

    int updateReviewByArray(List<Review> reviews);
}