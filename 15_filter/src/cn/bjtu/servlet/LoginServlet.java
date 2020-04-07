package cn.bjtu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2020-03-21 15:49
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("zqc1997120".equals(username) && "lyl222".equals(password)){
            req.getSession().setAttribute("user",username);
            resp.getWriter().write("登录成功啦！");
        }else {
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}

