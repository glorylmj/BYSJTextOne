<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/11/18
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>销售员密码修改</title>
</head>
<body>
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
<form action="/UserUpdatePass" method="post">
    用户名：<input type="text" name="name"
               value=" <%=session.getAttribute("username") %>"  disabled>
    旧密码：<input type="password" name="oldpass">
    新密码:<input type="password" name="newpass1">
    重复密码:<input type="password" name="newpass2">
    <input type="submit" value="修改">
</form>
</body>
</html>
