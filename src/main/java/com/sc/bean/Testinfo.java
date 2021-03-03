package com.sc.bean;


public class Testinfo {   //试卷详情表

  private Integer tinfoid;   //试卷详情表id
  private Long tinfopaperid;  //试卷id
  private Long tinfosuqid;   //题目id

  public Testinfo() {
  }

  public Testinfo(Integer tinfoid, Long tinfopaperid, Long tinfosuqid) {
    this.tinfoid = tinfoid;
    this.tinfopaperid = tinfopaperid;
    this.tinfosuqid = tinfosuqid;
  }

  public Integer getTinfoid() {
    return tinfoid;
  }

  public void setTinfoid(Integer tinfoid) {
    this.tinfoid = tinfoid;
  }

  public Long getTinfopaperid() {
    return tinfopaperid;
  }

  public void setTinfopaperid(Long tinfopaperid) {
    this.tinfopaperid = tinfopaperid;
  }

  public Long getTinfosuqid() {
    return tinfosuqid;
  }

  public void setTinfosuqid(Long tinfosuqid) {
    this.tinfosuqid = tinfosuqid;
  }

  @Override
  public String toString() {
    return "Testinfo{" +
            "tinfoid=" + tinfoid +
            ", tinfopaperid=" + tinfopaperid +
            ", tinfosuqid=" + tinfosuqid +
            '}';
  }
}
