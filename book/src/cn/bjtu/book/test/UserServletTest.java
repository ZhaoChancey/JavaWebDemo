package cn.bjtu.book.test;

import cn.bjtu.book.web.UserServlet;

import java.lang.reflect.Method;

/**
 * @author shkstart
 * @create 2020-03-17 21:19
 */
public class UserServletTest {
    public void regist(){
        System.out.println("这是regist()方法调用了");
    }

    public void login(){
        System.out.println("这是login()方法调用了");
    }

    public void updateUser(){
        System.out.println("这是updateUser()方法调用了");
    }

    public void updateUserPassword(){
        System.out.println("这是updateUserPassword()方法调用了");
    }

    public static void main(String[] args) {
        String action = "login";
        try {
            //通过action获取业务鉴别字符串，获取相应的业务方法的反射对象
            Method method = UserServletTest.class.getDeclaredMethod(action);
            //调用目标业务的方法
            method.invoke(new UserServletTest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
