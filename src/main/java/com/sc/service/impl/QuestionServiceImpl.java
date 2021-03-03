package com.sc.service.impl;

import com.sc.bean.Question;
import com.sc.mapper.QuestionMapper;
import com.sc.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    public List<Question> getAllQuestion() {
        List<Question> allQuestion = questionMapper.getAllQuestion();
        return allQuestion;
    }

    public List<Question> getAllQuestionByFenye(String page, String size) {
        List<Question> allQuestionByFenye = questionMapper.getAllQuestionByFenye(page, size);
        return allQuestionByFenye;
    }

    public int modifyQuestion(Question question) {
        int i = questionMapper.modifyQuestion(question);
        return i;
    }

    public int deleteQuestionByList(List<String> list) {
        int i = questionMapper.deleteQuestionByList(list);
        return i;
    }

    public int addQuestion(Question question) {
        int i = questionMapper.addQuestion(question);
        return i;
    }

    public int addQuestionByList(List<Question> list) {
        int i = questionMapper.addQuestionByList(list);
        return i;
    }
}
