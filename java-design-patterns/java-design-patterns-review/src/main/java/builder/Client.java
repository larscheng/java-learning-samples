package builder;

/**
 * @author ：LarsCheng
 * @date ：2020/11/9 11:36
 * @desc ：客户
 */
public class Client {
    public static void main(String[] args) {
        StoreBoss boss = new StoreBoss();
        //客户A需要一台价格便宜的电脑
        System.out.println("客户A的电脑配置：");
        boss.setBuilder(new ComputerInstallerA()).builder();
        //客户B需要一台高配高性能电脑
        System.out.println("客户B的电脑配置：");
        boss.setBuilder(new ComputerInstallerB()).builder();
    }
}
