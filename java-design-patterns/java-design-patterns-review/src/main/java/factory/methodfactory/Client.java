package factory.methodfactory;

import java.util.Scanner;

/**
 * @author ：LarsCheng
 * @date ：2020/10/9 18:48
 * @desc ：口罩消费者
 */
public class Client {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择要购买的产品产地，1:杭州，2:上海");
        int location = Integer.parseInt(scanner.nextLine());
        if (1 == location) {
            new HangzhouMaskFactory();
        } else if (2 == location) {
            new ShanghaiMaskFactory();
        } else {
            System.out.println("暂无该地区产品");
        }
    }
}
