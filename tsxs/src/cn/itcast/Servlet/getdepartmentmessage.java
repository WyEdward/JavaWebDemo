package cn.itcast.Servlet;

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

@WebServlet("/getdepartmentmessage")
public class getdepartmentmessage extends HttpServlet {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String replyUnit = request.getParameter("replyUnit").replace("\"", "");
        String num = request.getParameter("nums");
        String sql = "select * from datadealapp_complaintrawdata where reply_unit=? limit ?,?";
        int num_v=Integer.parseInt(num);
        List<Complaintrawdata> query = template.query(sql,
                new BeanPropertyRowMapper<>(Complaintrawdata.class),replyUnit,num_v,6);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(query);
        response.setContentType("application/json;charset=utf-8");
        //打印json到控制台
        //System.out.println(json);
        // System.out.println(replyUnit+num);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
