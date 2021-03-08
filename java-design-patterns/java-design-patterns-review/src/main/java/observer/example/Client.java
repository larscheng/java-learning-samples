package observer.example;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/16 16:32
 */
public class Client {

    public static void main(String[] args) {
        Live live = new PddLive();

        Fans fan1 = new ZhangSan();
        Fans fan3 = new WangWu();
        live.add(fan1,fan3);

        live.notifyFans();
    }
}
