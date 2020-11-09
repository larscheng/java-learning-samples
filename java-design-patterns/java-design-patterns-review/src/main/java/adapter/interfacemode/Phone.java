package adapter.interfacemode;

import adapter.IOutput5V;
import adapter.Output220V;
import adapter.objectmode.Adapter220To5;

/**
 * @author ：LarsCheng
 * @date ：2020/11/9 15:08
 * @desc ：
 */
public class Phone {

    public void charging(IOutput iOutput){
        if (iOutput.output5()==5){
            System.out.println("电压5v，开始充电");
        }else {
            System.err.println("电压不符，无法充电");
        }
    }
    public static void main(String[] args) {
        AbsAdapter absAdapter = new AbsAdapter(new Output220V()) {
            @Override
            public int output5() {
                int src = output220.output220();
                //适配电压
                int dts = src / 44;
                System.out.println("充电器适配后电压:" + dts);
                return dts;
            }
        };
        new Phone().charging(absAdapter);
    }
}
