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
<style>
        body{
            background:url("../picture/csp.jpg") no-repeat;
            height:100%;
            width:100%;
            overflow: hidden;
            background-size:cover;
        }
        .d0{
            text-align: center;
            width: 300px;
            margin-left: 800px;
            margin-top: 350px;
            font-size: 15px;
            font-weight: bold;
            color: white;
            background-color: darkcyan;
        }

    </style>
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
    <div class="d0">
    <form action="/UpdateCommodities">
        <br><br>商品名称：<input type="text" name="comname"><br><br>
        销&nbsp;&nbsp;售&nbsp;&nbsp;量：<input type="text" name="comsales"><br><br>
        仓库存货：<input type="text" name="comInventory"><br><br>
        单&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价:<input type="text" name="price"><br><br>
        生&nbsp;&nbsp;产&nbsp;&nbsp;商：<input type="text" name="source"><br><br>
        <input type="submit" value="修改商品">
        <input type="button" value="返回" onclick="back()">
    </form>
</div>
</body>
</html>
