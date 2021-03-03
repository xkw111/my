package com.sc.bean;

import org.springframework.stereotype.Component;


public class User {     //用户表
    private Long id;       //用户id
    private Long telephone;  //用户联系方式
    private String name;   //账号
    private String password;  //密码
    private int roleid;   //角色id 0 1 2
    private int classid;  //所属班级
    private String photo;   //头像
    private int status;   //账号状态 0封禁 正常

    public User() {
    }

    public User(Long id, Long telephone, String name, String password, int roleid, int classid, String photo, int status) {
        this.id = id;
        this.telephone = telephone;
        this.name = name;
        this.password = password;
        this.roleid = roleid;
        this.classid = classid;
        this.photo = photo;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", telephone=" + telephone +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", roleid=" + roleid +
                ", classid=" + classid +
                ", photo='" + photo + '\'' +
                ", status=" + status +
                '}';
    }
}
