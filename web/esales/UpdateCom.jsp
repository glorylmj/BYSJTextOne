<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/11/19
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新数据</title>
</head>
<body>
<form action="/UpdateCom" >
    <table>
        销售员:<input type="text" value="<%=session.getAttribute("username")%>" name="username" disabled>
        商品名称：<input type="text" name="comname">
        增加销售数量:<input type="text" name="comsales">
        <input type="submit" value="修改"><br>
        <input type="button" value="返回" onclick="back()">
        <script>
            function back() {
                window.location.href="/employees/employees.jsp"
            }

        </script>
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
