package cn.bjtu.book.filter;

import cn.bjtu.book.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2020-03-21 20:44
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request,response);
            JdbcUtils.commitAndClose();//提交事务
        } catch (Exception e) {
            JdbcUtils.rollbackAndClose();//回滚事务
            e.printStackTrace();
            throw new RuntimeException(e);// 把异常抛给Tomcat管理展示友好的错误页面
        }
    }

    @Override
    public void destroy() {

    }
}