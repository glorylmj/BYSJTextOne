package updatepassword;

import FindUser.UserFind;
import UserMeth.UpdateUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Adminpass")
public class Adminpass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理中文问题
        request.setCharacterEncoding("utf-8");
        //获取
        String username = request.getParameter("name");
        String opass = request.getParameter("oldpass");
        String pass1 = request.getParameter("newpass1");
        String pass2 = request.getParameter("newpass2");
        String pass = UserFind.FindUser(username);
        if (pass.equals("")){
            request.setAttribute("msg","未查找到该用户，无法修改密码");
            RequestDispatcher qr = request.getRequestDispatcher("/adminUpdatePass/updatepass.jsp");//得到一个转发器
            qr.forward(request,response);//转发
        }else if (!pass1.equals(pass2)){
            request.setAttribute("msg","两次密码不一致");
            RequestDispatcher qr = request.getRequestDispatcher("/adminUpdatePass/updatepass.jsp");//得到一个转发器
            qr.forward(request,response);//转发
        }else if (opass.equals("")){
            request.setAttribute("msg","密码不能为空");
            RequestDispatcher qr = request.getRequestDispatcher("/adminUpdatePass/updatepass.jsp");//得到一个转发器
            qr.forward(request,response);//转发
        }else if (pass1.equals("")||pass2.equals("")||opass.equals("")){
            request.setAttribute("msg","请输入值");
            RequestDispatcher qr = request.getRequestDispatcher("/adminUpdatePass/updatepass.jsp");//得到一个转发器
            qr.forward(request,response);//转发
        }else {
            UpdateUser updateUser = new UpdateUser();
            updateUser.UpdateUser(username,pass1);
            request.setAttribute("msg","修改成功");
            RequestDispatcher qr = request.getRequestDispatcher("/adminUpdatePass/updatepass.jsp");//得到一个转发器
            qr.forward(request,response);//转发
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
