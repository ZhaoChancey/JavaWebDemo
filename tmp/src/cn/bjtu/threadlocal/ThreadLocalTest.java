package cn.bjtu.threadlocal;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

/**
 * @author shkstart
 * @create 2020-03-21 19:26
 */
public class ThreadLocalTest {
    // Hashtable是线程安全的
//    public static Map<String,Object> data = new Hashtable<>();
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();
    private static Random random = new Random();

    public static class Task implements Runnable{

        @Override
        public void run() {

            threadLocal.set("abc");
            threadLocal.set("aaa");

            System.out.println(threadLocal.get());

            /*
            // 在Run方法中，随机生成一个变量（线程要关联的数据），然后以当前线程名为key保存到map中
            Integer i = random.nextInt(1000);
            // 获取当前线程名
            String name = Thread.currentThread().getName();
            System.out.println("线程["+name+"]生成的随机数是：" + i);
//            data.put(name,i);
            threadLocal.set(i);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            new OrderService().createOrder();
            // 在Run方法结束之前，以当前线程名获取出数据并打印。查看是否可以取出操作
//            Object o = data.get(name);
            Object o = threadLocal.get();
            System.out.println("在线程["+name+"]快结束时取出关联的数据是：" + o);
            */
        }

        public static void main(String[] args) {
            for (int i = 1;i <= 3;i++){
                new Thread(new Task()).start();
            }
        }
    }
}
