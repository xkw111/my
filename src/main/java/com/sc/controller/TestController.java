package com.sc.controller;

import com.sc.bean.*;
import com.sc.converter.DateConverter;
import com.sc.service.TestService;
import com.sun.corba.se.impl.orb.ParserTable;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class TestController {   //处理请求考试的处理器
    @Autowired
    private TestService testService;

     //用户点击了开始考试
    @RequestMapping("/examing/{kemu}")
    public String begin(@PathVariable("kemu") String kemu, HttpSession session)
    {
        //先查询用户选的是哪门科目的考试
        int kemu1 = testService.getKemu(kemu);
        //根据科目Id去选择查询题目
        List<Question> quest = testService.getQuest(kemu1);
        //将题目集合存入session
        session.setAttribute("question",quest);
        //System.out.println(quest);
        /*
          1、科目表： id 科目名 状态
          2、题目表： id 科目id 题目  答案   解析   选项A 项目B 选项C 选项D
          3、 试卷表：id  试卷名  科目  考试开始时间  考试时长  总分  选择题数量 选择题分值
          4、试卷详情表： id  试卷ID  题目id
          5、考试记录表： id  用户id   试卷id    题目id   用户答案  成绩
          6、试卷总分表  id 用户Id 试卷id 试卷总成绩
          7.公告表

        * */
        //用查询到的试题插入试卷表，id相同则为同一试卷
        //   1.试卷表的id是当前时间戳
        long ttid = new Date().getTime();                 //--------------试卷id
        //   2.试卷名随机生成
        Admin user = (Admin) session.getAttribute("user");
        String paperName=user.getName()+""+ttid;             //------------试卷名
        //  3.科目名是前端传来的
        String kemuName=kemu;                  //----------------科目名
        //  4.考试开始时间是当前系统时间
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String strDate = format.format(date);                    //-----------------考试开始时间


        //  5.考试时长默认1min 单位是分钟
        Integer ti=1;                                    //---------------考试时长默认1min
        //  6.总分默认是100
        Integer zongfen=100;                              //----------------总分默认100分
        //  7.选择题数量
        Integer sum=quest.size();                             //----------------选择题数量
        //  8.每道题多少分
        Integer sco=zongfen/sum;                        //-----------------每题多少分
        //将试卷信息封装成对象插入试卷表
        Testpage testpage=new Testpage(ttid,paperName,kemuName,strDate ,zongfen,sum,sco,ti);
        //将当前试卷对象存入session
        session.setAttribute("testpage",testpage);
        System.out.println("待插入试卷表的对象是:"+testpage);

        int i = testService.insertInToSJB(testpage);


        //将试卷题目写入试卷详情表
        for (Question question : quest) {
            Testinfo testinfo=new Testinfo();
            testinfo.setTinfopaperid(ttid);
            testinfo.setTinfosuqid(question.getQid());
            int j = testService.insertintotestinfotable(testinfo);
            System.out.println("要写入试卷详情表的题目是:"+testinfo);
            System.out.println(j+"!!!");
        }

        //重定向到前端examing.jsp
        return "redirect:/admin/examing.jsp";
    }
    @ResponseBody
    @RequestMapping("/paperResult")
    public String paperResult(@RequestBody Map<String, String> map,HttpSession session)
    {
        /*
        * 1、科目表： id 科目名 状态
          2、题目表： id 科目id 题目  答案   解析   选项A 项目B 选项C 选项D
          3、 试卷表：id  试卷名  科目  考试开始时间  考试时长  总分  选择题数量 选择题分值
          4、试卷详情表： id  试卷ID  题目id
          5、考试记录表： id  用户id   试卷id    题目id   用户答案  成绩
          6、试卷总分表  id 用户Id 试卷id 试卷总成绩
        * */
        /*
          考试记录表
        * private Integer eid;    //id
          private Integer euserid;    //用户Id
          private Integer paperid;    //试卷id
          private Integer eqid;      //题目id
          private String euseranswer;    //用户答案
          private Integer escore;     //成绩
        * */
        List<Question> question = (List<Question>) session.getAttribute("question");
        //当前用户
        Admin user = (Admin) session.getAttribute("user");
        //当前试卷
        Testpage testpage = (Testpage) session.getAttribute("testpage");
        //每道题多少分
        Integer singlescore = testpage.getTpsinglescore();
        //遍历map集合，统分
        //System.out.println(map);
        int sc=0;   //总分
        int a=0;
        //准备集合保存考试记录表每条记录对象
        List<Examinfo> list=new ArrayList<Examinfo>();
        for (Question ques : question) {
            //获取到一个题目的id
            Long qid = ques.getQid();
            System.out.println("题目id:"+qid);
            //获取到这个题目的答案
            String answer = ques.getAnswer();
            System.out.println("题目答案:"+answer);
            //找到用户传来的这道题目的答案
            String s = map.get(String.valueOf(qid));
            System.out.println("用户答案:"+s);
            if(answer.equals(s))
            {
                //答案相同，则加分
                sc+=singlescore;
                a=singlescore;
            }
            System.out.println("用户总分是:"+sc);
            //添加记录进考试记录表
            //  5、考试记录表： id  用户id   试卷id    题目id   用户答案  成绩
            Examinfo examinfo=new Examinfo(null,user.getId(),testpage.getTpid(),qid,s,a);
            list.add(examinfo);
            a=0;

            // System.out.println(ques);
//            if(ques.getAnswer().equals(map.get(ques.getQid())))
//            {
//                sc+=20;
//                System.out.println("用户答案是:"+map.get(ques.getQid())+"正确答案是:"+ques.getAnswer());
//            }
        }
        //将集合的所有记录写入数据库
        for (Examinfo examinfo : list) {
             testService.setEaxmInfo(examinfo);
        }
        //添加记录进 6、试卷总分表  id 用户Id 试卷id 试卷总成绩
        Totalscore totalscore=new Totalscore(null,user.getId(),testpage.getTpid(),sc);
        //将对象写入数据库
        testService.setTotalScore(totalscore);
        //将成绩返回前端
        return sc+"";
    }


    //考试历史记录页面带分页的查询  需要接收:查询第几页，一页显示多少条记录 ，5个查询框的值                         一共有多少条记录 ，一共有多少页
    /*
    *  private Integer pageIndex;   //当前页码
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
    * */

    @RequestMapping("/examRecord")
    public String examRecord(@RequestParam(value = "pageIndex",defaultValue = "1")String pageIndex,     //默认当前页码1
                             @RequestParam(value = "pageSize",defaultValue = "10")String pageSize,        //默认一页显示10条
                             String sjid,                                    //前端传来的模糊查询试卷id
                             String sjm,                        //前端传来的模糊查询试卷名
                             String kscjl,                    //前端传来的考试范围左
                             String kscjr,                    //前端传来的考试范围右
                             String kskm,                   //前端传来的考试科目
                             HttpSession session)
    {
        if(sjid==null)
            sjid="";
        if(sjm==null)
            sjm="";
        if(kscjl==null)
            kscjl="";
        if(kscjr==null)
            kscjr="";
        if(kskm==null)
            kskm="";
        selectHistoryWithFenYe(pageIndex,pageSize,sjid,sjm,kscjl,kscjr,kskm,session);
        return "redirect:admin/examHistory.jsp";
    }


    @ResponseBody
    @RequestMapping("/examHistory")
    public void selectHistoryWithFenYe(@RequestParam(value = "pageIndex",defaultValue = "1")String pageIndex,     //默认当前页码1
                                          @RequestParam(value = "pageSize",defaultValue = "10")String pageSize,        //默认一页显示10条
                                          String sjid,                                    //前端传来的模糊查询试卷id
                                         String sjm,                        //前端传来的模糊查询试卷名
                                         String kscjl,                    //前端传来的考试范围左
                                         String kscjr,                    //前端传来的考试范围右
                                         String kskm,                   //前端传来的考试科目
                                         HttpSession session
                                         )
    {
        System.out.println("默认当前页码"+pageIndex);
        System.out.println("默认一页显示10条"+pageSize);
        System.out.println("前端传来的模糊查询试卷id"+sjid);
        System.out.println("前端传来的模糊查询试卷名"+sjm);
        System.out.println("前端传来的考试范围左"+kscjl);
        System.out.println("前端传来的考试范围右"+kscjr);
        System.out.println("前端传来的考试科目"+kskm);
        System.out.println("当前用户id是"+((Admin)session.getAttribute("user")).getId());
        if(kscjl=="")
            kscjl="0";
        if(kscjr=="")
            kscjr="100";
        if(kskm=="")
            kskm="java";
        //将信息发往mapper查询
//        public List<PageVo> getPageVo(String pageIndex,String pageSize,String sjid,String sjm,String kscjl,String kscjr,String kskm,String userid);
        List<PageVo> pageINfo = testService.getPageVo(pageIndex, pageSize, sjid, sjm, kscjl, kscjr, kskm, String.valueOf(((Admin) session.getAttribute("user")).getId()));
        System.out.println("查询得到的pageInfo是:"+pageINfo);
        //获取到总记录数
        int num = testService.getAllPageVoNumber(pageIndex, pageSize, sjid, sjm, kscjl, kscjr, kskm, String.valueOf(((Admin) session.getAttribute("user")).getId()));
        System.out.println("获得的记录总数是:"+num);
        //总页数
        int ceil = (int)Math.ceil(Float.valueOf(num) / Float.valueOf(pageSize));
        System.out.println("总页数是:"+ceil);
        //将查询到的记录封装成Testbean对象
        TestBean<PageVo> testBean=new TestBean<PageVo>(Integer.valueOf(pageIndex),Integer.valueOf(pageSize),num,ceil,pageINfo,sjid,sjm,kscjl,kscjr,kskm);
        //存入session
        session.setAttribute("pageInfo",testBean);
        System.out.println("后端请求完成后，放入session的值是:"+testBean);
           }









//
//    //考试历史页面ajax请求,
//    @ResponseBody
//    @RequestMapping("/examHistory")
//    public void selectExamHistory(String id,HttpSession session)
//    {
//        System.out.println("前端ajax传入的用户id是:"+id);
//        //根据id查找用户的考试信息，存入session
//        /*
//        * 1、科目表： id 科目名 状态
//          2、题目表： id 科目id 题目  答案   解析   选项A 项目B 选项C 选项D
//          3、试卷表：试卷id  试卷名  科目  考试开始时间  考试时长  总分  选择题数量 选择题分值
//          4、试卷详情表： 试卷详情表id  试卷ID  题目id
//          5、考试记录表： 考试记录表id  用户id   试卷id    题目id   用户答案  成绩          ---（1
//          6、试卷总分表  试卷总分记录表id 用户Id 试卷id 试卷总成绩
//        * */
//        //先根据用户id找试卷总分表,获取试卷id和总成绩
//        List<Totalscore> totalScore = testService.getTotalScoreById(id);
//        //通过获取到的试卷id查找试卷表集合
//        List<Long> list=new ArrayList<Long>();
//        //6、试卷总分表id 用户Id 试卷id 试卷总成绩
//        for (Totalscore totalscore : totalScore) {
//            list.add(totalscore.getPaperid());
//            System.out.println("获取到的试卷id有:"+totalscore.getPaperid());
//        }
//        //将试卷Id集合发往mapper查询
//        List<Testpage> allTestpage = testService.getAllTestpageByList(list);
//        for (Testpage testpage : allTestpage) {
//            //3、试卷表：试卷表id  试卷名  科目  考试开始时间  考试时长  总分  选择题数量 选择题分值
//            System.out.println("查询到的试卷表:"+testpage);
//        }
//        //封装成对象存入session
//        List<PageVo> pageVos=new ArrayList<PageVo>();
//        //用户Id 试卷id 试卷总成绩     试卷名  科目  考试开始时间  考试时长  总分
//        for (Totalscore totalscore : totalScore) {
//            System.out.println(totalscore.getPaperid()+"!!!!!!!!!");
//            for (Testpage testpage : allTestpage) {
//                System.out.println(testpage.getTpid());
//                //if(totalscore.getPaperid()==testpage.getTpid())    这样判断不行，也存在一个常量池的概念 -128~127
//                if(totalscore.getPaperid().equals(testpage.getTpid()))
//                {
//                    PageVo pageVo=new PageVo(totalscore.getUserid(),totalscore.getPaperid(),totalscore.getAllscore(),testpage.getTpname(),testpage.getTpsub(),testpage.getTpbegintime(),testpage.getTpsj(),testpage.getTpscore());
//                    pageVos.add(pageVo);
//                }
//            }
//            System.out.println("_+_+_+_+_+_+_+__+");
//        }
//        System.out.println("pageVos的长度是:"+pageVos.size());
//        //测试封装结果
//        for (PageVo pageVo : pageVos) {
//            System.out.println("=========================");
//            System.out.println(pageVo);
//        }
//        //将集合存入session
//        session.setAttribute("pageVo",pageVos);
//    }

    //用户查看试卷详情
    @RequestMapping("/seePaper/{paperid}")
    public String seepage(@PathVariable("paperid") String paperid,HttpSession session)
    {
//        1、科目表： id 科目名 状态
//        2、题目表： id 科目id 题目  答案   解析   选项A 项目B 选项C 选项D
//        3、 试卷表：id  试卷名  科目  考试开始时间  考试时长  总分  选择题数量 选择题分值
//        4、试卷详情表： id  试卷ID  题目id
//        5、考试记录表： id  用户id   试卷id    题目id   用户答案  成绩
//        6、试卷总分表  id 用户Id 试卷id 试卷总成绩
//        7.公告表
         //       4、试卷详情表： id  试卷ID  题目id
        //        2、题目表： id 科目id 题目  答案   解析   选项A 项目B 选项C 选项D       question表
        //        5、考试记录表： id  用户id   试卷id    题目id   用户答案  成绩          examinfo表
        //题目 题目答案 解析 题目选项       用户答案 该题得分
        //select examinfo.euseranswer useranswer,examinfo.escore escore,question.title title,question.answer answer,question.analysis analysis,question.optiona optiona,question.optionb optionb,question.optionc optionc,question.optiond optiond from question,examinfo where question.qid=examinfo.eqid and examinfo.paperid=1610722577010
        System.out.println("前端查看试卷的试卷id是:"+paperid);
        List<TestHisInfo> testHisInfo = testService.getTestHisInfo(paperid);
        //将试卷信息存入session
        session.setAttribute("testinfo",testHisInfo);
        //重定向到试卷查看页面
        return "redirect:/admin/paperinfo.jsp";
    }

    //用户查看试卷详情
    @RequestMapping("/downLoadPaper/{paperid}")
    public String downloadpage(@PathVariable("paperid") String paperid,HttpSession session)
    {
//        1、科目表： id 科目名 状态
//        2、题目表： id 科目id 题目  答案   解析   选项A 项目B 选项C 选项D
//        3、 试卷表：id  试卷名  科目  考试开始时间  考试时长  总分  选择题数量 选择题分值
//        4、试卷详情表： id  试卷ID  题目id
//        5、考试记录表： id  用户id   试卷id    题目id   用户答案  成绩
//        6、试卷总分表  id 用户Id 试卷id 试卷总成绩
//        7.公告表
        //       4、试卷详情表： id  试卷ID  题目id
        //        2、题目表： id 科目id 题目  答案   解析   选项A 项目B 选项C 选项D       question表
        //        5、考试记录表： id  用户id   试卷id    题目id   用户答案  成绩          examinfo表
        //题目 题目答案 解析 题目选项       用户答案 该题得分
        //select examinfo.euseranswer useranswer,examinfo.escore escore,question.title title,question.answer answer,question.analysis analysis,question.optiona optiona,question.optionb optionb,question.optionc optionc,question.optiond optiond from question,examinfo where question.qid=examinfo.eqid and examinfo.paperid=1610722577010
        System.out.println("前端查看试卷的试卷id是:"+paperid);
        List<TestHisInfo> testHisInfo = testService.getTestHisInfo(paperid);
        //将试卷信息存入session
        session.setAttribute("testinfo",testHisInfo);
        //重定向到试卷查看页面
        return "redirect:/admin/downLoadPaper.jsp";
    }





}
