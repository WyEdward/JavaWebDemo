package cn.itcast.jdbctemplate;
import cn.itcast.domain.Emp;
import cn.itcast.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo2 {
    //Junit单元测试 可以让方法独立执行
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 1、修改emp表中1号数据的salary为10000
     */
    @Test
    public void test1(){
       // JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "update emp set salary = 10000 where id = 1001";
        int count = template.update(sql);
        System.out.println(count);
    }

    /**
     * 2.添加一条记录
     */
    @Test
    public void test2(){
        //JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "insert into Emp(id,ename,dept_id) values(?,?,?)";
        int count = template.update(sql,1015,"郭靖",10);
        System.out.println(count);
    }
    /**
     * 3 删除刚才添加的记录
     */
    @Test
    public void test3(){
        String sql = "delete from emp where id = ?";
        int count = template.update(sql, 1015);
        System.out.println(count);
    }
    /**
     * 4 查询id为1的记录，并将其封装成Map集合
     * queryForMap 这个方法查询的结果集长度只能是1
     * 将列名作为key 将值作为value 将这条记录封装为一个map集合
     */
    @Test
    public void test4(){
        String sql = "select *from emp where id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1001);
        System.out.println(map);
    }
    /**
     * 5 查询所有记录，将其封装为List
     * queryForlist()
     * 将每一条记录封装为一个map集合
     * 再将map集合装载到list集合中
     */
    @Test
    public void test5(){
        String sql = "select *from emp";
        List<Map<String, Object>> list = template.queryForList(sql);
        //iter
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }

    /**
     * 6 查询所有记录，将其封装成Emp对象的list集合
     */
    @Test
    public void test6(){
       String sql = "select *from emp";
        List<Emp> list = template.query(sql, new RowMapper<Emp>() {

            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp emp = new Emp();
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);
                return emp;
            }
        });
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
    /**
     * 6_2 查询所有记录，将其封装成Emp对象的list集合
     */
    @Test
    public void test6_2(){
        String sql = "select *from emp";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
    /**
     * 7 查询总记录数
     * 一般执行聚合函数
     */
    @Test
    public void test7(){
        String sql = "select count(id) from emp";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }
}
