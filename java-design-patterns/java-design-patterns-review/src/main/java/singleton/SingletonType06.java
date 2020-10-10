package singleton;

/**
 * 饿汉式 双重检测锁
 *
 * @author larsCheng
 */
public class SingletonType06 {
    public static void main(String[] args) {
        Singleton06 instance1 = Singleton06.getInstance();
        Singleton06 instance2 = Singleton06.getInstance();

        System.out.println("instance1 == instance2 : " + (instance1 == instance2));
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Singleton06 {
    /**
     * 构造方法私有，防止外部实例化
     */
    private Singleton06() {
    }

    /**
     * 静态私有变量
     * 声明volatile,防止指令重排,导致的空对象异常
     */
    private static volatile Singleton06 INSTANCE;

    /**
     * 对外提供获取对象的静态方法，使用双重检查锁机制，保证同步代码块中的实例化代码只会被执行一次
     * 外部调用，类名.方法名 Singleton.getInstance()
     *
     * @return 返回单例对象
     */
    public static Singleton06 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton06.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton06();
                }
            }
        }
        return INSTANCE;
    }
}