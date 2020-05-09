package cn.sd.dao.Impl;

import cn.sd.dao.Instiution_userdao;
import cn.sd.domain.User;
import cn.sd.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class Instiution_userdaoImpl implements Instiution_userdao {
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 用户关联基金会
     * @param user
     * @param Instiutions_id
     */
    @Override
    public void userAddInstiution(User user,int Instiutions_id) {
        String sql =" insert into instiutions_user(user_id,instiution_id) values(?,?)";
        template.update(sql,user.getUser_id(),Instiutions_id);
    }
}
