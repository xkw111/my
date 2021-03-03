package com.sc.bean;

//班级表
public class Bj {
  private Long id;    //班级id
  private String bjname;     //班级名

  public Bj() {
  }

  public Bj(Long id, String bjname) {
    this.id = id;
    this.bjname = bjname;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getBjname() {
    return bjname;
  }

  public void setBjname(String bjname) {
    this.bjname = bjname;
  }

  @Override
  public String toString() {
    return "Bj{" +
            "id=" + id +
            ", bjname='" + bjname + '\'' +
            '}';
  }
}
