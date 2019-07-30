package com.shixun.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shixun.spring.model.User;
import com.shixun.spring.util.JDBCutil;

/**
 * 用户持久化操作类
 */
public class UserDao {

    /**
     * 通过用户名查询用户信息
     * @param username 用户名称
     * @return User 对象，未查询到用户，则返回 null
     * @throws SQLException sql 异常
     */
    public User getUserByUsername(String username) throws SQLException {
        Connection conn = JDBCutil.getConnection();
        // 按照用户名称查询用户信息SQL
        PreparedStatement ps = conn.prepareStatement("SELECT id,username, password, email, gender, profession, hobby FROM t_user WHERE username = ?");
        //设置查询条件
        ps.setString(1, username);

        // 执行SQL查询，得到结果集
        ResultSet rs = ps.executeQuery();

        User user = null;
        // 遍历结果集
        while (rs.next()) {
            user = new User();
            user.setId(rs.getLong("id"));
            user.setUsername(username);
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setProfession(rs.getString("profession"));
            user.setHobby(rs.getString("hobby").split(","));
            break;
        }

        // 关闭数据库连接，释放资源
        JDBCutil.close(rs, ps, conn);

        // 返回 user 对象
        return user;
    }

    /**
     * 创建用户
     * @param user 用户对象
     * @return 影响的条数，1表示成功插入数据库，0表示未插入数据库
     * @throws SQLException sql 异常
     */
    public int createUser(User user) throws SQLException {
        Connection conn = JDBCutil.getConnection();
        // 插入用户信息SQL
        PreparedStatement ps = conn.prepareStatement("INSERT INTO t_user (username, password, email, gender, profession, hobby) VALUES (?, ?, ?, ?, ?, ?)");

        // 设置插入参数
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getGender());
        ps.setString(5, user.getProfession());
        ps.setString(6, user.getHobbyString());

        // 执行 sql 语句并得到影响的条数
        int count = ps.executeUpdate();

        // 关闭数据库连接，释放资源
        JDBCutil.close(null, ps, conn);
        return count;
    }
}
