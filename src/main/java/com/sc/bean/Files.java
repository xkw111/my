package com.sc.bean;

import java.io.Serializable;
import java.util.Date;

public class Files implements Serializable {
    private Long fid;

    private Long adminid;

    private String fname;

    private String furl;

    private String fshares;

    private Date ftime;
    private Admin admin;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    private static final long serialVersionUID = 1L;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public Long getAdminid() {
        return adminid;
    }

    public void setAdminid(Long adminid) {
        this.adminid = adminid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    public String getFurl() {
        return furl;
    }

    public void setFurl(String furl) {
        this.furl = furl == null ? null : furl.trim();
    }

    public String getFshares() {
        return fshares;
    }

    public void setFshares(String fshares) {
        this.fshares = fshares == null ? null : fshares.trim();
    }

    public Date getFtime() {
        return ftime;
    }

    public void setFtime(Date ftime) {
        this.ftime = ftime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fid=").append(fid);
        sb.append(", adminid=").append(adminid);
        sb.append(", fname=").append(fname);
        sb.append(", furl=").append(furl);
        sb.append(", fshares=").append(fshares);
        sb.append(", ftime=").append(ftime);
        sb.append("]");
        return sb.toString();
    }
}