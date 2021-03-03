package com.sc.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Admin implements Serializable {
    private Long id;  //id

    private String password;//密码

    private String name;//用户名

    private String phone;//手机号

    private String email;//邮箱

    private String status;//状态

    private Date createtime;//创建时间

    private String sex;//性别

    private Long roleid;//角色id

    private String headPic;//头像

    private Long operator;//操作人

    private Short classid;//班级

    private List<Relational> relational;//关系

    public List<Relational> getRelational() {
        return relational;
    }

    public void setRelational(List<Relational> relational) {
        this.relational = relational;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic == null ? null : headPic.trim();
    }

    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }

    public Short getClassid() {
        return classid;
    }

    public void setClassid(Short classid) {
        this.classid = classid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", password=").append(password);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", status=").append(status);
        sb.append(", createtime=").append(createtime);
        sb.append(", sex=").append(sex);
        sb.append(", roleid=").append(roleid);
        sb.append(", headPic=").append(headPic);
        sb.append(", operator=").append(operator);
        sb.append(", classid=").append(classid);
        sb.append("]");
        return sb.toString();
    }
}