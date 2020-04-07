package cn.bjtu.book.web;

import cn.bjtu.book.pojo.Cart;
import cn.bjtu.book.pojo.User;
import cn.bjtu.book.service.OrderService;
import cn.bjtu.book.service.impl.OrderServiceImpl;
import cn.bjtu.book.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2020-03-21 11:30
 */
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    /**
     * 生成订单项
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先获取Cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // 获取Userid
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser == null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }

//        System.out.println("OrderServlet程序在[" + Thread.currentThread().getName() + "]中");

        Integer id = loginUser.getId();
        //        调用orderService.createOrder(Cart,Userid);生成订单
        String orderId = orderService.createOrder(cart, id);

//        req.setAttribute("orderId",orderId);
        req.getSession().setAttribute("orderId",orderId);
        // 请求转发到/pages/cart/checkout.jsp
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);
        // 为防止重复提交，使用重定向
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }
}
