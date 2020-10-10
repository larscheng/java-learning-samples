package factory.simplefactory;

import factory.traditional.BaseMask;
import factory.traditional.HazeMask;
import factory.traditional.MedicalMask;
import factory.traditional.N95Mask;

/**
 * @author ：LarsCheng
 * @date ：2020/10/9 14:51
 * @desc ：简单口罩工厂，将创建口罩的细节封装
 */
public class SimpleMaskFactory {

    public BaseMask createMask(int maskType) {
        BaseMask mask = null;
        if (1 == maskType) {
            mask = new HazeMask();
        } else if (2 == maskType) {
            mask = new MedicalMask();
        } else if (3 == maskType) {
            mask = new N95Mask();
        }
        return mask;
    }
}
