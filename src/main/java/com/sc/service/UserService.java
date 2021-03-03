package com.sc.service;

import com.github.pagehelper.PageInfo;
import com.sc.bean.*;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    public List<Pogo> getUsers(Long id,Long relation);//查询当前用户的所有好友信息

    public List<Pogo> getUsersByNameOrRelation(Long id,String name,Integer relation);//模糊查询

    public int delectRelationById(Long id,Long userid);//根据id删除好友

    public List<Admin> getUsersByPhone(Long id,String phone);//根据手机号查找用户

    //根据name查找是否有次用户
    public int selectUser(String name);
    //注册
    public int insertIntoAdmin(Admin admin);

    public Relational getRelation(Long user1id, Long user2id);//根据用户ID查关系

    public int addRequestCode(Long userid,Long addid,String rel);//当前用户向其他用户发送好友请求

    public int deleteUserByArray(Long id,String[] user2id);//根据一组id删除好友

    public List<Pogo1> getRequests(Long id);//查看请求

    public int agreeRelation(Long user1id,Long user2id);//同意好友请求

    public int upadteRelation(Long id,Long addid,Long read);//根据当前用户id和请求者id修改消息状态

    public int upadteRelationById(Long id,Long user2id,Long relation);//根据当前用户id和用户id修改好友关系

    public Relational getRelationById(Long id,Long user2id);//根据当前用户id和用户id查好友关系

    public Admin getIdByName(String name);//通过姓名获取用户

    public PageInfo<Email> emaillist(Integer pageNum, Integer pageSize,String accept);//分页

    public int addEmail(Email email);//添加记录

    public int deleteEmail(String send,String accept);//根据两个名字删除记录

    public int updateReadStatus(String state,String send,String accept);//修改状态
}
