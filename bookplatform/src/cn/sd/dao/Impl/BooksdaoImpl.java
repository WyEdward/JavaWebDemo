package cn.sd.dao.Impl;


import cn.sd.dao.Booksdao;
import cn.sd.domain.Books;
import cn.sd.domain.User;
import cn.sd.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BooksdaoImpl implements Booksdao {
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 捐赠人捐书
     * @param book 书的实例
     * @param userid 捐赠人的ud
     */
    @Override
    public void addbook(Books book) {
        String sql ="insert into books(book_name,book_writer,book_press,book_remakes,book_date,user_id) values(?,?,?,?,?,?)";
        template.update(sql,book.getBook_name(),book.getBook_writer(),book.getBook_press(),book.getBook_remakes(),book.getBook_date(),book.getUser_id());
    }

    /**
     * 通过书的名字和捐款时间返回书的id
     * @param books
     * @return
     */
    @Override
    public Integer findbookIdbynameanddateanduid(Books book) {
        String sql ="select book_id from books where book_name=? and book_date=? and user_id=?";
        Integer id = template.queryForObject(sql, Integer.class, book.getBook_name(), book.getBook_date(),book.getUser_id());
        return id;

    }

    /**
     * 通过id找书名
     * @param user
     * @return
     */
    @Override
    public List<Books> findbookbyId(User user) {
        String sql ="select * from books where user_id = ?";
        List<Books> query = template.query(sql, new BeanPropertyRowMapper<Books>(Books.class),user.getUser_id());
        return query;
    }

}
