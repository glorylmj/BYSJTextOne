<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/11/19
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除</title>
</head>
<body>
<form action="/ECDelet" >
    <table>
        销售员:<input type="text" value="<%=session.getAttribute("username")%>" name="username" disabled>
        商品名称：<input type="text" name="comname">
        <input type="submit" value="删除"><br>
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
    </table>
</form>
</body>
</html>
