package cn.bjtu.book.web;

import cn.bjtu.book.pojo.User;
import cn.bjtu.book.service.UserService;
import cn.bjtu.book.service.impl.UserServiceImpl;
import cn.bjtu.book.test.UserServletTest;
import cn.bjtu.book.utils.WebUtils;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author shkstart
 * @create 2020-03-17 19:50
 */
public class UserServlet extends BaseServlet{
    private UserService userService = new UserServiceImpl();


    protected void ajaxExistUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数username
        String username = req.getParameter("username");
        // 调用userService.existsUsername()判断用户名是否存在;
        boolean existsUsername = userService.existsUsername(username);
        // 把返回的结果封装成为map对象
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("existsUsername",existsUsername);

        Gson gson = new Gson();
        String json = gson.toJson(resultMap);

        resp.getWriter().write(json);

    }


        protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1、销毁Session中用户登录的信息（或者销毁Session）
        req.getSession().invalidate();
//        2、重定向到首页（或登录页面）。
//        req.getRequestDispatcher("/").forward(req,resp); //请求转发回的页面地址是：http://localhost:8080/book/userServlet?action=logout
        resp.sendRedirect(req.getContextPath());
    }

    /**
     * 处理登录的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 调用 userService.login()登录处理业务
        User loginUser = userService.login(new User(null, username, password, null));
        // 如果等于null,说明登录 失败!
        if (loginUser == null){
            // 把错误信息，和回显的表单项信息，保存到Request域中
            req.setAttribute("msg","用户或密码错误");
            req.setAttribute("username",username);
            //   跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);

        } else {
            // 登录 成功
            // 保存用户登录的信息到session域中
            req.getSession().setAttribute("user",loginUser);
            //跳到成功页面login_success.html
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    /**
     * 处理注册的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取Session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        // 删除 Session中的验证码(安全起见)
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        /**
         * Map.Entry<String, String>的意思是一个泛型，表示Entry里装的是两个string的字符串
         * Map.entrySet（）是将map里的每一个键值对取出来封装成一个Entry对象在存到一个Set里面。
         */
//        Map<String, String[]> parameterMap = req.getParameterMap();
//        for (Map.Entry<String,String[]> entry : parameterMap.entrySet()){
//            System.out.println(entry.getKey() + "=" + Arrays.asList(entry.getValue()));
//        }

        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());
        //        2、检查 验证码是否正确  === 写死,要求验证码为:abcde
        if (token != null && token.equalsIgnoreCase(code)){
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
