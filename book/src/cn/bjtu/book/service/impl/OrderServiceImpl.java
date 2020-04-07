package cn.bjtu.book.service.impl;

import cn.bjtu.book.dao.BookDao;
import cn.bjtu.book.dao.OrderDao;
import cn.bjtu.book.dao.OrderItemDao;
import cn.bjtu.book.dao.impl.BookDaoImpl;
import cn.bjtu.book.dao.impl.OrderDaoImpl;
import cn.bjtu.book.dao.impl.OrderItemDaoImpl;
import cn.bjtu.book.pojo.*;
import cn.bjtu.book.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @author shkstart
 * @create 2020-03-21 11:11
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        System.out.println("OrderServiceImpl程序在[" + Thread.currentThread().getName() + "]中");

        // 订单号===唯一性
        String orderId = System.currentTimeMillis() + "" + userId;
        // 创建一个订单对象
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        // 保存订单
        orderDao.saveOrder(order);

        int i = 12 / 0;

        // 遍历购物车中每一个商品项转换成为订单项保存到数据库
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()){
            // 获取每一个购物车中的商品项
            CartItem cartItem = entry.getValue();
            // 转换为每一个订单项
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            // 保存订单项到数据库
            orderItemDao.saveOrderItem(orderItem);

            // 更新库存和销量
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            // 不调用保存API不会保存到数据库中
            bookDao.updateBook(book);
        }
        // 清空购物车
        cart.clear();

        return orderId;
    }
}