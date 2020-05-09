package cn.sd.domain;

import java.io.Serializable;

public class Instiutions implements Serializable{
    private int instiution_id;//基金会id
    private String instiutions_name;//基金会名称
    private String instiution_address;//基金会地址
    private String instiution_email;//基金会邮箱
    private String instiution_number;//基金会电话
    private String instiution_linkman;//基金会联系人
    private int instiution_donate;//基金会捐赠数量
    private int instiution_actingdonate;//基金会代理捐赠数量

    public int getInstiution_id() {
        return instiution_id;
    }

    public void setInstiution_id(int instiution_id) {
        this.instiution_id = instiution_id;
    }

    public String getInstiutions_name() {
        return instiutions_name;
    }

    public void setInstiutions_name(String instiutions_name) {
        this.instiutions_name = instiutions_name;
    }

    public String getInstiution_address() {
        return instiution_address;
    }

    public void setInstiution_address(String instiution_address) {
        this.instiution_address = instiution_address;
    }

    public String getInstiution_email() {
        return instiution_email;
    }

    public void setInstiution_email(String instiution_email) {
        this.instiution_email = instiution_email;
    }

    public String getInstiution_number() {
        return instiution_number;
    }

    public void setInstiution_number(String instiution_number) {
        this.instiution_number = instiution_number;
    }

    public String getInstiution_linkman() {
        return instiution_linkman;
    }

    public void setInstiution_linkman(String instiution_linkman) {
        this.instiution_linkman = instiution_linkman;
    }

    public int getInstiution_donate() {
        return instiution_donate;
    }

    public void setInstiution_donate(int instiution_donate) {
        this.instiution_donate = instiution_donate;
    }

    public int getInstiution_actingdonate() {
        return instiution_actingdonate;
    }

    public void setInstiution_actingdonate(int instiution_actingdonate) {
        this.instiution_actingdonate = instiution_actingdonate;
    }

    @Override
    public String toString() {
        return "Instiutions{" +
                "instiution_id=" + instiution_id +
                ", instiutions_name='" + instiutions_name + '\'' +
                ", instiution_address='" + instiution_address + '\'' +
                ", instiution_email='" + instiution_email + '\'' +
                ", instiution_number='" + instiution_number + '\'' +
                ", instiution_linkman='" + instiution_linkman + '\'' +
                ", instiution_donate=" + instiution_donate +
                ", instiution_actingdonate=" + instiution_actingdonate +
                '}';
    }
}
