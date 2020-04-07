package cn.bjtu.book.dao.impl;

import cn.bjtu.book.dao.UserDao;
import cn.bjtu.book.pojo.User;
import cn.bjtu.book.utils.WebUtils;

import java.util.HashMap;

/**
 * @author shkstart
 * @create 2020-03-12 17:08
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select id,username,password,email from t_user where username = ?";
        return queryForOne(User.class,sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select id,username,password,email from t_user where username = ? and password = ?";
        return queryForOne(User.class,sql, username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,password,email) VALUES(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }


}
