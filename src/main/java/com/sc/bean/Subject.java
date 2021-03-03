package com.sc.bean;


public class Subject {     //科目表

  private Integer kid;     //科目id
  private String kname;    //科目名
  private Integer kstatus;    //科目状态 1正常 0暂停更新

  public Subject() {
  }

  public Subject(Integer kid, String kname, Integer kstatus) {
    this.kid = kid;
    this.kname = kname;
    this.kstatus = kstatus;
  }

  public Integer getKid() {
    return kid;
  }

  public void setKid(Integer kid) {
    this.kid = kid;
  }

  public String getKname() {
    return kname;
  }

  public void setKname(String kname) {
    this.kname = kname;
  }

  public Integer getKstatus() {
    return kstatus;
  }

  public void setKstatus(Integer kstatus) {
    this.kstatus = kstatus;
  }

  @Override
  public String toString() {
    return "Subject{" +
            "kid=" + kid +
            ", kname='" + kname + '\'' +
            ", kstatus=" + kstatus +
            '}';
  }
}
