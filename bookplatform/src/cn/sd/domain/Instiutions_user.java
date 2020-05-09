package cn.sd.domain;

import java.io.Serializable;

public class Instiutions_user implements Serializable{
    private int user_id;//代理基金会的用户id
    private int instiution_id;//基金会id

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getInstiution_id() {
        return instiution_id;
    }

    public void setInstiution_id(int instiution_id) {
        this.instiution_id = instiution_id;
    }

    @Override
    public String toString() {
        return "Instiutions_user{" +
                "user_id=" + user_id +
                ", instiution_id=" + instiution_id +
                '}';
    }
}
