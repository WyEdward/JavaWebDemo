package cn.sd.dao;

import cn.sd.domain.Books;
import cn.sd.domain.User;

import javax.swing.*;
import java.util.List;

public interface Booksdao {
    void addbook(Books book);
    Integer findbookIdbynameanddateanduid(Books book);
    List<Books> findbookbyId(User user);
}
