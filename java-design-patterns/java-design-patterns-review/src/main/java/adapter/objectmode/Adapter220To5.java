package adapter.objectmode;

import adapter.IOutput5V;
import adapter.Output220V;

/**
 * @author ：LarsCheng
 * @date ：2020/11/9 15:05
 * @desc ：适配器类
 */
public class Adapter220To5  implements IOutput5V {
    private Output220V output220;

    public Adapter220To5 setOutput220(Output220V output220) {
        this.output220 = output220;
        return this;
    }

    @Override
    public int output5v() {
        int src = output220.output220();
        //适配电压
        int dts = src / 44;
        System.out.println("充电器适配后电压:" + dts);
        return dts;
    }
}
