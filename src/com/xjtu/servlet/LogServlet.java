package com.xjtu.servlet;

import com.google.gson.Gson;
import com.xjtu.pojo.Page;
import com.xjtu.service.LogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/log")
public class LogServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        int pageNum = Integer.parseInt(req.getParameter("pageNum")) ;
        int pageSize = Integer.parseInt(req.getParameter("pageSize")) ;
        //处理请求信息
        Page p =  new LogServiceImpl().getLogInfoService(pageNum,pageSize);
        //响应处理结果
        resp.getWriter().write(new Gson().toJson(p));
    }
}
