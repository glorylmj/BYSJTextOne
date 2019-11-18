<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/11/18
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除页面</title>
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
    <form action="/DeleteCommodities">
        商品名称：<input type="text" name="cname">
        <input type="submit" value="确定删除">
    </form>
</body>
</html>
