package com.sc.bean;

public class Pogo1 {
    private Long userid;//用户id
    private String name;//用户名
    private String headPic;//头像
    private String sex;//性别
    private String rel;//附言

    public Long getRead() {
        return read;
    }

    public void setRead(Long read) {
        this.read = read;
    }

    private Long read;//请求  0 未读  1 已同意  2  拒绝

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }
}
