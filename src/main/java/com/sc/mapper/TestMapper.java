package com.sc.mapper;

import com.sc.bean.*;

import java.util.List;

public interface TestMapper {
    //随机生成试卷
    public void tp();
    //返回用户所选科目的Id
    public int getKem(String k);
    //根据科目id随机查询5道题目
    public List<Question> getQuest(Integer id);
    //将试卷信息插入试卷表
    public int insertInToSJB(Testpage testpage);
    //将试卷题目写入试卷详情表
    public int insertintotestinfotable(Testinfo testinfo);
    //将考试信息写入表
    public int setEaxmInfo(Examinfo examinfo);
    //写入试卷成绩表
    public int setTotalScore(Totalscore totalscore);
    //根据用户Id查找考试记录表
    public List<Examinfo> getExamInfoById(String id);
    //根据用户id查找试卷总分表
    public List<Totalscore> getTotalScoreById(String id);
    //通过一组试卷id查找一组试卷对象
    public List<Testpage> getAllTestpageByList(List<Long> list);
    public List<PageVo> getPageVo(String pageIndex,String pageSize,String sjid,String sjm,String kscjl,String kscjr,String kskm,String userid);
    //获取到总记录数
    public int getAllPageVoNumber(String pageIndex,String pageSize,String sjid,String sjm,String kscjl,String kscjr,String kskm,String userid);
    //查看考过的试卷信息
    public List<TestHisInfo> getTestHisInfo(String paperid);
}
