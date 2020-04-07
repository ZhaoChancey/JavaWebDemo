package com.atguigu.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.IOException;

/**HttpServlet 已经处理好了分发请求，post和get
 * @author shkstart
 * @create 2020-03-11 9:55
 */
public class HelloServlet2 extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);//重写init方法时，一定要写上调用父类的init
        System.out.println("重写了init初始化方法,做了一些工作");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int i = 8 / 0;

        System.out.println("HelloServlet2的doGet方法");

        //也可以使用
        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig);

        //2、获取初始化参数init-param,只能得到自己servlet中配置的init-param
        System.out.println("初始化参数username的值是;" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是;" + servletConfig.getInitParameter("url"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2的doPost方法");
    }
}
