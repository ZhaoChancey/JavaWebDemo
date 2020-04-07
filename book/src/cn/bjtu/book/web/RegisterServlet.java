package cn.bjtu.book.web;

import cn.bjtu.book.pojo.User;
import cn.bjtu.book.service.UserService;
import cn.bjtu.book.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.security.PrivateKey;

/**
 * @author shkstart
 * @create 2020-03-12 19:42
 */
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //        2、检查 验证码是否正确  === 写死,要求验证码为:abcde
        if ("abcde".equalsIgnoreCase(code)){
            //正确
            //        3、检查 用户名是否可用
            if (userService.existsUsername(username)){
                System.out.println("用户名[" + username + "]已存在!");

                //把回显信息，保存到request域中
                req.setAttribute("msg","用户名已存在！");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                //        跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            } else {
                //      可用
//                调用Sservice保存到数据库
                userService.registerUser(new User(null,username,password,email));
                //        跳到注册成功页面 regist_success.jsp
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }

        } else {
            // 不正确
            //把回显信息，保存到request域中
            req.setAttribute("msg","验证码错误！");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            // 跳回注册页面
            System.out.println("验证码" + code + "错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }
}
