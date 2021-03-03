package com.sc.forumEntity;

import java.io.Serializable;

public class Report implements Serializable {
    private Long id;//举报id

    private Long pId;//举报人id

    private Long type;//举报类型

    private String content;//举报内容

    private String cause;//举报理由

    private Long status;//举报状态

    private Long iId;//被举报帖子id

    private Long rId;//被举报评论id

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause == null ? null : cause.trim();
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getiId() {
        return iId;
    }

    public void setiId(Long iId) {
        this.iId = iId;
    }

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pId=").append(pId);
        sb.append(", type=").append(type);
        sb.append(", content=").append(content);
        sb.append(", cause=").append(cause);
        sb.append(", status=").append(status);
        sb.append(", iId=").append(iId);
        sb.append(", rId=").append(rId);
        sb.append("]");
        return sb.toString();
    }
}