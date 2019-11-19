<%@ page import="EmployeeMethod.Employeemethod" %>
<%@ page import="EmployeeDao.Employee" %>
<%@ page import="commoditiesDao.commodities" %>
<%@ page import="Pager.Pager" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/11/18
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        Employeemethod emp = new Employeemethod();
        Pager<Employee> pages = emp.FindEmploySales(String.valueOf(session.getAttribute("username")));
        int pageIndex = pages.getPageIndex();
        List<Employee> employees = pages.getDatas();
        String username = (String) session.getAttribute("username");
        session.setAttribute("username",username);
//        String username = request.getParameter("username");
//        session.setAttribute("username",username);
        //System.out.println(session.getAttribute("usernmae"));
    %>
    <title>员工销售量</title>
</head>
<body>
<table align="center" border="1" width="800">
    <tr>
        <td colspan="7">
            一共有:<%=pages.getTotalPage() %>条记录，当前是第<%=pages.getPageIndex() %>页，每页显示<%=pages.getPageSize() %>条记录
        </td>
    </tr>
    <tr>
        <td>商品名称</td><td>销售量</td>
    </tr>
    <%
        for(Employee e:employees){
    %>
    <tr>
        <td><%=e.getComname() %></td>
        <td><%=e.getEsales() %></td>
        &nbsp;
    </tr>
    <%
        }
    %>
    <tr>
        <td colspan="7" style="font-size:12px">
            <a href="esales.jsp?pageIndex=1">首页</a>
            <%
                if(pages.getPageIndex()>1) {
            %>
            <a href="esales.jsp?pageIndex=<%=(pageIndex-1)%>">上一页</a>
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
            <a href="esales.jsp?pageIndex=<%=i%>">[<%=i %>]</a>
            <%
                    }
                }
            %>
            <%
                if(pageIndex<totalPage) {
            %>
            <a href="esales.jsp?pageIndex=<%=(pageIndex+1)%>">下一页</a>
            <%
                }
            %>
            <a href="esales.jsp?pageIndex=<%=totalPage%>">尾页</a>
        </td>
    </tr>
</table>

<a href="insertCom.jsp">添加</a>
<a>删除</a>
<a>修改</a>
</body>
</html>
