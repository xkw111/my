package com.sc.bean;

import java.util.Date;

public class Pogo {
    private Long id;  //当前用户id

    private String name;//用户名

    private String phone;//手机号

    private String email;//邮箱

    private String status;//状态

    private String sex;//性别

    private String headPic;//头像

    private Long user2id;//好友id

    private Integer relation;//关系  1 好友  2 拉黑

    public Integer getRelation() {
        return relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public Long getUser2id() {
        return user2id;
    }

    public void setUser2id(Long user2id) {
        this.user2id = user2id;
    }
}
