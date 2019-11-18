package CommoditiesMethod;

import DBUtil.DBUtil;
import Pager.Pager;
import systemcontext.SystemContext;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import commoditiesDao.commodities;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class comMethod {
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
//查询所有
    public Pager<commodities>  FindAll(){
        int pageIndex = SystemContext.getPageIndex();
        int pageSize = SystemContext.getPageSize();
        Connection con = null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Pager<commodities> pages = new Pager<commodities>();
        List<commodities> commodities = new ArrayList<commodities>();
        commodities comm = null;
        try {
            if (pageIndex<=0) pageIndex=1;
            int start = (pageIndex-1)*pageSize;
            con = DBUtil.getConnection();
            String sql = "SELECT * from commodities ";
            String sqlCount = "select count(*) from commodities ";
            sql+="limit ?,?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,start);
            ps.setInt(2,pageSize);
            rs = ps.executeQuery();
            while (rs.next()){
                commodities com = new commodities();
                com.setID(rs.getInt("ID"));
                com.setName(rs.getString("name"));
                com.setSales(rs.getInt("sales"));
                com.setPrice(rs.getDouble("price"));
                com.setInventory(rs.getInt("inventory"));
                com.setSource(rs.getString("source"));
                commodities.add(com);
            }
            ps = con.prepareStatement(sqlCount);
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
        pages.setDatas(commodities);
        return pages;
    }


    //根据商品name查询数据
    public static int FindCom(String comname) throws SQLException {
        Connection con = null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int num = 0;
        con = DBUtil.getConnection();
        commodities com = new commodities();
        String sql="SELECT COUNT(*) FROM commodities where name = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,comname);
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



//添加数据
    public void insertcom(commodities commodities){
//        String name,int sales,int Inventory,double price,String source
        Connection con = null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        con = DBUtil.getConnection();
        String sql= "INSERT INTO commodities (name,sales,Inventory,price,source) VALUES(?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,commodities.getName());
            ps.setInt(2,commodities.getSales());
            ps.setInt(3,commodities.getInventory());
            ps.setDouble(4,commodities.getPrice());
            ps.setString(5,commodities.getSource());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(con);
            DBUtil.close(ps);
            DBUtil.close(rs);
        }

    }


//删除数据（根据商品名字）
    public  void deletcom(String comname){
        Connection con = null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        con = DBUtil.getConnection();
        String sql = "DELETE FROM commodities where name = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,comname);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(con);
            DBUtil.close(ps);
            DBUtil.close(rs);
        }
    }


//更新数据
    public void updateCom(commodities commodities,String upname){
        Connection con = null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        con = DBUtil.getConnection();
        String sql = "UPDATE commodities SET name=?,sales=?,Inventory=?,price=?,source=? WHERE name=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,commodities.getName());
            ps.setInt(2,commodities.getSales());
            ps.setInt(3,commodities.getInventory());
            ps.setDouble(4,commodities.getPrice());
            ps.setString(5,commodities.getSource());
            ps.setString(6,upname);
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
