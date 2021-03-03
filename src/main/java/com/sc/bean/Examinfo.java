package com.sc.bean;


public class Examinfo {    //考试记录表

  private Integer eid;    //id
  private Long euserid;    //用户Id
  private Long paperid;    //试卷id
  private Long eqid;      //题目id
  private String euseranswer;    //用户答案
  private Integer escore;     //用户该题成绩

  public Examinfo() {
  }

  public Examinfo(Integer eid, Long euserid, Long paperid, Long eqid, String euseranswer, Integer escore) {
    this.eid = eid;
    this.euserid = euserid;
    this.paperid = paperid;
    this.eqid = eqid;
    this.euseranswer = euseranswer;
    this.escore = escore;
  }

  public Integer getEid() {
    return eid;
  }

  public void setEid(Integer eid) {
    this.eid = eid;
  }

  public Long getEuserid() {
    return euserid;
  }

  public void setEuserid(Long euserid) {
    this.euserid = euserid;
  }

  public Long getPaperid() {
    return paperid;
  }

  public void setPaperid(Long paperid) {
    this.paperid = paperid;
  }

  public Long getEqid() {
    return eqid;
  }

  public void setEqid(Long eqid) {
    this.eqid = eqid;
  }

  public String getEuseranswer() {
    return euseranswer;
  }

  public void setEuseranswer(String euseranswer) {
    this.euseranswer = euseranswer;
  }

  public Integer getEscore() {
    return escore;
  }

  public void setEscore(Integer escore) {
    this.escore = escore;
  }

  @Override
  public String toString() {
    return "Examinfo{" +
            "eid=" + eid +
            ", euserid=" + euserid +
            ", paperid=" + paperid +
            ", eqid=" + eqid +
            ", euseranswer='" + euseranswer + '\'' +
            ", escore=" + escore +
            '}';
  }
}
