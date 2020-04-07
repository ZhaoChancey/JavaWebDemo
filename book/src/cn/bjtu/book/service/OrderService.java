package cn.bjtu.book.service;

import cn.bjtu.book.pojo.Cart;
import cn.bjtu.book.pojo.Order;

/**
 * @author shkstart
 * @create 2020-03-21 11:07
 */
public interface OrderService {
    public String createOrder(Cart cart,Integer userId);
}
