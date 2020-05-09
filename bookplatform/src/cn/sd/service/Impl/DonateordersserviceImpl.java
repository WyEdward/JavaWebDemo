package cn.sd.service.Impl;

import cn.sd.dao.Donateordersdao;
import cn.sd.dao.Impl.DonateordersdaoImpl;
import cn.sd.domain.Donation_orders;
import cn.sd.service.Donateordersservice;

public class DonateordersserviceImpl implements Donateordersservice {
    DonateordersdaoImpl donateordersdao = new DonateordersdaoImpl();
    @Override
    public void addDonateorder(Donation_orders donation_order) {
        donateordersdao.addDonateorder(donation_order);
    }
}
