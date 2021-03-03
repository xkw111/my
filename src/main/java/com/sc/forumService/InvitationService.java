package com.sc.forumService;

import com.github.pagehelper.PageInfo;
import com.sc.forumEntity.Invitation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface InvitationService {
    public PageInfo<Invitation> getInvitationlist(Integer pageNum, Integer pageSize, String title, String content, String author, String type);
    public int addInvitation(Invitation invitation);
    public int updateInvitation(Invitation invitation, Long invitationid);
    public Invitation getInvitationById(Long invitationid);
    public PageInfo<Invitation> getUserInvitations(Integer pageNum, Integer pageSize, String title, String content, String type, HttpSession session);
    public int deleteForumInvitationById(String invitationid);
    public int deleteInvitations(HttpServletRequest request);

    public int updateInvitationByStatus(Invitation invitation,Long invitationid);
    public int updateInvitationByStick(Invitation invitation,Long invitationid);
    public int updateInvitationByQuintessence(Invitation invitation,Long invitationid);
    public List<Invitation> selectInvitation(HttpServletRequest request);
    public int updateInvitationByArray(List<Invitation> invitations);
    public PageInfo<Invitation> getInvitationslist(Integer pageNum, Integer pageSize, String id, String content, String author, String status);
}
