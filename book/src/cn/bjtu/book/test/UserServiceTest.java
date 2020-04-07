package cn.bjtu.book.test;

import cn.bjtu.book.dao.UserDao;
import cn.bjtu.book.pojo.User;
import cn.bjtu.book.service.UserService;
import cn.bjtu.book.service.impl.UserServiceImpl;
import org.junit.Test;

import javax.sound.midi.Soundbank;

import java.sql.SQLOutput;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2020-03-12 19:30
 */
public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"adminq","asasa","eew@qq.com"));
        userService.registerUser(new User(null,"admin123","asasa","eew@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "admin1", "admin", null)));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("admin11")){
            System.out.println("用户名已存在！");
        }else {
            System.out.println("用户名可用！");
        }
    }
}