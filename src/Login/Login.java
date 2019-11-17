package Login;

import FindUser.UserFind;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet(name = "Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 校验验证码
         * 1.从session中获取正确的验证码
         * 2.从表单中获取用户填写的验证码
         * 3.进行比较！
         * 4.如果相同，向下运行  ，否则保存错误信息到request域中，转发到login.jsp
         */

        String sessionCode = (String) request.getSession().getAttribute("session_vcode");
        String paramCode = request.getParameter("verifyCode");

        if (!paramCode.equalsIgnoreCase(sessionCode)){
            request.setAttribute("msg","验证码错误！");
            request.getRequestDispatcher("/login/login.jsp").forward(request,response);
            return;
        }


        /**
         * 获取表单数据
         */
        //处理中文问题
        request.setCharacterEncoding("utf-8");
        //获取
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String pass = UserFind.FindUser(username);


        /**
         * 2.校验用户名密码是否正确
         */
        if (username!= "" && password.equals(pass)){
            //登陆成功
            /**
             * 附加项，把用户名保存到Cookie中，发送给客户端浏览器
             * 当再次打开login.jsp
             * 会读取Request中的cookie，把他显示到用户名文本中
             */
            Cookie cookie = new Cookie("username",username);//创建Cookie
            cookie.setMaxAge(60*60*24);//设置cookie命长1天
            response.addCookie(cookie);//保存cookie
            /**
             * 1.保存用户信息到Session中
             * 重定向到Succ1.jsp
             *
             */
            HttpSession session = request.getSession();//获取session
            session.setAttribute("username",username);//向域中保存session
            response.sendRedirect("/Home/home.jsp");

        }else {
            //登陆失败
            /**
             * 如果失败，保存错误信息到request域中
             * 转发到login.jsp
             */
            request.setAttribute("msg","用户名或密码错误");
            RequestDispatcher qr = request.getRequestDispatcher("/login/login.jsp");//得到一个转发器
            qr.forward(request,response);//转发
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
