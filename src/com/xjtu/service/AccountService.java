package com.xjtu.service;

import com.xjtu.pojo.Account;

import java.io.IOException;

public interface AccountService {

    //转账账户Id和密码不匹配
    int ACCOUNT_OUT_ID_PWD_ERROR = 1;
    //余额不足
    int ACCOUNT_OUT_MONEY_NOT_ENOUGH = 3;
    //入账账户ID和账户名不匹配
    int ACCOUNT_IN_ID_NAME_ERROR = 5;
    //转账成功
    int ACCOUNT_SUCCESS = 2;
    //转账失败
    int ACCOUNT_ERROR = 7;
    /**
     *
     * @param outAccount 转账的账户
     * @param inAccount 入账的账户
     * @return  转账结果（成功，失败）
     */
    int transferAccount(Account outAccount , Account inAccount) throws IOException;
}
