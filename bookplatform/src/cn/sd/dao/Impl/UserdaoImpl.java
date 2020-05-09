package cn.sd.dao.Impl;

import cn.sd.dao.Userdao;
import cn.sd.domain.User;
import cn.sd.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserdaoImpl implements Userdao {
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 根据邮箱和密码查找用户
     * @param email 邮箱
     * @param password 密码
     * @return
     */
    @Override
    public User findUserByemailandpassword(String email, String password) {
        try {
            String sql ="select * from user where user_email = ? and user_password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), email, password);
            return user;
        } catch (DataAccessException e) {
            return null;
        }
    }

    /**
     * 添加用户
     * @param user
     */
    @Override
    public void addUser(User user) {
        String sql ="insert into user(user_nick,user_phone,user_password,create_time,user_email) values(?,?,?,?,?)";
        template.update(sql,user.getUser_nick(),user.getUser_phone(),user.getUser_password(),user.getCreate_time(),user.getUser_email());
    }

    /**
     * 更新用户信息
     * @param user
     */
    @Override
    public void update(User user) {
        String sql ="update user set user_nick=?,user_password=?,user_phone=?,create_time=?," +
                "user_email=?,isinstiutions=?,user_donations=?,user_bedonations=? where user_id=?";
        template.update(sql, user.getUser_nick(),user.getUser_password(),user.getUser_phone(), user.getCreate_time(),user.getUser_email(),
                user.getIsinstiutions(),user.getUser_donations(),user.getUser_bedonations(),user.getUser_id());
    }
}
