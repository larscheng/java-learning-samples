package factory.methodfactory;

import factory.traditional.BaseMask;

/**
 * @author ：LarsCheng
 * @date ：2020/10/9 18:45
 * @desc ：杭州口罩方法工厂
 */
public class ShanghaiMaskFactory extends BaseMaskFactory{
    @Override
    BaseMask createMask(int maskType) {
        BaseMask mask = null;
        if (1==maskType){
            mask = new ShanghaiHazeMask();
        }else if (2==maskType){
            mask = new ShanghaiMedicalMask();
        }
        return mask;
    }
}
