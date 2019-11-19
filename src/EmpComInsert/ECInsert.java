package EmpComInsert;

import EmployeeDao.Employee;
import EmployeeMethod.Employeemethod;
import commoditiesDao.commodities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ECInsert")
public class ECInsert extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理中文问题
        request.setCharacterEncoding("utf-8");
        //获取
        Employee employee = new Employee();
        HttpSession session = request.getSession();
        String uname = String.valueOf(session.getAttribute("username"));
        String comname = request.getParameter("comname");
        int esales = Integer.parseInt(request.getParameter("comsales"));
        System.out.println("名字："+uname+",商品名字："+comname+",销售量:"+esales);

        employee.setUsername(String.valueOf(session.getAttribute("username")));
        employee.setComname(request.getParameter("comname"));
        employee.setEsales(Integer.parseInt(request.getParameter("comsales")));
        try {
            if (Employeemethod.FindComByEmployess(employee.getComname(), employee.getUsername())>0){
                request.setAttribute("msg","添加的商品已经存在！不能继续添加!");
                request.getRequestDispatcher("/esales/insertCom.jsp").forward(request,response);
//                MsgException("添加的商品已经存在！不能继续添加!");
            }else{
                Employeemethod employeemethod = new Employeemethod();
                employeemethod.InsertCom(employee);
                request.setAttribute("msg","添加成功!");
                request.getRequestDispatcher("/esales/insertCom.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
