package cn.bjtu.threadlocal;

/**
 * @author shkstart
 * @create 2020-03-21 19:40
 */
public class OrderDao {
    public void saveOrder(){
        String name = Thread.currentThread().getName();
        System.out.println("OrderDao当前线程[" + name + "]中保存的数据是" + ThreadLocalTest.threadLocal.get());
    }
}
