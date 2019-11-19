package EmployeeMethod;

import DBUtil.DBUtil;
import EmployeeDao.Employee;
import Pager.Pager;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import commoditiesDao.commodities;
import systemcontext.SystemContext;

import javax.websocket.Session;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Employeemethod {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource("test");
    /**
     * 配置DataSource
     */
    public static void configDataSource(){
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jxc");
            dataSource.setUser("root");
            dataSource.setPassword("123456");
            dataSource.setInitialPoolSize(3);
            dataSource.setMaxPoolSize(10);
            dataSource.setMinPoolSize(3);
            dataSource.setAcquireIncrement(3);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    //加载名字为“test”的配置文件

    /**
     * 获取Connection连接
     * @return
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn =  dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

//    public static List<> FindByName(String ename){
//        Connection con = null;
//        PreparedStatement ps=null;
//        ResultSet rs=null;
//        String pass=null;
//        con = DBUtil.getConnection();
//        String sql = "select * form employees where ename = ?";
//        Employee emp = new Employee();
//
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setString(1,ename);
//            rs = ps.executeQuery();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }

    public Pager<Employee> FindEmploySales(String username){
        int pageIndex = SystemContext.getPageIndex();
        int pageSize = SystemContext.getPageSize();
         Connection con = null;
         PreparedStatement ps=null;
         ResultSet rs=null;
         String pass=null;
         con = DBUtil.getConnection();
        Pager<Employee> pages = new Pager<Employee>();
        List<Employee> employees = new ArrayList<Employee>();
        // String sql  ="select e.esales,c.`name` FROM commodities c,employees e where c.`name`=e.comname AND e.username=?";
        try {
            if (pageIndex<=0) pageIndex=1;
            int start = (pageIndex-1)*pageSize;
            con = DBUtil.getConnection();
            String sql = "select e.esales,c.`name` FROM commodities c,employees e where c.`name`=e.comname AND e.username=? ";
            String sqlCount = "select count(*) from employees where username = ?";
            sql+="limit ?,?";
            ps = con.prepareStatement(sql);
            ps.setString(1,username);
            ps.setInt(2,start);
            ps.setInt(3,pageSize);
            rs = ps.executeQuery();
            while (rs.next()){
               Employee employee = new Employee();
              employee.setComname(rs.getString("name"));
              employee.setEsales(rs.getInt("esales"));
              employees.add(employee);
            }
            ps = con.prepareStatement(sqlCount);
            ps.setString(1,username);
            rs = ps.executeQuery();
            int totalRecord = 0;
            while (rs.next()){
                totalRecord = rs.getInt(1);
            }
            int totalPage = (totalRecord-1)/pageSize+1;
            pages.setPageIndex(pageIndex);
            pages.setPageSize(pageSize);
            pages.setTotalPage(totalPage);
            pages.setTotalRecord(totalRecord);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(con);
        }
        pages.setDatas(employees);
        return pages;
}

public void InsertCom(Employee  employee){
    Connection con = null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    con = DBUtil.getConnection();
    String sql= "INSERT INTO employees (username,esales,comname) VALUES(?,?,?)";
    try {
        ps=con.prepareStatement(sql);
        ps.setString(1,employee.getUsername());
        ps.setInt(2, employee.getEsales());
        ps.setString(3,employee.getComname());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }finally {
        DBUtil.close(con);
        DBUtil.close(ps);
        DBUtil.close(rs);
    }
}

//根据商品名称和销售员名称查询是否存在该商品
    public static int FindComByEmployess (String comname,String username) throws SQLException {
        Connection con = null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int num = 0;
        con = DBUtil.getConnection();
        String sql="SELECT COUNT(*) FROM employees where comname = ? and username = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,comname);
            ps.setString(2,username);
            rs = ps.executeQuery();
            while (rs.next()){
                num = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(con);
        }
        return num;
    }




    //删除商品
    public void DeleteCom(String comname,String username){
        Connection con = null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        con = DBUtil.getConnection();
        String sql="DELETE FROM employees WHERE comname=? AND username=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,comname);
            ps.setString(2,username);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(con);
            DBUtil.close(ps);
            DBUtil.close(rs);
        }
    }

    //更新操作
    public void UpdateCom(Employee employee,String username){
        Connection con = null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        con = DBUtil.getConnection();
        String sql="UPDATE employees SET esales=esales+? WHERE comname=? AND username=?";
        String sql2="UPDATE commodities SET sales = sales+?,Inventory=Inventory-? WHERE `name`=?";
        try {
            ps= con.prepareStatement(sql);
            ps.setInt(1,employee.getEsales());
            ps.setString(2,employee.getComname());
            ps.setString(3,username);
            ps.executeUpdate();

            ps=con.prepareStatement(sql2);
            ps.setInt(1,employee.getEsales());
            ps.setInt(2,employee.getEsales());
            ps.setString(3,employee.getComname());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(con);
            DBUtil.close(ps);
            DBUtil.close(rs);
        }
    }

}
