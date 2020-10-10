package singleton;

/**
 * 饿汉式 线程不安全
 * 仅仅只能在单线程环境下使用！！！多线程环境下不是单例模式！！！
 * 单线程环境下，实现了懒加载，并且为单例模式
 * 多线程环境下，不是单例模式，会产生多个实例对象
 * <p>
 * 通常情况下我们的应用场景都会存在多个线程，所以这种饿汉式不推荐使用！！！
 *
 * @author larsCheng
 */
public class SingletonType03 {
    public static void main(String[] args) {
        Singleton03 instance1 = Singleton03.getInstance();
        Singleton03 instance2 = Singleton03.getInstance();

        System.out.println("instance1 == instance2 : " + (instance1 == instance2));
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Singleton03 {
    /**
     * 构造方法私有，防止外部实例化
     */
    private Singleton03() {
    }

    /**
     * 静态私有变量
     */
    private static Singleton03 INSTANCE;


    /**
     * 对外提供获取对象的静态方法，此处存在线程安全问题
     * 外部调用，类名.方法名 Singleton.getInstance()
     *
     * @return 返回单例对象
     */
    public static Singleton03 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton03();
        }
        return INSTANCE;
    }
}