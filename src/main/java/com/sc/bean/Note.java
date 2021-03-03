package com.sc.bean;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {
    private Long nid;

    private Long ncid;

    private Long adminid;

    private String title;

    private String text;

    private Date releasetime;

    private String shares;

   private Admin admin;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    private static final long serialVersionUID = 1L;

    public Long getNid() {
        return nid;
    }

    public void setNid(Long nid) {
        this.nid = nid;
    }

    public Long getNcid() {
        return ncid;
    }

    public void setNcid(Long ncid) {
        this.ncid = ncid;
    }

    public Long getAdminid() {
        return adminid;
    }

    public void setAdminid(Long adminid) {
        this.adminid = adminid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public String getShares() {
        return shares;
    }

    public void setShares(String shares) {
        this.shares = shares == null ? null : shares.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", nid=").append(nid);
        sb.append(", ncid=").append(ncid);
        sb.append(", adminid=").append(adminid);
        sb.append(", title=").append(title);
        sb.append(", text=").append(text);
        sb.append(", releasetime=").append(releasetime);
        sb.append(", shares=").append(shares);
        sb.append("]");
        return sb.toString();
    }
}