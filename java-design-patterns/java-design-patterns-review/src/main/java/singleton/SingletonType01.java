package singleton;

/**
 * 饿汉式，静态常量写法
 * 优点：
 *    写法简单，在类装载的时候完成实例化，避免线程同步问题
 * 缺点：
 *    在类装载时就实例化，那可能这个对象从始至终都没有被用到，无形中造成资源浪费，没有懒加载效果
 *
 * 这种单例模式，可以使用，并且无需考虑多线程问题，但是存在内存浪费问题
 * @author larsCheng
 */
public class SingletonType01 {
    public static void main(String[] args) {
        Singleton01 instance1 = Singleton01.getInstance();
        Singleton01 instance2 = Singleton01.getInstance();

        System.out.println("instance1 == instance2 "+(instance1==instance2));
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Singleton01 {
    /**
     * 构造方法私有，防止外部实例化
     */
    private Singleton01() {
    }
    /**
     * 在类加载时创建私有的静态变量
     */
    private final static Singleton01 INSTANCE = new Singleton01();

    /**
     * 对外提供获取对象的静态方法，
     * 外部调用，类名.方法名 Singleton.getInstance()
     * @return 返回单例对象
     */
    public static Singleton01 getInstance() {
        return INSTANCE;
    }
}