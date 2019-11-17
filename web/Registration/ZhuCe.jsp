<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/11/1
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="/Register" method="post">
        <%
                String message = "";
                String msg = (String) request.getAttribute("msg");
                if (msg != null){
                    message = msg;
                }
            %>
    <font color="red">
        <b>
            <%=message
            %>
        </b>
    </font>
    <form action="/Register">
        用户名:<input type="text" name="username2">
        密&nbsp;码:<input type="password" name="password2">
        重复密码:<input type="password" name="password3">
        <input type="submit" value="立即注册">
    </form>
</body>
</html>
