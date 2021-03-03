package com.sc.bean;


import java.util.Date;

public class Testpage {    //试卷表

  private Long tpid;     //试卷id
  private String tpname;    //试卷名
  private String tpsub;     //试卷所属科目
  private String tpbegintime;  //考试开始时间
  private Integer tpscore;    //试卷总分
  private Integer tpnum;        //题目数量
  private Integer tpsinglescore;    //每道题多少分
  private Integer tpsj;   //考试时长

  //被动考试需要的信息
  private Long sid;     //需要考试的学生id
  private Long cid;      //需要考试的班级id

  public Long getSid() {
    return sid;
  }

  public void setSid(Long sid) {
    this.sid = sid;
  }

  public Long getCid() {
    return cid;
  }

  public void setCid(Long cid) {
    this.cid = cid;
  }

  public Testpage(Long tpid, String tpname, String tpsub, String tpbegintime, Integer tpscore, Integer tpnum, Integer tpsinglescore, Integer tpsj, Long sid, Long cid) {
    this.tpid = tpid;
    this.tpname = tpname;
    this.tpsub = tpsub;
    this.tpbegintime = tpbegintime;
    this.tpscore = tpscore;
    this.tpnum = tpnum;
    this.tpsinglescore = tpsinglescore;
    this.tpsj = tpsj;
    this.sid = sid;
    this.cid = cid;
  }

  public Testpage() {
  }

  public Testpage(Long tpid, String tpname, String tpsub, String tpbegintime, Integer tpscore, Integer tpnum, Integer tpsinglescore, Integer tpsj) {
    this.tpid = tpid;
    this.tpname = tpname;
    this.tpsub = tpsub;
    this.tpbegintime = tpbegintime;
    this.tpscore = tpscore;
    this.tpnum = tpnum;
    this.tpsinglescore = tpsinglescore;
    this.tpsj = tpsj;
  }

  public Long getTpid() {
    return tpid;
  }

  public void setTpid(Long tpid) {
    this.tpid = tpid;
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

  public Integer getTpscore() {
    return tpscore;
  }

  public void setTpscore(Integer tpscore) {
    this.tpscore = tpscore;
  }

  public Integer getTpnum() {
    return tpnum;
  }

  public void setTpnum(Integer tpnum) {
    this.tpnum = tpnum;
  }

  public Integer getTpsinglescore() {
    return tpsinglescore;
  }

  public void setTpsinglescore(Integer tpsinglescore) {
    this.tpsinglescore = tpsinglescore;
  }

  public Integer getTpsj() {
    return tpsj;
  }

  public void setTpsj(Integer tpsj) {
    this.tpsj = tpsj;
  }

  @Override
  public String toString() {
    return "Testpage{" +
            "tpid=" + tpid +
            ", tpname='" + tpname + '\'' +
            ", tpsub='" + tpsub + '\'' +
            ", tpbegintime='" + tpbegintime + '\'' +
            ", tpscore=" + tpscore +
            ", tpnum=" + tpnum +
            ", tpsinglescore=" + tpsinglescore +
            ", tpsj=" + tpsj +
            ", sid=" + sid +
            ", cid=" + cid +
            '}';
  }
}
