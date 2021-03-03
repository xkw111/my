package com.sc.bean;


public class Relational {

  private Integer id;//主键id
  private Integer user1Id;//当前用户id
  private Integer user2Id;//好友id
  private Integer relation;//好友关系 1 朋友  2黑名单

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUser1Id() {
    return user1Id;
  }

  public void setUser1Id(Integer user1Id) {
    this.user1Id = user1Id;
  }

  public Integer getUser2Id() {
    return user2Id;
  }

  public void setUser2Id(Integer user2Id) {
    this.user2Id = user2Id;
  }

  public Integer getRelation() {
    return relation;
  }

  public void setRelation(Integer relation) {
    this.relation = relation;
  }
}
