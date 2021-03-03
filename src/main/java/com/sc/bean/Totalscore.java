package com.sc.bean;


public class Totalscore {    //试卷总分表

  private Integer tsid;      //试卷总分表记录Id
  private Long userid;        //用户id
  private Long paperid;        //试卷id
  private Integer allscore;      //用户总分

  public Totalscore() {
  }

  public Totalscore(Integer tsid, Long userid, Long paperid, Integer allscore) {
    this.tsid = tsid;
    this.userid = userid;
    this.paperid = paperid;
    this.allscore = allscore;
  }

  public Integer getTsid() {
    return tsid;
  }

  public void setTsid(Integer tsid) {
    this.tsid = tsid;
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

  @Override
  public String toString() {
    return "Totalscore{" +
            "tsid=" + tsid +
            ", userid=" + userid +
            ", paperid=" + paperid +
            ", allscore=" + allscore +
            '}';
  }
}
