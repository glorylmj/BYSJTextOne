package EmpComInsert;

import EmployeeMethod.Employeemethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ECDelete")
public class ECDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理中文问题
        request.setCharacterEncoding("utf-8");
        //获取
        HttpSession session = request.getSession();
        String uname = String.valueOf(session.getAttribute("username"));
        String comname = request.getParameter("comname");
        try {
            if (Employeemethod.FindComByEmployess(comname, uname)>0){
                Employeemethod employeemethod = new Employeemethod();
                employeemethod.DeleteCom(comname,uname);
                request.setAttribute("msg","删除成功");
                request.getRequestDispatcher("/esales/deleteCom.jsp").forward(request,response);
            }else {
                request.setAttribute("msg","未查找到该销售员下的商品");
                request.getRequestDispatcher("/esales/deleteCom.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
