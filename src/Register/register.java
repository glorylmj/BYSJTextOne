package Register;

import FindUser.InsertUser;
import FindUser.UserFind;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "register")
public class register extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理中文问题
        request.setCharacterEncoding("utf-8");
        //获取
        String username = request.getParameter("username2");
        String password = request.getParameter("password2");
        String password2 = request.getParameter("password3");
        //查询数据库是否存在用户名
        String pass = UserFind.FindUser(username);
        System.out.println(pass);
        System.out.println("用户名："+username+"密码："+password+","+password2);
        if (!password.equals(password2)){
            request.setAttribute("msg","两次密码不一致，请重新输入");
            RequestDispatcher qr = request.getRequestDispatcher("/Registration/ZhuCe.jsp");//得到一个转发器
            qr.forward(request,response);//转发
        }else if (password.equals(null)){
            request.setAttribute("msg","密码不能用空！");
            RequestDispatcher qr = request.getRequestDispatcher("/Registration/ZhuCe.jsp");//得到一个转发器
            qr.forward(request,response);//转发
        }else if (pass!=null){
            request.setAttribute("msg","用户名已存在");
            RequestDispatcher qr = request.getRequestDispatcher("/Registration/ZhuCe.jsp");//得到一个转发器
            qr.forward(request,response);//转发
        }else if (username==""){
            request.setAttribute("msg","用户名不能为空");
            RequestDispatcher qr = request.getRequestDispatcher("/Registration/ZhuCe.jsp");//得到一个转发器
            qr.forward(request,response);//转发
        }

        else {
             InsertUser user = new InsertUser();
             user.insertUser(username,password);
            response.sendRedirect("/login/login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
