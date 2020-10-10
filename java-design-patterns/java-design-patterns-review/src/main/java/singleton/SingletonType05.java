package singleton;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 饿汉式 同步代码块
 *
 * @author larsCheng
 */
public class SingletonType05 {
    public static void main(String[] args) {
//        Singleton05 instance1 = Singleton05.getInstance();
//        Singleton05 instance2 = Singleton05.getInstance();
//
//        System.out.println("instance1 == instance2 : " + (instance1 == instance2));
//        System.out.println(instance1.hashCode());
//        System.out.println(instance2.hashCode());
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(4, 8, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1000));
        for (int i = 0; i < 20; i++) {
            poolExecutor.execute(new Runnable() {
                public void run() {
                    System.out.println(Singleton05.getInstance().hashCode());
                }
            });
        }
    }
}

class Singleton05 {
    /**
     * 构造方法私有，防止外部实例化
     */
    private Singleton05() {
    }

    /**
     * 静态私有变量
     */
    private static Singleton05 INSTANCE;

    /**
     * 对外提供获取对象的静态方法，加入同步关键字，解决线程同步问题
     * 外部调用，类名.方法名 Singleton.getInstance()
     *
     * @return 返回单例对象
     */
    public static Singleton05 getInstance() {
        synchronized (Singleton05.class) {
            if (INSTANCE == null) {
                INSTANCE = new Singleton05();
            }
        }
        return INSTANCE;
    }
}
