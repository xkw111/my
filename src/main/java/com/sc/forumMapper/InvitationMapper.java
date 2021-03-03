package com.sc.forumMapper;

import com.sc.forumEntity.Invitation;
import com.sc.forumEntity.InvitationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InvitationMapper {
    long countByExample(InvitationExample example);

    int deleteByExample(InvitationExample example);

    int insert(Invitation record);

    int insertSelective(Invitation record);

    Invitation getInvitationById(Long invitationId);

    List<Invitation> selectByExample(InvitationExample example);

    int updateByExampleSelective(@Param("record") Invitation record, @Param("example") InvitationExample example);

    int updateByExample(@Param("record") Invitation record, @Param("example") InvitationExample example);

    int updateInvitationByArray(List<Invitation> invitations);
}