package cn.bjtu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author shkstart
 * @create 2020-03-17 22:01
 */
public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决post请求中文乱码问题
        // 一定要在获取请求参数之前调用才有效
        req.setCharacterEncoding("UTF-8");
        // 解决响应中文乱码
        resp.setContentType("text/html;charset=UTF-8");
        String action = req.getParameter("action");

        try {
            //通过action获取业务鉴别字符串，获取相应的业务方法的反射对象
            Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            //调用目标业务的方法
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);//把异常抛给Filter过滤器
        }
    }
}
