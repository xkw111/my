package com.sc.service;

import com.github.pagehelper.PageInfo;
import com.sc.bean.Files;

import java.util.List;

public interface FileService {
//    public List<Files> getFileList(Integer pageNum,Integer pageSize);
    public int updateFileShares(Files files);
    public int addFile(Files files);
    public int deleteFile(Long fid);
    public PageInfo<Files> getFiles(Integer pageNum,Integer pageSize,String fshares,Long id);
    public Files getFilesByFid(Long fid);
}
