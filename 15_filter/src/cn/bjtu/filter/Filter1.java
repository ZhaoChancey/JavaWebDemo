package cn.bjtu.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2020-03-21 16:43
 */
public class Filter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("Filter1前置代码");
        System.out.println("Filter1线程：" + Thread.currentThread().getName());
        System.out.println("Filter1:" + request.getParameter("username"));
        request.setAttribute("key1","value1");
        chain.doFilter(request,response);
        System.out.println("Filter1线程：" + Thread.currentThread().getName());
        System.out.println("Filter1后置代码");
    }

    @Override
    public void destroy() {

    }
}
