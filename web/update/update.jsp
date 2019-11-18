<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/11/18
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改商品</title>
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
    <form action="/UpdateCommodities">
        商品名称：<input type="text" name="comname">
        销售量：<input type="text" name="comsales">
        仓库存货：<input type="text" name="comInventory">
        单价:<input type="text" name="price">
        生产商：<input type="text" name="source">
        <input type="submit" value="修改商品">
    </form>
</body>
</html>
