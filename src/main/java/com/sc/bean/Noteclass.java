package com.sc.bean;

import java.io.Serializable;

public class Noteclass implements Serializable {
    private Long ncid;

    private String ncname;

    private static final long serialVersionUID = 1L;

    public Long getNcid() {
        return ncid;
    }

    public void setNcid(Long ncid) {
        this.ncid = ncid;
    }

    public String getNcname() {
        return ncname;
    }

    public void setNcname(String ncname) {
        this.ncname = ncname == null ? null : ncname.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ncid=").append(ncid);
        sb.append(", ncname=").append(ncname);
        sb.append("]");
        return sb.toString();
    }
}