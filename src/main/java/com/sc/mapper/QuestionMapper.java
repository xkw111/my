package com.sc.mapper;

import com.sc.bean.Question;

import java.util.List;

public interface QuestionMapper {
    //查询所有试题
    public List<Question> getAllQuestion();
    public List<Question> getAllQuestionByFenye(String page,String size);
    //修改试题
    public int modifyQuestion(Question question);
    //根据id集合删除试题
    public int deleteQuestionByList(List<String> list);
    //添加试题
    public int addQuestion(Question question);
    //一次添加多个试题对象
    public int addQuestionByList(List<Question> list);
}
