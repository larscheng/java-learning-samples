package adapter.objectmode;

import adapter.IOutput5V;
import adapter.Output220V;

/**
 * @author ：LarsCheng
 * @date ：2020/11/9 15:08
 * @desc ：
 */
public class Phone {

    public void charging(IOutput5V iOutput5V){
        if (iOutput5V.output5v()==5){
            System.out.println("电压5v，开始充电");
        }else {
            System.err.println("电压不符，无法充电");
        }
    }
    public static void main(String[] args) {
        new Phone().charging(new Adapter220To5().setOutput220(new Output220V()));
    }
}
