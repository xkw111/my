package com.sc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.*;
import com.sc.mapper.EmailMapper;
import com.sc.mapper.UserMapper;
import com.sc.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EmailMapper emailMapper;
    public List<Pogo> getUsers(Long id,Long relation) {

        List<Pogo> userslist = userMapper.getUsers(id,relation);

        return userslist;
    }

    public List<Pogo> getUsersByNameOrRelation(Long id,String name, Integer relation) {
        List<Pogo> userlist = userMapper.getUsersByNameOrRelation(id,name, relation);
        return userlist;
    }

    public int delectRelationById(Long id,Long userid) {
        int i = userMapper.delectRelationById(id,userid);
        return i;
    }

    public List<Admin> getUsersByPhone(Long id, String phone) {
        return userMapper.getUsersByPhone(id,phone);
    }

    public int selectUser(String name) {
        int i = userMapper.selectUser(name);
        return i;
    }

    public int insertIntoAdmin(Admin admin) {
        int i = userMapper.insertIntoAdmin(admin);
        return i;
    }

    public Relational getRelation(Long user1id, Long user2id) {
        return userMapper.getRelation(user1id,user2id);
    }

    public int addRequestCode(Long userid, Long addid, String rel) {
        int i = userMapper.addRequestCode(userid, addid, rel);
        return i;
    }

    public int deleteUserByArray(Long id, String[] user2id) {
        int i = userMapper.deleteUserByArray(id, user2id);
        return i;
    }

    public List<Pogo1> getRequests(Long id) {
        List<Pogo1> requests = userMapper.getRequests(id);

        return requests;
    }

    public int agreeRelation(Long user1id, Long user2id) {
        int i = userMapper.agreeRelation(user1id, user2id);
        return i;
    }

    public int upadteRelation(Long id,Long addid,Long read) {
        int i = userMapper.upadteRelation(id, addid,read);
        return i;
    }

    public int upadteRelationById(Long id, Long user2id, Long relation) {
        int i = userMapper.upadteRelationById(id, user2id, relation);
        return i;
    }

    public Relational getRelationById(Long id, Long user2id) {
        Relational relational = userMapper.getRelationById(id, user2id);
        return relational;
    }

    public Admin getIdByName(String name) {
        Admin admin = userMapper.getIdByName(name);
        return admin;
    }

    //分页
    public PageInfo<Email> emaillist(Integer pageNum, Integer pageSize, String accept) {
        PageHelper.startPage(pageNum,pageSize);

        EmailExample emailExample = new EmailExample();
        EmailExample.Criteria criteria = emailExample.createCriteria();
        criteria.andAcceptEqualTo(accept);
        //分页数据
        List<Email> emails = emailMapper.selectByExample(emailExample);

        return new PageInfo<Email>(emails,5);
    }

    public int addEmail(Email email) {
        System.out.println(email.getAccept()+email.getSend()+ email.getTitle());
        int i = emailMapper.insert(email);
        return i;
    }

    public int deleteEmail(String send, String accept) {
        EmailExample emailExample = new EmailExample();
        EmailExample.Criteria criteria = emailExample.createCriteria();
        criteria.andSendEqualTo(send);
        criteria.andAcceptEqualTo(accept);
        int i = emailMapper.deleteByExample(emailExample);
        return i;
    }

    public int updateReadStatus(@Param("state") String state, String send, String accept) {
        EmailExample emailExample = new EmailExample();
        EmailExample.Criteria criteria = emailExample.createCriteria();
        criteria.andSendEqualTo(send);
        criteria.andAcceptEqualTo(accept);
        Email email = new Email();
        email.setState(Long.valueOf(1));
        int i = emailMapper.updateByExampleSelective(email, emailExample);
        return i;
    }
}
