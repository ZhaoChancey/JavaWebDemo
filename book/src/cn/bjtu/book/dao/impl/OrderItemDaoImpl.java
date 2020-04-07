package cn.bjtu.book.dao.impl;

import cn.bjtu.book.dao.OrderItemDao;
import cn.bjtu.book.pojo.OrderItem;

/**
 * @author shkstart
 * @create 2020-03-21 10:56
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        System.out.println("OrderItemDaoImpl程序在[" + Thread.currentThread().getName() + "]中");

        // id是自增的
        String sql = "insert into t_order_item(name,count,price,total_price,order_id) values(?,?,?,?,?)";

        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());

    }
}
