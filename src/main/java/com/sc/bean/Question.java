package com.sc.bean;


public class Question {   //题库表

  private Long qid;    //题目id
  private Integer qkid;     //题目所属科目Id
  private String title;      //题目
  private String answer;     //题目答案
  private String analysis;     //题目解析
  private String optiona;      //选项A
  private String optionb;      //选项B
  private String optionc;       //选项C
  private String optiond;      //选项D
  private Integer difficult;     //题目难度  1-5 数字越大难度越高

  public Question() {
  }

  public Question(Long qid, Integer qkid, String title, String answer, String analysis, String optiona, String optionb, String optionc, String optiond, Integer difficult) {
    this.qid = qid;
    this.qkid = qkid;
    this.title = title;
    this.answer = answer;
    this.analysis = analysis;
    this.optiona = optiona;
    this.optionb = optionb;
    this.optionc = optionc;
    this.optiond = optiond;
    this.difficult = difficult;
  }

  public Long getQid() {
    return qid;
  }

  public void setQid(Long qid) {
    this.qid = qid;
  }

  public Integer getQkid() {
    return qkid;
  }

  public void setQkid(Integer qkid) {
    this.qkid = qkid;
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

  public Integer getDifficult() {
    return difficult;
  }

  public void setDifficult(Integer difficult) {
    this.difficult = difficult;
  }

  @Override
  public String toString() {
    return "Question{" +
            "qid=" + qid +
            ", qkid=" + qkid +
            ", title='" + title + '\'' +
            ", answer='" + answer + '\'' +
            ", analysis='" + analysis + '\'' +
            ", optiona='" + optiona + '\'' +
            ", optionb='" + optionb + '\'' +
            ", optionc='" + optionc + '\'' +
            ", optiond='" + optiond + '\'' +
            ", difficult=" + difficult +
            '}';
  }
}
