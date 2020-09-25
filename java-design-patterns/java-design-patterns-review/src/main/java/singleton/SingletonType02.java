package singleton;

/**
 *
 * @author larsCheng
 */
public class SingletonType02 {
    public static void main(String[] args) {
        Singleton02 instance1 = Singleton02.getInstance();
        Singleton02 instance2 = Singleton02.getInstance();

        System.out.println("instance1 == instance2 : "+(instance1==instance2));
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Singleton02 {
    /**
     * 构造方法私有，防止外部实例化
     */
    private Singleton02() {
    }
    /**
     * 静态私有变量
     */
    private  static Singleton02 INSTANCE;

    /**
     * 将对象的实例化放在了静态代码块中，同样也是类加载时被执行
     */
    static {
        INSTANCE = new Singleton02();
    }
    /**
     * 对外提供获取对象的静态方法，
     * 外部调用，类名.方法名 Singleton.getInstance()
     * @return 返回单例对象
     */
    public static Singleton02 getInstance() {
        return INSTANCE;
    }
}