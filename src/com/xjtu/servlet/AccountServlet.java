package com.xjtu.servlet;

import com.xjtu.pojo.Account;
import com.xjtu.service.AccountService;
import com.xjtu.service.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        int outId = Integer.parseInt( req.getParameter("outId"));
        String outPwd = req.getParameter("outPwd");
        double money = Double.parseDouble(req.getParameter("money")) ;
        int inId = Integer.parseInt( req.getParameter("inId"));
        String inName = req.getParameter("inName");
        //处理请求信息
        //封装对象
        Account outAccount = new Account();
        outAccount.setAid(outId);
        outAccount.setApwd(outPwd);
        outAccount.setMoney(money);

        Account inAccount = new Account();
        inAccount.setAid(inId);
        inAccount.setAname(inName);
        inAccount.setMoney(money);
        //调用业务层
        AccountService accountService = new AccountServiceImpl();
        int i = accountService.transferAccount(outAccount,inAccount);
        //响应处理结果
        if(i == accountService.ACCOUNT_SUCCESS){
            //重定向到日志页面
            resp.sendRedirect(req.getContextPath() + "/log.jsp");
        }else {
            req.getSession().setAttribute("flag",i);
            resp.sendRedirect(req.getContextPath()+"/error.jsp");
        }
    }
}
