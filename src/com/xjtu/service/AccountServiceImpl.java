package com.xjtu.service;

import com.xjtu.pojo.Account;
import com.xjtu.pojo.Log;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class AccountServiceImpl implements AccountService {
    @Override
    public int transferAccount(Account outAccount, Account inAccount) throws IOException {
        //获取SqlSession对象
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession ss = factory.openSession();
        //1.校验转账账户信息
         Account accountOut =  ss.selectOne("com.xjtu.mapper.AccountMapper.selByIdPwd",outAccount);
         if(accountOut != null){
             //2.校验余额
             if(outAccount.getMoney()<=accountOut.getMoney()){
                 //3.校验入账账户信息
                 Account accountIn =  ss.selectOne("com.xjtu.mapper.AccountMapper.selByIdName",inAccount);
                 if(accountIn!=null){
                     //4.转账
                     //设置转账账户对象中的钱为负数
                     outAccount.setMoney(-outAccount.getMoney());
                     //转账
                     int i = ss.update("com.xjtu.mapper.AccountMapper.upAccount",outAccount);
                     //入账
                     i+= ss.update("com.xjtu.mapper.AccountMapper.upAccount",inAccount);
                     if(i==2){
                         //5.插入转账日志
                         Log log = new Log();
                         log.setOutId(outAccount.getAid());
                         log.setInId(inAccount.getAid());
                         log.setMoney(inAccount.getMoney());
                         ss.insert("com.xjtu.mapper.LogMapper.insertLog",log);
                         ss.commit();
                         //6.打印转账日志
                         Logger logger = Logger.getLogger(AccountServiceImpl.class);
                         logger.debug(outAccount.getAid() + " 在 " + new Date().toLocaleString() + " 给 " + inAccount.getAid() + "转了" + inAccount.getMoney() + "元");
                         return ACCOUNT_SUCCESS;
                     }else {
                         return ACCOUNT_ERROR;
                     }

                 }else{
                     return ACCOUNT_IN_ID_NAME_ERROR;
                 }

             }else {
                 return ACCOUNT_OUT_MONEY_NOT_ENOUGH;
             }

         }else{
             return ACCOUNT_OUT_ID_PWD_ERROR;
         }

    }
}
