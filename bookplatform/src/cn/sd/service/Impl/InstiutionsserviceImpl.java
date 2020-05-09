package cn.sd.service.Impl;

import cn.sd.dao.Impl.InstiutionsdaoImpl;
import cn.sd.domain.Instiutions;
import cn.sd.service.Instiutionsservice;

public class InstiutionsserviceImpl implements Instiutionsservice {
    InstiutionsdaoImpl instiutionsdao = new InstiutionsdaoImpl();
    @Override
    public void addInstiutions(Instiutions instiutions) {
        instiutionsdao.addInstiution(instiutions);
    }

    @Override
    public int findIdbyNameandlinkman(Instiutions instiutions) {
       return instiutionsdao.findIdbyNameandlinkman(instiutions);
    }

}
