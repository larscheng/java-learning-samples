package factory.methodfactory;

import factory.traditional.BaseMask;

/**
 * @author ：LarsCheng
 * @date ：2020/10/9 18:45
 * @desc ：杭州口罩方法工厂
 */
public class HangzhouMaskFactory extends BaseMaskFactory {
    @Override
    BaseMask createMask(int maskType) {
        BaseMask mask = null;
        if (1 == maskType) {
            mask = new HangzhouHazeMask();
        } else if (2 == maskType) {
            mask = new HangzhouMedicalMask();
        }
        return mask;
    }
}
