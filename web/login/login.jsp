<%@ page import="User.User" %>
<%@ page import="Login.Login" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/11/1
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script>
        function _change() {
            /**
             * 1.得到img元素
             * 2.修改其src为/20191025//VeriftyCode
             */
            var imgEle=document.getElementById("img");
            imgEle.src="/VeriftyCode?a=" + new Date().getTime();
        }

        function zhuce() {
                console.log("按钮触发！");
                window.location.href="/Registration/ZhuCe.jsp";
        }
    </script>
    <style>
        body{
            background:url("../picture/bj.jpg") no-repeat;
            height:100%;
            width:100%;
            overflow: hidden;
            background-size:cover;
        }
        .div1{
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
<%--    <script type="application/javascript">--%>
<%--       var username = document.getElementsByName("username");--%>
<%--       session.setAttribute("username", username);--%>
<%--       console.log( session.setAttribute("username", username));--%>
<%--    </script>--%>
</head>
<body>
  <div class="div1">
        <span class="span1">进销存</span><span class="span2">2019</span>
        <form action="/Login" method="post">
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
            </font><br>
            用户名：<input type="text" name="username" ><br><br>
            密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"><br><br>
            验证码：<input type="text" name="verifyCode"><br><br>
            <img src="/VeriftyCode" id="img">
            <a href="javascript:_change()">换一张</a><br><br>
            <input type="submit" value="登录"> &nbsp;&nbsp;&nbsp;<input type="button" onclick="zhuce()" value="注册">
        </form>
    </div>
</body>
</html>
