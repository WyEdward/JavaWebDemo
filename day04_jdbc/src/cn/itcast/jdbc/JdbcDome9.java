package cn.itcast.jdbc;
import cn.itcast.util.JdBCUtils;
import java.sql.*;
import java.util.Scanner;
public class JdbcDome9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.next();
        System.out.println("请输入密码：");
        String password =sc.next();
        boolean flag = new JdbcDome9().login2(username, password);
        if(flag){
            System.out.println("登录成功！");
        }else{
            System.out.println("用户名或密码错误！");
        }
    }
    public boolean login (String username ,String password){
            if(username==null||password==null){
                return false;
            }
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            conn = JdBCUtils.getConnection();
            String sql = "select *from user where username = '"+username+"' and password ='"+password+"' ";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdBCUtils.close(rs,stmt,conn);
        }

        return false;
    }
    /**
     * 使用 preparedStatement实现
     * @param username
     * @param password
     * @return
     */
    public boolean login2 (String username ,String password){
        if(username==null||password==null){
            return false;
        }
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            conn = JdBCUtils.getConnection();
            String sql = "select *from user where username = ? and password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdBCUtils.close(rs,pstmt,conn);
        }
        return false;
    }
}
