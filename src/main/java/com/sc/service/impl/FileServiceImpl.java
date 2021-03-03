package com.sc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.Files;
import com.sc.bean.FilesExample;
import com.sc.mapper.FilesMapper;
import com.sc.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FilesMapper filesMapper;

    public int updateFileShares(Files files) {
        int i = filesMapper.updateByPrimaryKey(files);
        return i;
    }

    public int addFile(Files files) {
        int i = filesMapper.insert(files);
        return i;
    }


    public int deleteFile(Long fid) {
        int i = filesMapper.deleteByPrimaryKey(fid);
        return i;
    }


    public PageInfo<Files> getFiles(Integer pageNum, Integer pageSize,String fshares,Long adminid) {
        PageHelper.startPage(pageNum,pageSize);

        List<Files> files = filesMapper.getMyAndShares(fshares,adminid);
        return new PageInfo<Files>(files);
    }


    public Files getFilesByFid(Long fid) {
        Files files = filesMapper.selectByPrimaryKey(fid);
        return files;
    }

}
