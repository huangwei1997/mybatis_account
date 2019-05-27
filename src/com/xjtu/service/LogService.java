package com.xjtu.service;

import com.xjtu.pojo.Page;

import java.io.IOException;

public interface LogService {
    /**
     *分页查询转账记录
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page getLogInfoService(int pageNum , int pageSize) throws IOException;
}
