package factory.simplefactory;

import factory.traditional.BaseMask;
import factory.traditional.HazeMask;
import factory.traditional.MedicalMask;
import factory.traditional.N95Mask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * @author ：LarsCheng
 * @date ：2020/10/9 14:54
 * @desc ：口罩销售点
 */
public class MaskStore {
    private SimpleMaskFactory factory;

    public MaskStore(SimpleMaskFactory factory) {
        this.factory = factory;
    }

    public void order() {
        BaseMask mask = null;
        int maskType;
        do {
            maskType = getType();
            mask = factory.createMask(maskType);
            if (!Objects.isNull(mask)){
                mask.prepare();
                mask.processing();
                mask.bale();
            }else {
                System.out.println("不支持的产品类型...");
                break;
            }
        } while (true);
    }

    private int getType() {
        try {
            BufferedReader typeReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("----------------");
            System.out.println("输入需要下单的类型: ");
            return Integer.parseInt(typeReader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
