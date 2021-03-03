package com.sc.service.impl;

import com.sc.bean.*;
import com.sc.mapper.TestMapper;
import com.sc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;

    public void tp() {
    }

    public int getKemu(String k) {
        int kem = testMapper.getKem(k);
        return kem;
    }

    public List<Question> getQuest(Integer id) {
        List<Question> quest = testMapper.getQuest(id);
        return quest;
    }

    public int insertInToSJB(Testpage testpage) {
        System.out.println("待插入的testpage对象:"+testpage);
        int i = testMapper.insertInToSJB(testpage);
        return i;
    }

    public int insertintotestinfotable(Testinfo testinfo) {
        System.out.println("待插入的testinfo对象:"+testinfo);
        int insertintotestinfotable = testMapper.insertintotestinfotable(testinfo);
        return insertintotestinfotable;
    }

    public int setEaxmInfo(Examinfo examinfo) {
        testMapper.setEaxmInfo(examinfo);
        return 0;
    }

    public int setTotalScore(Totalscore totalscore) {
        testMapper.setTotalScore(totalscore);
        return 0;
    }

    public List<Examinfo> getExamInfoById(String id) {
        List<Examinfo> examInfoById = testMapper.getExamInfoById(id);
        return examInfoById;
    }

    public List<Totalscore> getTotalScoreById(String id) {
        List<Totalscore> totalScoreById = testMapper.getTotalScoreById(id);
        return totalScoreById;
    }

    public List<Testpage> getAllTestpageByList(List<Long> list) {
        List<Testpage> allTestpageByList = testMapper.getAllTestpageByList(list);
        return allTestpageByList;
    }

    public List<PageVo> getPageVo(String pageIndex, String pageSize, String sjid, String sjm, String kscjl, String kscjr, String kskm, String userid) {
        List<PageVo> pageVo = testMapper.getPageVo(pageIndex, pageSize, sjid, sjm, kscjl, kscjr, kskm, userid);
        return pageVo;
    }

    public int getAllPageVoNumber(String pageIndex, String pageSize, String sjid, String sjm, String kscjl, String kscjr, String kskm, String userid) {
        int allPageVoNumber = testMapper.getAllPageVoNumber(pageIndex, pageSize, sjid, sjm, kscjl, kscjr, kskm, userid);
        return allPageVoNumber;
    }

    public List<TestHisInfo> getTestHisInfo(String paperid) {
        List<TestHisInfo> testHisInfo = testMapper.getTestHisInfo(paperid);
        return testHisInfo;
    }
}
