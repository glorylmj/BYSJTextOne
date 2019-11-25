<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/11/1
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
<style>
        body{
            background:url("../picture/timg.jpg") no-repeat;
            height:100%;
            width:100%;
            overflow: hidden;
            background-size:cover;
        }
        div{
            width: 300px;
            height: 300px;
            background-color: white;
            margin-left: 45%;
            margin-top: 10%;
            text-align: center;
            overflow: hidden;
        }
        .span1{
            font-size: 25px;
            font-weight: bold;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<div><br>
    <span class="span1">进销存</span><span class="span2">2019</span><br><br>
    <form action="/Register" method="post">
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
    <form action="/Register">
        用&nbsp;&nbsp;户&nbsp;&nbsp;名：<input type="text" name="username2"><br><br>
        密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password2"><br><br>
        重复密码：<input type="password" name="password3"><br><br>
        身&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;份：<input type="text" name="identity"><br><br>

        <input type="submit" value="立即注册">
    </form>
</div>
</body>
</html>
