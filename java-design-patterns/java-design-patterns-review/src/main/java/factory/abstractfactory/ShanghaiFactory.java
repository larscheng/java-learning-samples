package factory.abstractfactory;

import factory.methodfactory.ShanghaiHazeMask;
import factory.methodfactory.ShanghaiMedicalMask;
import factory.traditional.BaseMask;

/**
 * @author ：LarsCheng
 * @date ：2020/10/10 10:28
 * @desc ：上海工厂类
 */
public class ShanghaiFactory implements AbstractFactory{

    @Override
    public BaseMask createMask() {
        return new ShanghaiHazeMask();
    }

    @Override
    public BaseAlcohol createAlcohol() {
        return new ShanghaiAlcohol();
    }
}
