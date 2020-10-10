package factory.traditional;

/**
 * @author ：LarsCheng
 * @date ：2020/10/9 14:11
 * @desc ：客户端模拟调用工厂
 */
public class Client {

    /***
     * 根据客户需求定指口罩
     * 1：防霾口罩
     * 2：医用口罩
     * 3：n95口罩
     * @param args
     */
    public static void main(String[] args) {
        new MaskStore().order();
    }
}
