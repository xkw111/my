package com.sc.forumService.impl;

import com.sc.bean.Admin;
import com.sc.bean.AdminExample;
import com.sc.forumService.UserReviewService;
import com.sc.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReviewServiceImpl implements UserReviewService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public List<Admin> getAdmins(List<Long> ids) {
        AdminExample adminExample=new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        if (ids!=null){
            criteria.andIdIn(ids);
        }
        return adminMapper.selectByExample(adminExample);
    }
}
