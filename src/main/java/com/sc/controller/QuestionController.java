package com.sc.controller;

import com.sc.bean.Question;
import com.sc.service.QuestionService;
import com.sc.util.WDWUtil;
import org.apache.ibatis.annotations.Lang;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping("/allQuestions")
    public  @ResponseBody Map<String,Object>   getAllQuestions(HttpSession session,String page,String size)
    {
        System.out.println("前端传来的page"+page);
        System.out.println("前端传来的size:"+size);
        //查询出所有试题
        List<Question> allQuestion = questionService.getAllQuestion();
        //根据分页查询试题
        List<Question> allQuestionByFenye = questionService.getAllQuestionByFenye(page,size);
        //准备一个map集合
        Map<String,Object> result=new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count", allQuestion.size());
        Object[] objects = allQuestionByFenye.toArray();
        result.put("data",objects);
        return result;
//        System.out.printl/admin/modifyQuestion.jspn("查询出来的试题数量是:"+allQuestion.size());
//        for (Question question : allQuestion) {
//            System.out.println(question);
//        }
        //将查询到的试题信息存入session
       // session.setAttribute("question",allQuestion);
//        return "redirect:/admin/modifyQuestion.jsp";

    }

    //修改试题的某一条记录
    @ResponseBody
    @RequestMapping("/modifyQuestion")
    public String modifyQuestion(@RequestBody Map<String,String> map)
//    public String modifyQuestion(String qid,String qkid,String title,String answer,String analysis,String optiona,String optionb,String optionc,String optiond,String difficult)
    {
        System.out.println(map);
        Question question=new Question();
        question.setQid(Long.valueOf(map.get("qid")));
        question.setQkid(Integer.valueOf(map.get("qkid")));
        question.setTitle(map.get("title"));
        question.setAnswer(map.get("answer"));
        question.setAnalysis(map.get("analysis"));
        question.setOptiona(map.get("optiona"));
        question.setOptionb(map.get("optionb"));
        question.setOptionc(map.get("optionc"));
        question.setOptiond(map.get("optiond"));
        question.setDifficult(Integer.valueOf(map.get("difficult")));
        System.out.println(question);
        //发往后台修改
        int i = questionService.modifyQuestion(question);
        System.out.println("后台修改返回的结果是:"+i);
        /*
        *  private Long qid;    //题目id
  private Integer qkid;     //题目所属科目Id
  private String title;      //题目
  private String answer;     //题目答案
  private String analysis;     //题目解析
  private String optiona;      //选项A
  private String optionb;      //选项B
  private String optionc;       //选项C
  private String optiond;      //选项D
  private Integer difficult;     //题目难度  1-5 数字越大难度越高
        * */;
        return ""+i;
    }

    //删除试题
    @ResponseBody
    @RequestMapping("/deleteQuestion")
    public String deleteQuestion(@RequestBody List<Question> list)
//    public String modifyQuestion(String qid,String qkid,String title,String answer,String analysis,String optiona,String optionb,String optionc,String optiond,String difficult)
    {
        System.out.println("进来快乐??????");
        List<String> list1=new ArrayList<String>();
        for (Question question : list) {
            System.out.println(question);
            list1.add(question.getQid().toString());
        }
        //将id集合发往后端删除
        int i = questionService.deleteQuestionByList(list1);
        return ""+i;
    }
    //管理员添加试题
    @ResponseBody
    @RequestMapping("/addQuestion")
