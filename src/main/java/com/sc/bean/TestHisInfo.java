package com.sc.bean;

public class TestHisInfo {
    private String useranswer;    //用户答案
    private Integer escore;     //用户该题成绩

    private String title;      //题目
    private String answer;     //题目答案
    private String analysis;     //题目解析
    private String optiona;      //选项A
    private String optionb;      //选项B
    private String optionc;       //选项C
    private String optiond;      //选项D

    public TestHisInfo() {
    }

    public TestHisInfo(String useranswer, Integer escore, String title, String answer, String analysis, String optiona, String optionb, String optionc, String optiond) {
        this.useranswer = useranswer;
        this.escore = escore;
        this.title = title;
        this.answer = answer;
        this.analysis = analysis;
        this.optiona = optiona;
        this.optionb = optionb;
        this.optionc = optionc;
        this.optiond = optiond;
    }

    public String getUseranswer() {
        return useranswer;
    }

    public void setUseranswer(String useranswer) {
        this.useranswer = useranswer;
    }

    public Integer getEscore() {
        return escore;
    }

    public void setEscore(Integer escore) {
        this.escore = escore;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getOptiona() {
        return optiona;
    }

    public void setOptiona(String optiona) {
        this.optiona = optiona;
    }

    public String getOptionb() {
        return optionb;
    }

    public void setOptionb(String optionb) {
        this.optionb = optionb;
    }

    public String getOptionc() {
        return optionc;
    }

    public void setOptionc(String optionc) {
        this.optionc = optionc;
    }

    public String getOptiond() {
        return optiond;
    }

    public void setOptiond(String optiond) {
        this.optiond = optiond;
    }

    @Override
    public String toString() {
        return "TestHisInfo{" +
                "useranswer='" + useranswer + '\'' +
                ", escore=" + escore +
                ", title='" + title + '\'' +
                ", answer='" + answer + '\'' +
                ", analysis='" + analysis + '\'' +
                ", optiona='" + optiona + '\'' +
                ", optionb='" + optionb + '\'' +
                ", optionc='" + optionc + '\'' +
                ", optiond='" + optiond + '\'' +
                '}';
    }
}
