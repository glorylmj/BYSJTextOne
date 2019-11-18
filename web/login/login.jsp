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
        .div1{
            text-align: center;
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
            用户名:<input type="text" name="username" ><br>
            密&nbsp;&nbsp;码:<input type="password" name="password"><br>
             验证码：<input type="text" name="verifyCode"><br>
            <img src="/VeriftyCode" id="img">
            <a href="javascript:_change()">换一张</a><br>
            <input type="submit" value="登录"> &nbsp;&nbsp;&nbsp;<input type="button" onclick="zhuce()" value="注册">
        </form>
    </div>
</body>
</html>
