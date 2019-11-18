package UserMeth;

import DBUtil.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateUser {
    public void UpdateUser(String username,String password){
        Connection con = null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        con = DBUtil.getConnection();
        String sql ="UPDATE user SET password=? WHERE username=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,password);
            ps.setString(2,username);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(con);
        }
    }
}
