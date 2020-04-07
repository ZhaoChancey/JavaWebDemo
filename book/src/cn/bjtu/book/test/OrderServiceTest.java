package cn.bjtu.book.test;

import cn.bjtu.book.pojo.Cart;
import cn.bjtu.book.pojo.CartItem;
import cn.bjtu.book.service.OrderService;
import cn.bjtu.book.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2020-03-21 11:27
 */
public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100),new BigDecimal(100)));

        OrderService orderService = new OrderServiceImpl();

        orderService.createOrder(cart,1);
    }
}