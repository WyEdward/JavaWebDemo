package cn.itcast.Servlet;

import cn.itcast.utils.JDBCUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/geteventnum")
public class geteventnum extends HttpServlet {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql = "select classification,number from datadealapp_classificationweight";
        List<Map<String, Object>> enventlist = template.queryForList(sql);
        //System.out.println(enventlist);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(enventlist);
        response.setContentType("application/json;charset=utf-8");
       //System.out.println(json);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
