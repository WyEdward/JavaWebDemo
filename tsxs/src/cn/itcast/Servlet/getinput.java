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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet("/getinput")
public class getinput extends HttpServlet {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 得到传过来的数据
         * city:城市
         * country：区县
         * title:主题
         * content:内容
         */
        //replace去掉字符串的双引号.replace("\"", "");
        request.setCharacterEncoding("UTF-8");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
       // System.out.println(city + country+title+content);
        /**
         * //1、查询是否存在输入的城市
         */
        String select_city ="select* from datadealapp_cityarea where city = ? and city_area =?";
        List<Map<String, Object>> maps = template.queryForList(select_city, city, country);
        //System.out.println(maps);
        /**
         * //2、插入输入的城市
         */
        String insert_city ="insert into datadealapp_cityarea(city,city_area) values(?,?)";
        if(maps==null||maps.size()<1){
            int count = template.update(insert_city, city, country);//执行插入城市的操作
            /*if(count>0){
                System.out.println("插入成功");
            }*/
        }
        /*else{
            System.out.println("已存在该城市");
        }*/
        /**
         * 3、插入输入的内容和主题
         */
        //获取当前时间
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String datetime = format.format(date);
        //插入语句
        String insert_content ="insert into datadealapp_complaintrawdata(title,content, reflecting_time,reply_unit,reply_opinion,reply_time,province," +
                "city,city_area,datetime,read_times) values(?,?,?,?,?,?,?,?,?,?,?)";
        int count2 = template.update(insert_content, title, content,datetime,"教育部","继续努力",datetime, "浙江省",city, country, datetime,"1");
        if(count2>0){
            String query="已提交到教育部";
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(query);
            response.setContentType("application/json;charset=utf-8");
            //打印json到控制台
            //System.out.println(json);
            response.getWriter().write(json);
            //System.out.println("插入成功");
        }else{
            System.out.println("插入失败");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
