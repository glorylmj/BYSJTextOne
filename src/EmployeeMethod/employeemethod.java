package EmployeeMethod;

import DBUtil.DBUtil;
import EmployeeDao.Employee;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class employeemethod {
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
}
