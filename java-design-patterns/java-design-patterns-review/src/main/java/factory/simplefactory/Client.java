package factory.simplefactory;

/**
 * @author ：LarsCheng
 * @date ：2020/10/9 14:59
 * @desc ：模拟客户下单
 */
public class Client {
    public static void main(String[] args) {
        new MaskStore(new SimpleMaskFactory()).order();
    }
}
