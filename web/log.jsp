<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/26
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>日志页面</title>
    <%--引入jquery文件--%>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <%--声明js代码域--%>
    <script type="text/javascript">
        //页面加载成功发起ajax请求，请求日志记录数据
        $(function () {
            //声明变量记录当前页
            var pn;
            //声明变量记录总的页码数
            var pages;
            var ps=2;
            //请求第一页数据
            getData(1,ps);
            //请求上一页数据
            $("#up").click(function () {
                if(pn>1){
                    getData(pn-1,ps)
                }else{
                    alert("已经是第一页")
                }
            })
            //请求下一页数据
            $("#next").click(function () {
                if(pn<pages){
                    getData(pn+1,ps);
                }else{
                    alert("已经是最后一页")
                }
            })
            //封装
            function getData(pageNum,pageSize){
                //请求第一页数据
                $.get("/mybatis_account/log",{pageNum:pageNum,pageSize:pageSize},function (data) {
                    //使用eval将数据转换成js对象
                    alert(data)
                    eval("var data="+data);
                    //获取当前页码
                    pn=data.pageNum;
                    pages=data.pages;
                    pageSize=data.pageSize;
                    //获取表格对象
                    var tb = $("#tb");
                    //清空原有内容
                    tb.empty();
                    //遍历填充数据
                    for(var i = 0; i<data.ll.length;i++){
                        tb.append(" <tr>" +
                            "<td>"+data.ll[i].outId+"</td>" +
                            "<td>"+data.ll[i].inId+"</td>" +
                            "<td>"+data.ll[i].money+"</td>" +
                            "</tr>")
                    }
                })
            }

        })
    </script>
</head>
<body>
    <h3>转账记录页面</h3>
    <hr/>

    <table border="1px" cellpadding="10px" cellspacing="0px" >
        <thead>
            <tr>
                <td>转账账户</td>
                <td>入账账户</td>
                <td>转账金额</td>
            </tr>

        </thead>
        <tbody id="tb"></tbody>
    </table>
    <a id="up" href="javascript:void(0)">上一页</a>
    <a id="next" href="javascript:void(0)">下一页</a>

</body>
</html>
