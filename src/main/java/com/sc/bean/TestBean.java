package com.sc.bean;

import java.util.List;

public class TestBean<T> {            //查询考试历史记录的分页
    private Integer pageIndex;   //当前页码
    private Integer pageSize;    //一页多少条记录
    private Integer totalCount;  //总记录数
    private Integer totalPage;   //总页数
    private List<T> beanList;    //分页数据

    //模糊查询的数据
    private String sjid;   //试卷id
    private String sjm;    //试卷名
    private String kscjl;  //考试成绩范围左
    private String kscjr;   //考试成绩范围右
    private String kskm;    //考试科目

    public TestBean() {
    }

    public TestBean(Integer pageIndex, Integer pageSize, Integer totalCount, Integer totalPage, List<T> beanList, String sjid, String sjm, String kscjl, String kscjr, String kskm) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.beanList = beanList;
        this.sjid = sjid;
        this.sjm = sjm;
        this.kscjl = kscjl;
        this.kscjr = kscjr;
        this.kskm = kskm;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }

    public String getSjid() {
        return sjid;
    }

    public void setSjid(String sjid) {
        this.sjid = sjid;
    }

    public String getSjm() {
        return sjm;
    }

    public void setSjm(String sjm) {
        this.sjm = sjm;
    }

    public String getKscjl() {
        return kscjl;
    }

    public void setKscjl(String kscjl) {
        this.kscjl = kscjl;
    }

    public String getKscjr() {
        return kscjr;
    }

    public void setKscjr(String kscjr) {
        this.kscjr = kscjr;
    }

    public String getKskm() {
        return kskm;
    }

    public void setKskm(String kskm) {
        this.kskm = kskm;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", beanList=" + beanList +
                ", sjid='" + sjid + '\'' +
                ", sjm='" + sjm + '\'' +
                ", kscjl='" + kscjl + '\'' +
                ", kscjr='" + kscjr + '\'' +
                ", kskm='" + kskm + '\'' +
                '}';
    }
}
