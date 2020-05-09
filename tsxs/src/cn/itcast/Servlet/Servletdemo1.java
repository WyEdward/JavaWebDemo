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
@WebServlet("/servletdemo1")
public class Servletdemo1 extends HttpServlet {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
   /* private static String[] provs={"浙江省"};
    private static String[] citys={"杭州","湖州","嘉兴","舟山","宁波","绍兴","衢州","金华","台州","温州","丽水"};
    private static String[][] countrys={{
            "拱墅区", "上城区", "下城区", "江干区", "西湖区", "滨江区", "余杭区", "萧山区",
            "临安市", "富阳市", "建德市", "桐庐县", "淳安县", "千岛湖镇" ,"经济技术开发区"},
            {"吴兴区", "南浔区", "长兴县", "雉城镇", "德清县", "武康镇", "安吉县", "递铺镇","湖州度假区","湖州开发区"},
            {"南湖区", "秀洲区", "平湖市", "海宁市", "桐乡市", "嘉善县", "魏塘镇", "海盐县", "武原镇","经济技术开发区","国际商务区"},
            {"定海区", "普陀区", "岱山县", "高亭镇", "嵊泗县", "菜园镇"},
            {"海曙区", "江东区", "江北区", "北仑区", "镇海区", "鄞州区", "慈溪市", "余姚市", "奉化市", "宁海县", "象山县"},
            {"越城区", "诸暨市", "上虞市", "嵊州市", "绍兴县", "新昌县", "城关镇"},
            {"柯城区", "衢江区", "江山市", "常山县", "天马镇", "开化县", "城关镇", "龙游县"},
            {"婺城区", "金东区", "兰溪市", "永康市", "义乌市", "东阳市", "武义县", "浦江县", "磐安县", "安文镇"},
            {"椒江区", "黄岩区", "路桥区", "临海市", "温岭市", "三门县", "海游镇", "天台县", "仙居县", "玉环县", "珠港镇"},
            {"鹿城区", "龙湾区", "瓯海区", "瑞安市", "乐清市", "永嘉县", "上塘镇", "文成县", "大峃镇", "平阳县", "昆阳镇", "泰顺县",
                    "罗阳镇", "洞头县", "北岙镇", "苍南县", "灵溪镇"},
            {"莲都区", "龙泉市", "缙云县", "五云镇", "青田县", "鹤城镇", "云和县", "云和镇", "遂昌县", "妙高镇", "松阳县",
                    "西屏镇", "庆元县", "松源镇", "景宁畲族自治县", "鹤溪镇"}};*/
    /**
     * 获取datadealapp_complaintrawdata表中的数据
     * 并生成json格式
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String prov_v = request.getParameter("prov");
        String city_v = request.getParameter("city");
        String country_v = request.getParameter("country");
       /* System.out.println(prov_v+city_v+country_v);
        String city_s = citys[Integer.parseInt(city_v)];
        String country =countrys[Integer.parseInt(city_v)][Integer.parseInt(country_v)];*/
        String sql = "select * from datadealapp_complaintrawdata where province=? and city=? and city_area=?";
        List<Complaintrawdata> query = template.query(sql,
                new BeanPropertyRowMapper<>(Complaintrawdata.class),prov_v,city_v,country_v);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(query);
        response.setContentType("application/json;charset=utf-8");
        //打印json到控制台
       // System.out.println(json);
        response.getWriter().write(json);
  /*      response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("成功得到数据");*/
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}