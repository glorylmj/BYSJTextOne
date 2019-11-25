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
    margin-left: 600px;
    margin-top: 200px;
    font-size: 15px;
    font-weight: bold;
    color: white;
    }
    .d3{
    margin-left: 200px;
    margin-top: 100px;
    }

    </style>
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
    <span>销售员修改密码</span>
    <div class="d3">
        <form action="/UserUpdatePass" method="post">
            用户名：<input type="text" name="name"
                       value=" <%=session.getAttribute("username") %>"  disabled> <br><br>
            旧密码：<input type="password" name="oldpass"><br><br>
            新密码：<input type="password" name="newpass1"><br><br>
            重复密码：<input type="password" name="newpass2"><br><br>
            <input type="submit" value="修改">
        </form>
    </div>
</div>
</body>
</html>
