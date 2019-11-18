package DeleteCommodities;

import CommoditiesMethod.comMethod;
import commoditiesDao.commodities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteCommodities")
public class DeleteCommodities extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理中文问题
        request.setCharacterEncoding("utf-8");
        //获取
        String cname = request.getParameter("cname");
        try {
            if (comMethod.FindCom(cname)>0){
                comMethod comMethod = new comMethod();
                comMethod.deletcom(cname);
                request.setAttribute("msg","删除成功");
                request.getRequestDispatcher("/delet/delet.jsp").forward(request,response);
            }else {
                request.setAttribute("msg","删除的商品不存在，请重新输入名称");
                request.getRequestDispatcher("/delet/delet.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
