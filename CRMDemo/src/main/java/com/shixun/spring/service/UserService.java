package com.shixun.spring.service;

import java.sql.SQLException;

import com.shixun.spring.dao.UserDao;
import com.shixun.spring.model.User;


/**
 * 用户业务逻辑操作类
 */
public class UserService {

    //创建 UserDao 实例
    private UserDao userDao = new UserDao();

    /**
     * 保存用户：先根据用户名称查询判断用户是否已经存在于数据库中，如果存在，返回失败；如果不存在，插入到数据库
     * @param user 用户信息
     * @return 是否成功保存用户
     * @throws SQLException sql 异常
     */
    public boolean saveUser(User user) throws SQLException {
        // 根据用户名查询数据库
        User dbUser = userDao.getUserByUsername(user.getUsername());

        // 判断是否已经存在该用户，如果存在，返回已经存在
        if (dbUser != null) {
            return false;
        }

        // 插入用户到数据库
        int count = userDao.createUser(user);

        // 如果 count=1 表示插入成功
        if (count == 1) {
            return true;
        }

        // 否则返回插入失败
        return false;
    }
}