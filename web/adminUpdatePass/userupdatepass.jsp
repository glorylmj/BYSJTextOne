<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/11/21
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Userpassupdate</title>
</head>
<style>
    body{
        background:url("../picture/xgmm.jpg") no-repeat;
        height:100%;
        width:100%;
        overflow: hidden;
        background-size:cover;
    }
    span{
        font-size: 25px;
        color: blue;
    }
    .d0{
        margin-left: 500px;
        margin-top: 200px;
        font-size: 15px;
        font-weight: bold;
        color: white;
    }
    .d1{
        width: 100px;
        height: 2px;
        background-color: aqua;
        margin-top: 20px;
    }
    .d2{
        width: 100px;
        height: 2px;
        background-color: aqua;
        margin-top: 10px;
    }
    .d3{
        margin-left: 200px;
        margin-top: 100px;
    }

</style>
<script>
    function back() {
        window.location.href="/employees/employees.jsp"
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
    <span>修改密码</span>
    <div class="d1"></div>
    <div class="d2"></div>
    <div class="d3">
        <form action="/AdminUpdatePass" method="post">
            用户名：<input type="text" name="name"
                       value=" <%=session.getAttribute("username") %>"  disabled>
            旧密码：<input type="password" name="oldpass">
            新密码:<input type="password" name="newpass1">
            重复密码:<input type="password" name="newpass2">
            <input type="submit" value="修改">
            <input type="button" value="返回" onclick="back()">
        </form>
    </div>
</div>
</body>
</html>
