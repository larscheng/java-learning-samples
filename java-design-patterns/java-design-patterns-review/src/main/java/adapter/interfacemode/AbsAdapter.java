package adapter.interfacemode;

import adapter.Output220V;

/**
 * @author ：LarsCheng
 * @date ：2020/11/9 17:01
 * @desc ：抽象适配器
 */
public abstract class AbsAdapter implements IOutput{
    protected Output220V output220;

    public AbsAdapter(Output220V output220V) {
        this.output220 = output220V;
    }

    @Override
    public int output5() {
        return 0;
    }

    @Override
    public int output20() {
        return 0;
    }

    @Override
    public int output60() {
        return 0;
    }
}
