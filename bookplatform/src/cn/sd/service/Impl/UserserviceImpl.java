package cn.sd.service.Impl;

import cn.sd.dao.Impl.UserdaoImpl;
import cn.sd.domain.User;
import cn.sd.service.Userservice;

public class UserserviceImpl implements Userservice {
    UserdaoImpl userdao = new UserdaoImpl();

    /**
     * 根据邮箱密码找用户
     * @param email
     * @param password
     * @return
     */
    @Override
    public User findUser(String email, String password) {
        return userdao.findUserByemailandpassword(email,password);
    }

    /**
     * 添加用户
     * @param user
     */
    @Override
    public void addUser(User user) {
        userdao.addUser(user);
    }
    /**
     *更新用户
     */
    @Override
    public void update(User user) {
        userdao.update(user);
    }

}
