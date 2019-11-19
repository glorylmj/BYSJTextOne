package EmpComInsert;

import EmployeeDao.Employee;
import EmployeeMethod.Employeemethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ECUpdate")
public class ECUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理中文问题
        request.setCharacterEncoding("utf-8");
        //获取
        HttpSession session = request.getSession();
        Employee employee = new Employee();
        employee.setUsername(String.valueOf(session.getAttribute("username")));
        employee.setComname(request.getParameter("comname"));
        employee.setEsales(Integer.parseInt(request.getParameter("comsales")));
        String uname = String.valueOf(session.getAttribute("username"));
        String comname = request.getParameter("comname");
        int comsales = Integer.parseInt(request.getParameter("comsales"));
        try {
            if (Employeemethod.FindComByEmployess(comname, uname)>0){
                Employeemethod employeemethod = new Employeemethod();
                employeemethod.UpdateCom(employee,uname);
                request.setAttribute("msg","修改成功!");
                request.getRequestDispatcher("/esales/UpdateCom.jsp").forward(request,response);
            }else if ((comname == null) || (request.getParameter("comsales")==null)){
                request.setAttribute("msg","输入的值不对，请重新输入!");
                request.getRequestDispatcher("/esales/UpdateCom.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
