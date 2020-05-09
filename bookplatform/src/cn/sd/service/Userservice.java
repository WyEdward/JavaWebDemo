package cn.sd.service;

import cn.sd.domain.User;

public interface Userservice {
    /**
     * 根据用户提供的邮箱密码找用户
     * @param email
     * @param password
     * @return
     */
    User findUser(String email,String password);

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void update(User user);
}
