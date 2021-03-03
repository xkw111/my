package com.sc.forumEntity;

import java.io.Serializable;
import java.util.Date;

public class Invitation implements Serializable {
    private Long id;//帖子id

    private Long type;//帖子类型

    private String title;//帖子标题

    private String author;//帖子作者

    private String content;//帖子内容

    private Long stick;//置顶

    private Long quintessence;//精华

    private Long status;//帖子状态

    private Date time;//发帖时间

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Long getStick() {
        return stick;
    }

    public void setStick(Long stick) {
        this.stick = stick;
    }

    public Long getQuintessence() {
        return quintessence;
    }

    public void setQuintessence(Long quintessence) {
        this.quintessence = quintessence;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", title=").append(title);
        sb.append(", author=").append(author);
        sb.append(", content=").append(content);
        sb.append(", stick=").append(stick);
        sb.append(", quintessence=").append(quintessence);
        sb.append(", status=").append(status);
        sb.append(", time=").append(time);
        sb.append("]");
        return sb.toString();
    }
}