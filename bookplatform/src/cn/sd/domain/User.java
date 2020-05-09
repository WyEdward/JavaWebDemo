package cn.sd.domain;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
    private int user_id;//用户id
    private String user_nick;//用户昵称
    private String user_password;//用户密码
    private String user_phone;//用户电话
    private Date create_time;//用户创建时间
    private String user_email;//用户邮箱
    private int isinstiutions;//判断是不是基金会用户 默认为0不是基金会用户
    private int user_donations;//用户捐书数量
    private int user_bedonations;//被捐赠数量

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_nick() {
        return user_nick;
    }

    public void setUser_nick(String user_nick) {
        this.user_nick = user_nick;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public int getIsinstiutions() {
        return isinstiutions;
    }

    public void setIsinstiutions(int isinstiutions) {
        this.isinstiutions = isinstiutions;
    }

    public int getUser_donations() {
        return user_donations;
    }

    public void setUser_donations(int user_donations) {
        this.user_donations = user_donations;
    }

    public int getUser_bedonations() {
        return user_bedonations;
    }

    public void setUser_bedonations(int user_bedonations) {
        this.user_bedonations = user_bedonations;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_nick='" + user_nick + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", create_time=" + create_time +
                ", user_email='" + user_email + '\'' +
                ", isinstiutions=" + isinstiutions +
                ", user_donations=" + user_donations +
                ", user_bedonations=" + user_bedonations +
                '}';
    }
}