//    public String addQuestion(String qkid, String title, String answer, String analysis, String optiona,String optionb,String optionc,String optiond,String difficult)
//    public String addQuestion(@RequestBody Map<String,String> map)
    public String addQuestion(@RequestBody Question question)
    {
        //qkid=1&title=%E6%B5%8B%E8%AF%95&answer=a&analysis=aa&optiona=%E5%95%8A&optionb=%E9%94%95&optionc=%E9%98%BF&optiond=%E5%90%96&difficult=1
        System.out.println("进来了?????");
        System.out.println(question);
        //将前端传来的对象传日mapper添加
        int i = questionService.addQuestion(question);
//        Set<Map.Entry<String, String>> entries = map.entrySet();
//        for (Map.Entry<String, String> entry : entries) {
//            System.out.println(entry.getKey()+entry.getValue());
//        }
//        System.out.println("用户添加的试题信息是:"+qkid+title+answer+analysis+optiona+optionb+optionc+optiond+difficult);
        return ""+i;
    }

    @RequestMapping("/addQuestion1")
    public String addQuest()
    {
        return "/admin/addquestion.jsp";
    }

    //批量上传试题
    @RequestMapping("/plsc")
    @ResponseBody
    public  Map<String,Object> plsc(MultipartFile file)
    {
        Map<String,Object> map=new HashMap<String, Object>();
        String msg="上传成功";
        System.out.println("进来快乐！！！");
        //先判断文件是否为空
        if(file==null)
        {
            msg="文件为空!";
            map.put("msg",msg);
            return map;
        }
        //获取文件名
        String name=file.getOriginalFilename();
        //进一步判断文件是否为空，(判断其大小是否为0或名称是否为null)验证文件名是否合格
        long size=file.getSize();
        if(name==null || "".equals(name)&&size==0 && !WDWUtil.validateExcel(name))
        {
            msg="文件格式不正确";
            map.put("msg",msg);
            return map;
        }
        //开始读取excel
        Workbook hssfWorkbook=null;
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            //创建HSSFWorkbook对象
            //创建xssfWorkBook对象
            if(name.endsWith(".xls"))
            {
                hssfWorkbook=new HSSFWorkbook(inputStream);
            }else if(name.endsWith(".xlsx"))
            {
               hssfWorkbook=new XSSFWorkbook(inputStream);
            }

//            HSSFWorkbook hssfWorkbook=new HSSFWorkbook(inputStream);
            //得到一个工作表
            Sheet sheet=hssfWorkbook.getSheetAt(0);
            //先获取表头信息
            Row rowHead = sheet.getRow(0);
            System.out.println("表头有几列:"+rowHead.getPhysicalNumberOfCells());
            //获取数据的总行数
            int rowNum = sheet.getLastRowNum();
            //要获得的属性
            Long qid;
            Integer qkid;     //题目所属科目Id
            String title;      //题目
            String answer;     //题目答案
            String analysis;     //题目解析
            String optiona;      //选项A
            String optionb;      //选项B
            String optionc;       //选项C
            String optiond;      //选项D
            Integer difficult;     //题目难度  1-5 数字越大难度越高
            //先准备集合
            List<Question> list=new ArrayList<Question>();
            //获得所有数据
            for(int i=1;i<=rowNum;i++)
            {
                Question question=new Question();
                //获得第i行数据
                Row row=sheet.getRow(i);
                //获得每一列的数据
                Cell cell0 = row.getCell((short) 0);
                qid=(long) cell0.getNumericCellValue();
                question.setQid(qid);

                Cell cell = row.getCell((short) 1);
                qkid=(int) cell.getNumericCellValue();
                question.setQkid(qkid);

                Cell cell1 = row.getCell((short) 2);
                title=cell1.getStringCellValue().toString();
                question.setTitle(title);

                Cell cell2 = row.getCell((short) 3);
                answer=cell2.getStringCellValue().toString();
                question.setAnswer(answer);

                Cell cell3 = row.getCell((short) 4);
                analysis=cell3.getStringCellValue().toString();
                question.setAnalysis(analysis);

                Cell cell4 = row.getCell((short) 5);
                optiona=cell4.getStringCellValue().toString();
                question.setOptiona(optiona);

                Cell cell5 = row.getCell((short) 6);
                optionb=cell5.getStringCellValue().toString();
                question.setOptionb(optionb);

                Cell cell6 = row.getCell((short) 7);
                optionc=cell6.getStringCellValue().toString();
                question.setOptionc(optionc);

                Cell cell7 = row.getCell((short) 8);
                optiond=cell7.getStringCellValue().toString();
                question.setOptiond(optiond);

                Cell cell8 = row.getCell((short) 9);
                difficult=(int) cell8.getNumericCellValue();
                question.setDifficult(difficult);

                list.add(question);
            }
            //检查对象是否正确
            for (Question question : list) {
                System.out.println(question+"!!!!!!!!!!!!!!!!!!!!!!!");
            }
            System.out.println("==============================================================");
            //将所有对象发往mapper存储
            questionService.addQuestionByList(list);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        map.put("msg",msg);
        return map;
    }

}
