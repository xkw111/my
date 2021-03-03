package com.sc.forumService;

import com.sc.bean.Admin;

import java.util.List;

public interface UserReviewService {
    public List<Admin> getAdmins(List<Long> ids);
}
