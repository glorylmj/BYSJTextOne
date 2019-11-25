<%@ page import="CommoditiesMethod.comMethod" %>
<%@ page import="commoditiesDao.commodities" %>
<%@ page import="Pager.Pager" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/11/18
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>employees</title>
    <%
        comMethod com = new comMethod();
        Pager<commodities> pages = com.FindAll();
        int pageIndex = pages.getPageIndex();
        List<commodities> commodities = pages.getDatas();

    %>
    <script type="text/html">

    </script>
</head>
<body>
    欢迎你，销售员：  <%
        String name = "";
       // String uname = (String) request.getAttribute("username");
        String uname = (String) session.getAttribute("username");
        if (uname != null){
            name = uname;
        }
        session.setAttribute("username",uname);
    %>
    <font color="red">
        <b>
            <%=uname
            %>
        </b>
    </font>
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
                <a href="/employees/employees.jsp?pageIndex=1">首页</a>
                <%
                    if(pages.getPageIndex()>1) {
                %>
                <a href="/employees/employees.jsp?pageIndex=<%=(pageIndex-1)%>">上一页</a>
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
                <a href="/employees/employees.jsp?pageIndex=<%=i%>">[<%=i %>]</a>
                <%
                        }
                    }
                %>
                <%
                    if(pageIndex<totalPage) {
                %>
                <a href="/employees/employees.jsp?pageIndex=<%=(pageIndex+1)%>">下一页</a>
                <%
                    }
                %>
                <a href="/employees/employees.jsp?pageIndex=<%=totalPage%>">尾页</a>
            </td>
        </tr>
    </table>

    <a href="../esales/esales.jsp">查看销售量</a>
    <a href="../adminUpdatePass/userupdatepass.jsp">修改密码</a>
    <script>
        function back() {
            window.location.href="/login/login.jsp"
        }

    </script>
    <input type="button" value="注销" onclick="back()">
</body>
</html>
