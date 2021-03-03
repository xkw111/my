package com.sc.bean;

public class PageVo {
    private Long userid;        //用户id
    private Long paperid;        //试卷id
    private Integer allscore;      //用户总分

    private String tpname;    //试卷名
    private String tpsub;     //试卷所属科目名
    private String tpbegintime;   //考试开始时间
    private Integer tpsj;   //考试时长
    private Integer tpscore;    //试卷总分

    public PageVo() {
    }

    public PageVo(Long userid, Long paperid, Integer allscore, String tpname, String tpsub, String tpbegintime, Integer tpsj, Integer tpscore) {
        this.userid = userid;
        this.paperid = paperid;
        this.allscore = allscore;
        this.tpname = tpname;
        this.tpsub = tpsub;
        this.tpbegintime = tpbegintime;
        this.tpsj = tpsj;
        this.tpscore = tpscore;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getPaperid() {
        return paperid;
    }

    public void setPaperid(Long paperid) {
        this.paperid = paperid;
    }

    public Integer getAllscore() {
        return allscore;
    }

    public void setAllscore(Integer allscore) {
        this.allscore = allscore;
    }

    public String getTpname() {
        return tpname;
    }

    public void setTpname(String tpname) {
        this.tpname = tpname;
    }

    public String getTpsub() {
        return tpsub;
    }

    public void setTpsub(String tpsub) {
        this.tpsub = tpsub;
    }

    public String getTpbegintime() {
        return tpbegintime;
    }

    public void setTpbegintime(String tpbegintime) {
        this.tpbegintime = tpbegintime;
    }

    public Integer getTpsj() {
        return tpsj;
    }

    public void setTpsj(Integer tpsj) {
        this.tpsj = tpsj;
    }

    public Integer getTpscore() {
        return tpscore;
    }

    public void setTpscore(Integer tpscore) {
        this.tpscore = tpscore;
    }

    @Override
    public String toString() {
        return "PageVo{" +
                "userid=" + userid +
                ", paperid=" + paperid +
                ", allscore=" + allscore +
                ", tpname='" + tpname + '\'' +
                ", tpsub='" + tpsub + '\'' +
                ", tpbegintime='" + tpbegintime + '\'' +
                ", tpsj=" + tpsj +
                ", tpscore=" + tpscore +
                '}';
    }
}
