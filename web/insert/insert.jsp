<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/11/16
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
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
    <form action="/InsertCommdities">
        商品名称：<input type="text" name="comname">
        销售量：<input type="text" name="comsales">
        仓库存货：<input type="text" name="comInventory">
        单价:<input type="text" name="price">
        生产商：<input type="text" name="source">
        <input type="submit" value="添加商品">
    </form>
</body>
</html>
