package com.sc.forumService.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.Admin;
import com.sc.forumEntity.Invitation;
import com.sc.forumEntity.InvitationExample;
import com.sc.forumMapper.InvitationMapper;
import com.sc.forumService.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvitationServiceImpl implements InvitationService {
    @Autowired
    private InvitationMapper invitationMapper;

    public PageInfo<Invitation> getInvitationlist(Integer pageNum, Integer pageSize, String title, String content, String author, String type) {
        PageHelper.startPage(pageNum,pageSize);
        InvitationExample invitationExample=new InvitationExample();
        invitationExample.setOrderByClause("stick desc");
        InvitationExample.Criteria criteria = invitationExample.createCriteria();
        if (title!=null&&!title.trim().equals("")){
            criteria.andTitleLike("%"+title+"%");
        }
        if (content!=null&&!content.trim().equals("")){
            criteria.andContentLike("%"+content+"%");
        }
        if (author!=null&&!author.trim().equals("")){
            criteria.andAuthorLike("%"+author+"%");
        }

        if (type!=null&&!type.trim().equals("")){
            criteria.andTypeEqualTo(Long.parseLong(type));
        }
        criteria.andStatusEqualTo(0L);
        List<Invitation> invitations = invitationMapper.selectByExample(invitationExample);
        return new PageInfo<Invitation>(invitations,10);

    }

    public int addInvitation(Invitation invitation) {
        return invitationMapper.insert(invitation);
    }

    public int updateInvitation(Invitation invitation,Long invitationid) {
        InvitationExample invitationExample =new InvitationExample();
        InvitationExample.Criteria criteria = invitationExample.createCriteria();
        criteria.andIdEqualTo(invitationid);
        return invitationMapper.updateByExampleSelective(invitation,invitationExample);
    }

    public Invitation getInvitationById(Long invitationid) {
        Invitation invitation = invitationMapper.getInvitationById(invitationid);
        return invitation;
    }

    public PageInfo<Invitation> getUserInvitations(Integer pageNum, Integer pageSize, String title, String content, String type, HttpSession session) {
        PageHelper.startPage(pageNum,pageSize);
        InvitationExample invitationExample=new InvitationExample();
        invitationExample.setOrderByClause("id asc");
        InvitationExample.Criteria criteria = invitationExample.createCriteria();
        Admin user = (Admin)session.getAttribute("user");
        criteria.andAuthorEqualTo(user.getName());
        if (title!=null&&!title.trim().equals("")){
            criteria.andTitleLike("%"+title+"%");
        }
        if (content!=null&&!content.trim().equals("")){
            criteria.andContentLike("%"+content+"%");
        }
        if (type!=null&&!type.trim().equals("")){
            criteria.andTypeEqualTo(Long.parseLong(type));
        }
        criteria.andStatusEqualTo(0L);
        List<Invitation> invitations = invitationMapper.selectByExample(invitationExample);
        return new PageInfo<Invitation>(invitations,10);
    }

    public int deleteForumInvitationById(String invitationid) {
        InvitationExample invitationExample=new InvitationExample();
        InvitationExample.Criteria criteria = invitationExample.createCriteria();
        criteria.andIdEqualTo(Long.parseLong(invitationid));
        return invitationMapper.deleteByExample(invitationExample);
    }

    public int deleteInvitations(HttpServletRequest request) {
        String[] ids = request.getParameterValues("ids");
        InvitationExample invitationExample=new InvitationExample();
        InvitationExample.Criteria criteria = invitationExample.createCriteria();
        List<Long> list=new ArrayList<Long>();
        int i=0;
        if (ids!=null){
            for (String id : ids) {
                long parseLong = Long.parseLong(id);
                list.add(parseLong);
            }
            criteria.andIdIn(list);
            i= invitationMapper.deleteByExample(invitationExample);
        }
        return i;
    }

    @Override
    public int updateInvitationByStatus(Invitation invitation,Long invitationid) {
        InvitationExample invitationExample =new InvitationExample();
        InvitationExample.Criteria criteria = invitationExample.createCriteria();
        criteria.andIdEqualTo(invitationid);
        return invitationMapper.updateByExample(invitation,invitationExample);
    }

    @Override
    public int updateInvitationByStick(Invitation invitation, Long invitationid) {
        InvitationExample invitationExample =new InvitationExample();
        InvitationExample.Criteria criteria = invitationExample.createCriteria();
        criteria.andIdEqualTo(invitationid);
        return invitationMapper.updateByExample(invitation,invitationExample);
    }

    @Override
    public int updateInvitationByQuintessence(Invitation invitation, Long invitationid) {
        InvitationExample invitationExample =new InvitationExample();
        InvitationExample.Criteria criteria = invitationExample.createCriteria();
        criteria.andIdEqualTo(invitationid);
        return invitationMapper.updateByExample(invitation,invitationExample);
    }

    @Override
    public List<Invitation> selectInvitation(HttpServletRequest request) {
        String[] ids = request.getParameterValues("ids");
        InvitationExample invitationExample = new InvitationExample();
        InvitationExample.Criteria criteria = invitationExample.createCriteria();
        List<Long> list = new ArrayList<Long>();
        int i = 0;
        if (ids != null) {
            for (String id : ids) {
                long parseLong = Long.parseLong(id);
                list.add(parseLong);
            }
            criteria.andIdIn(list);
        }
        return invitationMapper.selectByExample(invitationExample);
    }

    @Override
    public int updateInvitationByArray(List<Invitation> invitations) {
        return invitationMapper.updateInvitationByArray(invitations);
    }

    @Override
    public PageInfo<Invitation> getInvitationslist(Integer pageNum, Integer pageSize, String id, String content, String author, String status) {
        PageHelper.startPage(pageNum,pageSize);
        InvitationExample invitationExample=new InvitationExample();
        invitationExample.setOrderByClause("stick desc");
        InvitationExample.Criteria criteria = invitationExample.createCriteria();
        if (id!=null&&!id.trim().equals("")){
           criteria.andIdEqualTo(Long.parseLong(id));
        }
        if (content!=null&&!content.trim().equals("")){
            criteria.andContentLike("%"+content+"%");
        }
        if (author!=null&&!author.trim().equals("")){
            criteria.andAuthorLike("%"+author+"%");
        }

        if (status!=null&&!status.trim().equals("")){
           criteria.andStatusEqualTo(Long.parseLong(status));
        }
        List<Invitation> invitations = invitationMapper.selectByExample(invitationExample);
        return new PageInfo<Invitation>(invitations,10);
    }


}
