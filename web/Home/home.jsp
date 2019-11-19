<%@ page import="User.User" %>
<%@ page import="commoditiesDao.commodities" %>
<%@ page import="java.util.List" %>
<%@ page import="CommoditiesMethod.comMethod" %>
<%@ page import="Pager.Pager" %>
<%@ page import="systemcontext.SystemContext" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/11/1
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
    <style>
        .div1{
            width: 100%;
            height: 10%;
            text-align: center;
            font-family: "微软雅黑";
            font-size: 90px;
            background: aqua;
        }
        .div2{
            width: 100%;
            height: 10%;
            text-align: center;
            font-family: "微软雅黑";
            font-size: 50px;
            background: #fdfffd;
        }

    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <%
        comMethod com = new comMethod();
        Pager<commodities> pages = com.FindAll();
        int pageIndex = pages.getPageIndex();
        List<commodities> commodities = pages.getDatas();
        String username = request.getParameter("username");
        session.setAttribute("username",username);
    %>

</head>
<body>
    <div class="div1">
        <div class="div2">
            欢迎使用易管理进销存系统！
            <%
                String name = "";
                String uuname = String.valueOf(session.getAttribute("username"));
                session.setAttribute("username",uuname);
                System.out.println("这是测试传过来的名字："+uuname);
//                String uname = (String) request.getAttribute("username");
                if (uuname != null){
                    name = uuname;

                }
            %>
            <font color="red">
                <b>
                    <%=uuname
                    %>
                </b>
            </font>
        </div>
    </div>
    <table align="center" border="1" width="800">
       <tr>
           <td colspan="7">
               一共有:<%=pages.getTotalPage() %>条记录，当前是第<%=pages.getPageIndex() %>页，每页显示<%=pages.getPageSize() %>条记录
           </td>
       </tr>
        <tr>
            <td>商品名称</td><td>销售量</td><td>价格</td><td>仓库存货</td><td>生产地</td>
        </tr>
        <%
            for(commodities c:commodities){
        %>
        <tr>
            <td><%=c.getName() %></td>
            <td><%=c.getSales() %></td>
            <td><%=c.getPrice() %></td>
            <td><%=c.getInventory() %></td>
            <td><%=c.getSource() %></td>
            &nbsp;
        </tr>
        <%
            }
        %>
        <tr>
            <td colspan="7" style="font-size:12px">
                <a href="/Home/home.jsp?pageIndex=1">首页</a>
                <%
                    if(pages.getPageIndex()>1) {
                %>
                <a href="/Home/home.jsp?pageIndex=<%=(pageIndex-1)%>">上一页</a>
                <%
                    }
                %>
                <%
                    int totalPage = pages.getTotalPage();
                    for(int i=1;i<=totalPage;i++) {
                        if(i==pageIndex) {
                %>
                <%=i %>
                <%
                } else {
                %>
                <a href="/Home/home.jsp?pageIndex=<%=i%>">[<%=i %>]</a>
                <%
                        }
                    }
                %>
                <%
                    if(pageIndex<totalPage) {
                %>
                <a href="/Home/home.jsp?pageIndex=<%=(pageIndex+1)%>">下一页</a>
                <%
                    }
                %>
                <a href="/Home/home.jsp?pageIndex=<%=totalPage%>">尾页</a>
            </td>
        </tr>
    </table>
    <div>
        <a href="../insert/insert.jsp">
            增加商品
<%--            <input type="button" value="增加商品" >--%>
        </a>&nbsp;&nbsp;&nbsp;
        <a href="../delet/delet.jsp">删除商品</a>
        <a href="../update/update.jsp">修改商品</a>
        <a href="../adminUpdatePass/updatepass.jsp">修改密码</a>
    </div>

</body>
</html>
