package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDome2 {
    public static void main(String[] args) {
        Statement stmt= null;
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "insert into account values(null,'王五',3000)";
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(count);
            if(count>0){
                System.out.println("添加成功!");
            }else{
                System.out.println("添加失败!");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
