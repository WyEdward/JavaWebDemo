package cn.sd.service.Impl;

import cn.sd.dao.Impl.Instiution_userdaoImpl;
import cn.sd.domain.User;
import cn.sd.service.Instiution_userservice;

public class Instiution_userserviceImpl implements Instiution_userservice{
    Instiution_userdaoImpl instiution_userdao = new Instiution_userdaoImpl();
    /**
     * 用户关联基金会
     * @param user
     */
    @Override
    public void userAddInstiution(User user,int Instiutions_id) {
        instiution_userdao.userAddInstiution(user,Instiutions_id);
    }
}
