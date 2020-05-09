package cn.sd.service;

import cn.sd.domain.Books;
import cn.sd.domain.User;

import java.util.List;

public interface Booksservice {
    void addbook(Books book);
    Integer findbookIdbynameanddateanduid(Books book);
    List<Books> findbookbyId(User user);
}
