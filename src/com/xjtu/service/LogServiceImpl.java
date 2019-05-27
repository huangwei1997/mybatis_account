package com.xjtu.service;

import com.xjtu.pojo.Log;
import com.xjtu.pojo.Page;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class LogServiceImpl implements LogService {

    @Override
    public Page getLogInfoService(int pageNum, int pageSize) throws IOException {
        //获取SqlSession对象
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession ss = factory.openSession();
        //换算起始查询行角标
        int pageStart = pageNum*pageSize - pageSize;
        //分页查询数据
        Page p = new Page();
        p.setPageNum(pageNum);
        p.setPageStart(pageStart);
        p.setPageSize(pageSize);
        //查询当前页的数据
        List<Log> ll =  ss.selectList("com.xjtu.mapper.LogMapper.selLog",p);
        //查询总的记录条数
        int count =  ss.selectOne("com.xjtu.mapper.LogMapper.selLogCount");
        //计算总的页码数
        int pages = (int) Math.ceil(count*1.0/pageSize);
        //将数据存储到page对象中
        p.setCount(count);
        p.setPages(pages);
        p.setLl(ll);
        return p;
    }
}
