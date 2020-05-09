package cn.itcast.Domain;

import java.util.Date;
/*
* datadealapp_complaintrawdata的domain类
* */
public class Complaintrawdata {
    private int id;
    private String title;
    private String content;
    private String reflecting_time;
    private String reply_unit;
    private String reply_time;
    private String reply_opinion;
    private String province;
    private String city;
    private String city_area;
    private String datetime;
    private int read_times;

    public Complaintrawdata() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReflecting_time() {
        return reflecting_time;
    }

    public void setReflecting_time(String reflecting_time) {
        this.reflecting_time = reflecting_time;
    }

    public String getReply_unit() {
        return reply_unit;
    }

    public void setReply_unit(String reply_unit) {
        this.reply_unit = reply_unit;
    }

    public String getReply_time() {
        return reply_time;
    }

    public void setReply_time(String reply_time) {
        this.reply_time = reply_time;
    }

    public String getReply_opinion() {
        return reply_opinion;
    }

    public void setReply_opinion(String reply_opinion) {
        this.reply_opinion = reply_opinion;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity_area() {
        return city_area;
    }

    public void setCity_area(String city_area) {
        this.city_area = city_area;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getRead_times() {
        return read_times;
    }

    public void setRead_times(int read_times) {
        this.read_times = read_times;
    }

    @Override
    public String toString() {
        return "Complaintrawdata{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", reflecting_time='" + reflecting_time + '\'' +
                ", reply_unit='" + reply_unit + '\'' +
                ", reply_time='" + reply_time + '\'' +
                ", reply_opinion='" + reply_opinion + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", city_area='" + city_area + '\'' +
                ", datetime='" + datetime + '\'' +
                ", read_times=" + read_times +
                '}';
    }
}
