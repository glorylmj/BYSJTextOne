package InsertCommodities;

import CommoditiesMethod.comMethod;
import Pager.Pager;
import commoditiesDao.commodities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "InsertCommodities")
public class InsertCommodities extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理中文问题
        request.setCharacterEncoding("utf-8");
        //获取
        commodities com = new commodities();
        com.setName(request.getParameter("comname"));
        com.setSales(Integer.parseInt(request.getParameter("comsales")));
        com.setInventory(Integer.parseInt(request.getParameter("comInventory")));
        com.setPrice(Double.parseDouble(request.getParameter("price")));
        com.setSource(request.getParameter("source"));
        try {
           if (comMethod.FindCom(request.getParameter("comname"))>0){
               request.setAttribute("msg","添加的商品已经存在！不能继续添加!");
               request.getRequestDispatcher("/insert/insert.jsp").forward(request,response);
//                MsgException("添加的商品已经存在！不能继续添加!");
           }else {
               comMethod cm = new comMethod();
               cm.insertcom(com);
               request.setAttribute("msg","添加成功!");
               request.getRequestDispatcher("/insert/insert.jsp").forward(request,response);
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
