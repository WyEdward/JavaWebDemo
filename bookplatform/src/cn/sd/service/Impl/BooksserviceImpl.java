package cn.sd.service.Impl;

import cn.sd.dao.Impl.BooksdaoImpl;
import cn.sd.domain.Books;
import cn.sd.domain.User;
import cn.sd.service.Booksservice;

import java.util.List;

public class BooksserviceImpl implements Booksservice {
    BooksdaoImpl booksdao = new BooksdaoImpl();
    @Override
    public void addbook(Books book) {
        booksdao.addbook(book);
    }

    @Override
    public Integer findbookIdbynameanddateanduid(Books book) {
        return booksdao.findbookIdbynameanddateanduid(book);
    }

    @Override
    public List<Books> findbookbyId(User user) {
        return booksdao.findbookbyId(user);
    }

}
