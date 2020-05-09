package cn.sd.dao.Impl;

import cn.sd.dao.Donateordersdao;
import cn.sd.domain.Donation_orders;
import cn.sd.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class DonateordersdaoImpl implements Donateordersdao {
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 增加订单
     * @param donation_order
     */
    @Override
    public void addDonateorder(Donation_orders donation_order) {
        String sql="insert into donation_orders(user_id1,user_id2," +
                "donation_date,donation_remarks,book_id) value(?,?,?,?,?)";
        template.update(sql,donation_order.getUser_id1(),donation_order.getUser_id2(),
                donation_order.getDonation_date(), donation_order.getDonation_remarks()
                ,donation_order.getBook_id());
    }
}
