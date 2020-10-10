package factory.abstractfactory;

import factory.methodfactory.HangzhouHazeMask;
import factory.methodfactory.HangzhouMedicalMask;
import factory.traditional.BaseMask;

/**
 * @author ：LarsCheng
 * @date ：2020/10/10 10:28
 * @desc ：杭州工厂类
 */
public class HangzhouFactory implements AbstractFactory{

    @Override
    public BaseMask createMask() {
        return new HangzhouHazeMask();
    }

    @Override
    public BaseAlcohol createAlcohol() {
        return new HangzhouAlcohol();
    }
}
