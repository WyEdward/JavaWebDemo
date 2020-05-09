package cn.itcast.Servlet;

import cn.itcast.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletedr")
public class deletedr extends HttpServlet {
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
       // System.out.println(title+content);
        String sql ="delete from datadealapp_complaintrawdata where title =? and content =?";
        int result = template.update(sql, title, content);
        String result_v = String.valueOf(result);
       // System.out.println(result);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(result_v);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
