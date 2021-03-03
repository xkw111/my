package com.sc.bean;


public class Notice {     //公告表
  private Long nid;     //公告id
  private String ntitle;      //公告标题
  private String ntime;     //公告发布时间
  private String ncontent;     //公告内容
  private Long nuid;         //公告发布人id

  public Notice() {
  }

  public Notice(Long nid, String ntitle, String ntime, String ncontent, Long nuid) {
    this.nid = nid;
    this.ntitle = ntitle;
    this.ntime = ntime;
    this.ncontent = ncontent;
    this.nuid = nuid;
  }

  public Long getNid() {
    return nid;
  }

  public void setNid(Long nid) {
    this.nid = nid;
  }

  public String getNtitle() {
    return ntitle;
  }

  public void setNtitle(String ntitle) {
    this.ntitle = ntitle;
  }

  public String getNtime() {
    return ntime;
  }

  public void setNtime(String ntime) {
    this.ntime = ntime;
  }

  public String getNcontent() {
    return ncontent;
  }

  public void setNcontent(String ncontent) {
    this.ncontent = ncontent;
  }

  public Long getNuid() {
    return nuid;
  }

  public void setNuid(Long nuid) {
    this.nuid = nuid;
  }

  @Override
  public String toString() {
    return "Notice{" +
            "nid=" + nid +
            ", ntitle='" + ntitle + '\'' +
            ", ntime='" + ntime + '\'' +
            ", ncontent='" + ncontent + '\'' +
            ", nuid=" + nuid +
            '}';
  }
}
