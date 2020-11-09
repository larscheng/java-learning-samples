package adapter.classmode;

import adapter.IOutput5V;
import adapter.Output220V;

/**
 * @author ：LarsCheng
 * @date ：2020/11/9 15:05
 * @desc ：适配器类
 */
public class Adapter220To5 extends Output220V implements IOutput5V {
    @Override
    public int output5v() {
        int src = output220();
        //适配电压
        int dts = src / 44;
        System.out.println("充电器适配后电压:" + dts);
        return dts;
    }
}
