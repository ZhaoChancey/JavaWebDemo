package cn.bjtu.book.dao.impl;

import cn.bjtu.book.dao.OrderDao;
import cn.bjtu.book.pojo.Order;

/**
 * @author shkstart
 * @create 2020-03-21 10:52
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        System.out.println("OrderDaoImpl程序在[" + Thread.currentThread().getName() + "]中");

        String sql = "insert into t_order(order_id,create_time,price,status,user_id) values(?,?,?,?,?)";

        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }
}
