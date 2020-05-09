package cn.itcast.jdbc;

import cn.itcast.domain.Emp;
import cn.itcast.util.JdBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class JdbcDome8 {
    public static void main(String[] args) {
        List<Emp> list = new JdbcDome8().findAll2();
        System.out.println(list);
        System.out.println(list.size());
    }
    public List<Emp> findAll(){
        Statement stmt =null;
        Connection conn = null;
        ResultSet rs=null;
        List<Emp> list=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db3","root", "root");
            String sql = "select *from emp";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            Emp emp =null;
            list = new ArrayList<Emp>();
            while(rs.next()) {
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                emp =new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);
                list.add(emp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if (stmt!=null){
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
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return list;
    }
    public List<Emp> findAll2(){
        Statement stmt =null;
        Connection conn = null;
        ResultSet rs=null;
        List<Emp> list=null;
        try {
            /*Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db3","root", "root");*/
            conn =JdBCUtils.getConnection();
            String sql = "select *from emp";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            Emp emp =null;
            list = new ArrayList<Emp>();
            while(rs.next()) {
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                emp =new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);
                list.add(emp);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            /*if (stmt!=null){
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
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }*/
        JdBCUtils.close(rs,stmt,conn);
        }
        return list;
    }
}
