package singleton;

/**
 * 静态内部类实现单例
 * 保证线程安全
 * 实现懒加载
 * 推荐使用
 *
 * @author larsCheng
 */
public class SingletonType07 {
    public static void main(String[] args) {
        Singleton07 instance1 = Singleton07.getInstance();
        Singleton07 instance2 = Singleton07.getInstance();

        System.out.println("instance1 == instance2 : " + (instance1 == instance2));
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Singleton07 {
    /**
     * 构造方法私有，防止外部实例化
     */
    private Singleton07() {
    }

    /**
     * 提供一个静态内部类，类中声明一个类型为 Singleton07 的静态属性 INSTANCE
     */
    private static class SingletonInstance {
        private static final Singleton07 INSTANCE = new Singleton07();
    }

    /**
     * 对外提供获取对象的静态方法
     * 外部调用，类名.方法名 Singleton.getInstance()
     *
     * @return 返回单例对象
     */
    public static Singleton07 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}