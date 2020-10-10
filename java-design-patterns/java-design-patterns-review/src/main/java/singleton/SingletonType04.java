package singleton;

/**
 * 饿汉式 同步方法
 * 在getInstance方法上加入synchronized关键字，解决线程不安全的问题
 * 但是每一次调用getInstance方法都需要进行方法同步，效率过低，不推荐使用
 * @author larsCheng
 */
public class SingletonType04 {
    public static void main(String[] args) {
        Singleton04 instance1 = Singleton04.getInstance();
        Singleton04 instance2 = Singleton04.getInstance();

        System.out.println("instance1 == instance2 : " + (instance1 == instance2));
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Singleton04 {
    /**
     * 构造方法私有，防止外部实例化
     */
    private Singleton04() {
    }

    /**
     * 静态私有变量
     */
    private static Singleton04 INSTANCE;

    /**
     * 对外提供获取对象的静态方法，加入同步关键字，解决线程同步问题
     * 外部调用，类名.方法名 Singleton.getInstance()
     *
     * @return 返回单例对象
     */
    public static synchronized Singleton04 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton04();
        }
        return INSTANCE;
    }
}


class Singleton04ErrorSolution {
    /**
     * 构造方法私有，防止外部实例化
     */
    private Singleton04ErrorSolution() {
    }

    /**
     * 静态私有变量
     */
    private static Singleton04ErrorSolution INSTANCE;

    /**
     * 对外提供获取对象的静态方法，对造成线程安全问题的代码块进行同步
     * 外部调用，类名.方法名 Singleton.getInstance()
     *
     * @return 返回单例对象
     */
    public static Singleton04ErrorSolution getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton04ErrorSolution.class) {
                INSTANCE = new Singleton04ErrorSolution();
            }
        }
        return INSTANCE;
    }
}