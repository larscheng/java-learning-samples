package factory.abstractfactory;

import java.util.Scanner;

/**
 * @author ：LarsCheng
 * @date ：2020/10/9 18:48
 * @desc ：消费者
 */
public class Client {

    public static void main(String[] args) {

        do {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("请选择要购买的产品产地，1:杭州，2:上海");
            int type = Integer.parseInt(scanner1.nextLine());
            AbstractFactory factory = null;
            if (1 == type) {
                factory = new HangzhouFactory();
            } else if (2 == type) {
                factory = new ShanghaiFactory();
            } else {
                System.out.println("暂无该地区产品");
                break;
            }
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("请选择要购买的产品类型，1:口罩，2:酒精");
            type = Integer.parseInt(scanner2.nextLine());
            if (1 == type) {
                new Store(factory).orderMask();
            } else if (2 == type) {
                new Store(factory).orderAlcohol();
            } else {
                System.out.println("暂无该产品");
                break;
            }
        } while (true);

    }
}
