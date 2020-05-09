package cn.itcast.JavaTemplate;
import cn.itcast.Domain.Complaintrawdata;
import cn.itcast.utils.JDBCUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * 测试类
 */
public class Testdemo {
    //获取jdbctemplate对象 依赖于数据源
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    //test测试方法 在方法前加上@test
    @Test
    public void test() throws JsonProcessingException {
        //定义sql语句
        String sql = "select * from datadealapp_complaintrawdata where city_area=?";
        //包装成javabean对象
        List<Complaintrawdata> query = template.query(sql,
                new BeanPropertyRowMapper<>(Complaintrawdata.class),"上城区");
        //jakson 使其成为json格式的字符串
            ObjectMapper mapper = new ObjectMapper();
            // mapper.writeValueAsString(query)；
            String json = mapper.writeValueAsString(query);
            System.out.println(json);
            //打印文件路径
        URL path = Testdemo.class.getClassLoader().getResource("a.txt");
        System.out.println(path);
        // mapper.writeValue(new File("E:\\ideawork\\itcast\\tsxs\\src\\a.txt"),query;
       /*try {
            mapper.writeValue(new File("E:\\ideawork\\itcast\\tsxs\\src\\a.txt"),query);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
