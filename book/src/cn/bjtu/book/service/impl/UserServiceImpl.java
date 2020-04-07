package cn.bjtu.book.service.impl;

import cn.bjtu.book.dao.UserDao;
import cn.bjtu.book.dao.impl.UserDaoImpl;
import cn.bjtu.book.pojo.User;
import cn.bjtu.book.service.UserService;

/**
 * @author shkstart
 * @create 2020-03-12 19:17
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username) == null){
            // 等于null,说明没查到，没查到表示可用
            return false;
        }
        return true;
    }
}
