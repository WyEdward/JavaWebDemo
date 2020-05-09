package cn.itcast.jdbc;

import cn.itcast.util.JdBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 事务操作
 */
public class JdbcDome10 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement pstmt1=null;
        PreparedStatement pstmt2=null;
        try {
            //1、获取连接
            conn = JdBCUtils.getConnection();
            //2定义sql
            conn.setAutoCommit(false);
            String sql1 ="update account set balance =balance -? where id =?";
            String sql2 ="update account set balance =balance +? where id =?";
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            pstmt1.setDouble(1,500);
            pstmt1.setInt(2,1);
            pstmt2.setDouble(1,500);
            pstmt2.setInt(2,2);
            pstmt1.executeUpdate();
            pstmt2.executeUpdate();

            conn.commit();
        } catch (Exception e) {
            try {
                if(conn!=null)
                 conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JdBCUtils.close(null,pstmt1,conn);
            JdBCUtils.close(null,pstmt1,null);
        }
    }
}
