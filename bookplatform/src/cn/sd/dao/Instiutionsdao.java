package cn.sd.dao;

import cn.sd.domain.Instiutions;


public interface Instiutionsdao {
    /**
     * 添加基金会信息到表里
     * @param instiutions
     */
    void addInstiution(Instiutions instiutions);

    /**
     * 根据基金会的名字和联系人找基金会id
     * @param instiutions
     * @return
     */
    int findIdbyNameandlinkman(Instiutions instiutions);

}
