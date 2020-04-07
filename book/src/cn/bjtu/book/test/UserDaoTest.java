package cn.bjtu.book.test;

import cn.bjtu.book.dao.UserDao;
import cn.bjtu.book.dao.impl.UserDaoImpl;
import cn.bjtu.book.pojo.User;
import org.junit.Test;

import javax.sound.midi.Soundbank;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2020-03-12 17:20
 */
public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        if (userDao.queryUserByUsername("admin12") == null){
            System.out.println("用户名可用！");
        }else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("admin","admin") == null){
            System.out.println("用户名或密码错误，登录失败");
        }else {
            System.out.println("登录成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println( userDao.saveUser(new User(null,"admin1111","admin2122","dsd@qq.com")));
    }
}