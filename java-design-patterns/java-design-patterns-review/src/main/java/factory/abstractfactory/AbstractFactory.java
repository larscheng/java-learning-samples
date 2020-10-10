package factory.abstractfactory;

import factory.traditional.BaseMask;

/**
 * @author ：LarsCheng
 * @date ：2020/10/10 10:27
 * @desc ：抽象工厂类
 */
public interface AbstractFactory {
    BaseMask createMask();
    BaseAlcohol createAlcohol();
}
