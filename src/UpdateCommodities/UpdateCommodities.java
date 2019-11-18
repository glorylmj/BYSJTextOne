package UpdateCommodities;

import CommoditiesMethod.comMethod;
import commoditiesDao.commodities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateCommodities")
public class UpdateCommodities extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理中文问题
        request.setCharacterEncoding("utf-8");
        //获取
        commodities commodities = new commodities();
        commodities.setName(request.getParameter("comname"));
        commodities.setSales(Integer.parseInt(request.getParameter("comsales")));
        commodities.setInventory(Integer.parseInt(request.getParameter("comInventory")));
        commodities.setPrice(Double.parseDouble(request.getParameter("price")));
        commodities.setSource(request.getParameter("source"));
        String cname = request.getParameter("comname");
        try {
            if (comMethod.FindCom(cname)>0){
                comMethod comMethod = new comMethod();
                comMethod.updateCom(commodities,cname);
                request.setAttribute("msg","修改成功");
                request.getRequestDispatcher("/update/update.jsp").forward(request,response);
            }else {
                request.setAttribute("msg","修改的商品不存在，请重新填写名称");
                request.getRequestDispatcher("/update/update.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
