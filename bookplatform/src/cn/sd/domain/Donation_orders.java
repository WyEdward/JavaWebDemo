package cn.sd.domain;

import org.springframework.jdbc.core.RowCallbackHandler;

import java.io.Serializable;
import java.util.Date;

public class Donation_orders implements Serializable{
    private int donation_id;//捐单id
    private int user_id1;//捐书的人
    private int user_id2;//收书的人(查一下是不是基金会用户)
    private Date donation_date;//捐款日期
    private String donation_remarks;//订单捐款备注
    private int book_id;//书的id

    public int getDonation_id() {
        return donation_id;
    }

    public void setDonation_id(int donation_id) {
        this.donation_id = donation_id;
    }

    public int getUser_id1() {
        return user_id1;
    }

    public void setUser_id1(int user_id1) {
        this.user_id1 = user_id1;
    }

    public int getUser_id2() {
        return user_id2;
    }

    public void setUser_id2(int user_id2) {
        this.user_id2 = user_id2;
    }

    public Date getDonation_date() {
        return donation_date;
    }

    public void setDonation_date(Date donation_date) {
        this.donation_date = donation_date;
    }

    public String getDonation_remarks() {
        return donation_remarks;
    }

    public void setDonation_remarks(String donation_remarks) {
        this.donation_remarks = donation_remarks;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    @Override
    public String toString() {
        return "Donation_orders{" +
                "donation_id=" + donation_id +
                ", user_id1=" + user_id1 +
                ", user_id2=" + user_id2 +
                ", donation_date=" + donation_date +
                ", donation_remarks='" + donation_remarks + '\'' +
                ", book_id=" + book_id +
                '}';
    }
}
