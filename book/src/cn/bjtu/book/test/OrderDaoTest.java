package cn.bjtu.book.test;

import cn.bjtu.book.dao.OrderDao;
import cn.bjtu.book.dao.impl.OrderDaoImpl;
import cn.bjtu.book.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2020-03-21 10:59
 */
public class OrderDaoTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao = new OrderDaoImpl();
        // userId不能乱写，一定是t_user表中存在的值
        orderDao.saveOrder(new Order("454987946546",new Date(),new BigDecimal(100),0,122));
    }
}