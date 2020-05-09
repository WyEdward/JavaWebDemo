package cn.sd.domain;

import java.io.Serializable;
import java.util.Date;

public class Books implements Serializable{
    private int book_id; //书本id
    private String book_name;//书名
    private String book_writer;//书的作者
    private String book_press;//出版社
    private String book_remakes;//捐赠备注
    private int user_id;//捐书人id
    private Date book_date;//捐书的日期

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_writer() {
        return book_writer;
    }

    public void setBook_writer(String book_writer) {
        this.book_writer = book_writer;
    }

    public String getBook_press() {
        return book_press;
    }

    public void setBook_press(String book_press) {
        this.book_press = book_press;
    }

    public String getBook_remakes() {
        return book_remakes;
    }

    public void setBook_remakes(String book_remakes) {
        this.book_remakes = book_remakes;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getBook_date() {
        return book_date;
    }

    public void setBook_date(Date book_date) {
        this.book_date = book_date;
    }

    @Override
    public String toString() {
        return "Books{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", book_writer='" + book_writer + '\'' +
                ", book_press='" + book_press + '\'' +
                ", book_remakes='" + book_remakes + '\'' +
                ", user_id=" + user_id +
                ", book_date=" + book_date +
                '}';
    }
}