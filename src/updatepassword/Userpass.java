package updatepassword;

import FindUser.UserFind;
import UserMeth.UpdateUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Userpass")
public class Userpass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理中文问题
        request.setCharacterEncoding("utf-8");
        //获取
        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("username"));
        String opass = request.getParameter("oldpass");
        String pass1 = request.getParameter("newpass1");
        String pass2 = request.getParameter("newpass2");
        String pass = UserFind.FindUser(username);
        if (null==pass){
            //判断密码是否存在
            request.setAttribute("msg","未查找到该用户，无法修改密码");
            RequestDispatcher qr = request.getRequestDispatcher("/userUpdatePass/UserUpdatePass.jsp");//得到一个转发器
            qr.forward(request,response);//转发
        }else if (!pass1.equals(pass2)){
            //判断两次密码是否相等
            request.setAttribute("msg","两次密码不一致");
            RequestDispatcher qr = request.getRequestDispatcher("/userUpdatePass/UserUpdatePass.jsp");//得到一个转发器
            qr.forward(request,response);//转发
        }else if (opass.equals("")){
            //判断旧密码是否为空置
            request.setAttribute("msg","密码不能为空");
            RequestDispatcher qr = request.getRequestDispatcher("/userUpdatePass/UserUpdatePass.jsp");//得到一个转发器
            qr.forward(request,response);//转发
        }else if (pass1.equals("")||pass2.equals("")||opass.equals("")){
            //判断三个inpput是否有值
            request.setAttribute("msg","请输入值");
            RequestDispatcher qr = request.getRequestDispatcher("/userUpdatePass/UserUpdatePass.jsp");//得到一个转发器
            qr.forward(request,response);//转发
        }else {
            //调用update方法
            UpdateUser updateUser = new UpdateUser();
            updateUser.UpdateUser(username,pass1);
            request.setAttribute("msg","修改成功");
            RequestDispatcher qr = request.getRequestDispatcher("/userUpdatePass/UserUpdatePass.jsp");//得到一个转发器
            qr.forward(request,response);//转发
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
