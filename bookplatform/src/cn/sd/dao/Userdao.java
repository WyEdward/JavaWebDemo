package cn.sd.dao;


import cn.sd.domain.User;

public interface Userdao {
    /**
     *查找用户
     * @param email 邮箱
     * @param password 密码
     * @return 用户javabean
     */
    User findUserByemailandpassword(String email,String password);

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);
    /**
     * 更新用户信息
     */
    void update(User user);
}
