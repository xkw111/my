package com.sc.mapper;

import com.sc.bean.Admin;
import com.sc.bean.Pogo;
import com.sc.bean.User;
import com.sc.bean.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    public List<Pogo> getUsers(Long id,Long relation);//查询当前用户的好友列表

    public List<Pogo> getUsersByNameOrRelation(Long id,String name,Integer relation);//模糊查询

    public int delectRelationById(Long id,Long userid);//根据id删除好友

    public int addRelationByPhone(Long id,String phone);//根据手机号添加好友

    //根据name查找是否有次用户
    public int selectUser(String name);

    //注册
    public int insertIntoAdmin(Admin admin);

    public List<Admin> getUsersByPhone(Long id,String phone);//根据手机号查找用户

    public Relational getRelation(Long user1id,Long user2id);//根据用户ID查关系

    public int addRequestCode(Long userid,Long addid,String rel);//当前用户向其他用户发送好友请求

    public int deleteUserByArray(Long id,@Param("list") String[] list);//根据一组id删除好友

    public List<Pogo1> getRequests(Long id);//查看请求

    public int agreeRelation(Long user1id,Long user2id);//同意好友请求

    public int upadteRelation(Long id,Long addid,Long read);//根据当前请求者id和用户id修改消息状态

    public int upadteRelationById(Long id,Long user2id,Long relation);//根据当前用户id和用户id修改好友关系

    public Relational getRelationById(Long id,Long user2id);//根据当前用户id和用户id查好友关系

    public Admin getIdByName(String name);//通过姓名获取用户id

}
