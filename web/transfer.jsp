<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/26
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>转账页面</title>
</head>
<body>
    <h3>银行转账</h3>
    <hr/>

    <form action="/mybatis_account/transfer" method="post">
        转账账户Id:<input type="text" name="outId" value="" /><br />
        转账用户密码:<input type="password" name="outPwd" value="" /><br />
        转账金额数目:<input type="text" name="money" value="" /><br />
        入账用户ID:<input type="text" name="inId" value="" /><br />
        入账用户名称:<input type="text" name="inName" value="" /><br />
        <input type="submit"  value="转账" /> <br/>
    </form>
</body>
</html>
