package factory.methodfactory;

import factory.traditional.BaseMask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * @author ：LarsCheng
 * @date ：2020/10/9 18:41
 * @desc ：基础工厂类
 */
public abstract class BaseMaskFactory {
    abstract BaseMask createMask(int maskType);

    public BaseMaskFactory() {
        BaseMask mask = null;
        int maskType;
        do {
            //1：防霾口罩 2：医用口罩
            maskType = getType();
            mask = createMask(maskType);
            if (!Objects.isNull(mask)) {
                mask.prepare();
                mask.processing();
                mask.bale();
            }else {
                System.out.println("不支持的产品类型...");
                break;
            }
        } while (true);
    }


    /**
     * 接收用户要下单的产品类型
     * 1：防霾口罩
     * 2：医用口罩
     */
    private int getType() {
        try {
            BufferedReader typeReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("输入需要下单的类型: 1:防霾口罩，2:医用口罩");
            return Integer.parseInt(typeReader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
