package cn.sd.service;

import cn.sd.domain.Instiutions;

public interface Instiutionsservice {
    /**
     * 添加基金会
     * @param instiutions
     */
    void addInstiutions(Instiutions instiutions);

    /**
     * 根据基金会名字和联系人找基金会id
     * @param instiutions
     * @return
     */
    int findIdbyNameandlinkman(Instiutions instiutions);
}
