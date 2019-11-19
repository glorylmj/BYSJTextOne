<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/11/19
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>销售员添加销售产品</title>
</head>
<body>
    <form action="/ECInsert" >
        <table>
            销售员:<input type="text" value="<%=session.getAttribute("username")%>" name="username" disabled>
            商品名称：<input type="text" name="comname">
            销售数量: <input type="text" name="comsales">
            <input type="submit" value="添加">
        </table>
    </form>
</body>
</html>
