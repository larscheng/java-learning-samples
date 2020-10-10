package singleton;

/**
 * 枚举实现单例
 * 保证线程安全
 * 实现懒加载
 * 推荐使用
 *
 * @author larsCheng
 */
public class SingletonType08 {
    public static void main(String[] args) {
        String connection1 = Singleton08.INSTANCE.getConnection();
        String connection2 = Singleton08.INSTANCE.getConnection();

        System.out.println("connection1 == connection2 : " + (connection1 == connection2));
        System.out.println(connection2.hashCode());
        System.out.println(connection2.hashCode());
    }
}

enum Singleton08 {
    /***/
    INSTANCE;

    /**资源对象,此处以字符串示例*/
    private String connection = null;

    Singleton08() {
        this.connection = "127.0.0.1";
    }

    /**
     * 对外提供获取资源对象的静态方法
     */
    public String getConnection() {
        return connection;
    }
}