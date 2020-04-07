package cn.bjtu.book.test;

import cn.bjtu.book.dao.OrderItemDao;
import cn.bjtu.book.dao.impl.OrderItemDaoImpl;
import cn.bjtu.book.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2020-03-21 11:03
 */
public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();

        orderItemDao.saveOrderItem(new OrderItem(null,"saw第五位",1,new BigDecimal(100),new BigDecimal(100),"454987946546"));
        orderItemDao.saveOrderItem(new OrderItem(null,"saw第san位",3,new BigDecimal(100),new BigDecimal(100),"454987946546"));
        orderItemDao.saveOrderItem(new OrderItem(null,"saw第si位",2,new BigDecimal(100),new BigDecimal(100),"454987946546"));
    }
}