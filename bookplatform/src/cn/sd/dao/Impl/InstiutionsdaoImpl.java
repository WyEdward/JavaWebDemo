package cn.sd.dao.Impl;

import cn.sd.dao.Instiutionsdao;
import cn.sd.domain.Instiutions;
import cn.sd.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class InstiutionsdaoImpl implements Instiutionsdao {
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 添加基金会到表里
     * @param instiutions
     */
    @Override
    public void addInstiution(Instiutions instiutions) {
        String sql ="insert into instiutions(instiutions_name,instiution_address,instiution_email,instiution_number,instiution_linkman) values(?,?,?,?,?)";
        template.update(sql,instiutions.getInstiutions_name(),instiutions.getInstiution_address(),instiutions.getInstiution_email(),instiutions.getInstiution_number(),instiutions.getInstiution_linkman());
    }

    /**
     * 根据基金会的名字和联系人名字找基金会的id
     * @param instiutions
     * @return
     */
    @Override
    public int findIdbyNameandlinkman(Instiutions instiutions) {
        String sql ="select instiution_id from instiutions where instiutions_name=?  and  instiution_linkman=?";
        Integer id = template.queryForObject(sql, Integer.class,instiutions.getInstiutions_name(),instiutions.getInstiution_linkman());
        return id;
    }
}
