package com.sc.forumEntity;

import java.io.Serializable;
import java.util.Date;

public class Review implements Serializable {
    private Long id;//评论id

    private Long iId;//被评论帖子id

    private String content;//评论内容

    private Date time;//评论时间

    private Long pId;//评论人id

    private Long fId;//状态  0 正常  1 删除  2 举报

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getiId() {
        return iId;
    }

    public void setiId(Long iId) {
        this.iId = iId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public Long getfId() {
        return fId;
    }

    public void setfId(Long fId) {
        this.fId = fId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", iId=").append(iId);
        sb.append(", content=").append(content);
        sb.append(", time=").append(time);
        sb.append(", pId=").append(pId);
        sb.append(", fId=").append(fId);
        sb.append("]");
        return sb.toString();
    }
}