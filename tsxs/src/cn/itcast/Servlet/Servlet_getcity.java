package cn.itcast.Servlet;

import cn.itcast.Domain.Cityarea;
import cn.itcast.Domain.Complaintrawdata;
import cn.itcast.utils.JDBCUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getcity")
public class Servlet_getcity extends HttpServlet {
    //jdbctemplate 用来处理sql语句   参数是datasource
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 获取城市和相应县的名字
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //sql语句
        String sql = "SELECT city,city_area FROM datadealapp_cityarea";
        //jdbctemplate对象封装查询结果之JavaBean对象 其中的类对象为cityarea domain类
        List<Cityarea> query = template.query(sql,
                new BeanPropertyRowMapper<>(Cityarea.class));
        //用jakson将javabean对象包装成json字符串
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(query);
        //响应以json格式返回
        response.setContentType("application/json;charset=utf-8");
        //打印获取的json
       // System.out.println(json);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
