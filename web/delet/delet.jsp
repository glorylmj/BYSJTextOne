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
    <script>
        function back() {
            window.location.href="/Home/home.jsp"
        }

    </script>
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
    <div style="text-align: center">
    <form action="/DeleteCommodities">
        商品名称：<input type="text" name="cname"><br><br>
        <input type="submit" value="确定删除">
        <input type="button" value="返回" onclick="back()">
    </form>
</div>
</body>
</html>
