package cn.itcast.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class JDBCUtils {

    private static DataSource ds;
    //static只进行一次
    static {
        try {
            //创建配置文件
            Properties pro=new Properties();
            //找到配置文件位置并加载
            InputStream rs = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(rs);
            //druid技术 创建数据源datasource需要加载配置文件
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回数据库连接对象connection
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     *返回数据源datasource
     * @return
     */
    public static DataSource getDataSource(){
        return ds;
    }

    /**
     * 关闭sql语句执行对象statment 数据库连接对象connection
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt, Connection conn){
        //close(null,stmt,conn);
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

    /**
     * 闭sql语句执行对象statment 数据库连接对象connection 结果集 resultset
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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
