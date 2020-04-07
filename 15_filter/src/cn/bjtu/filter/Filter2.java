package cn.bjtu.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2020-03-21 16:45
 */
public class Filter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter2前置代码");
        System.out.println("Filter2线程：" + Thread.currentThread().getName());
        System.out.println("Filter2:" + request.getParameter("username"));
        System.out.println("Filter2取出来的数据：" + request.getAttribute("key1"));
        chain.doFilter(request,response);
        System.out.println("Filter2线程：" + Thread.currentThread().getName());

        System.out.println("Filter2后置代码");
    }

    @Override
    public void destroy() {

    }
}
