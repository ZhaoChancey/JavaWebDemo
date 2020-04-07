package cn.bjtu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2020-03-21 15:24
 */
public class AdminFilter implements Filter {
    public AdminFilter() {
        System.out.println("1.Filter构造器方法");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2.Filter初始化方法");

        //1、获取Filter的名称filter-name的内容
        System.out.println("filter-name的值是：" + filterConfig.getFilterName());
        //2、获取在Filter 中配置的init-param 初始化参数
        System.out.println("初始化参数的值为：" + filterConfig.getInitParameter("username"));
        System.out.println("初始化参数的值为：" + filterConfig.getInitParameter("password"));
        //3、获取ServletContext 对象
        System.out.println(filterConfig.getServletContext());
    }

    /**
     * 专门用于拦截请求，可以做权限检查
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("3.Filter的doFilter方法");

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        HttpSession session = httpServletRequest.getSession();
        Object user = httpServletRequest.getSession().getAttribute("user");
        // 如果为null，说明还没有登录
        if (user == null){
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }else {
            // 让程序继续往下访问用户的目标资源
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("4.Filter销毁方法");

    }
}
