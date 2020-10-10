package factory.traditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author ：LarsCheng
 * @date ：2020/10/9 13:55
 * @desc ：口罩下单
 */
public class MaskStore {
    public void order() {
        BaseMask mask = null;
        int maskType;
        do {
            maskType = getType();
            if (1 == maskType){
                mask = new HazeMask();
            }else if (2 == maskType){
                mask = new MedicalMask();
            }else if (3 == maskType){
                mask = new N95Mask();
            }else {
                System.out.println("不支持的产品类型");
                break;
            }
            mask.prepare();
            mask.processing();
            mask.bale();
        } while (true);
    }

    /**接收用户要下单的产品类型
     * 1：防霾口罩
     * 2：医用口罩
     * 3：n95口罩
     * */
    private int getType() {
        try {
            BufferedReader typeReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("输入需要下单的类型: ");
            return Integer.parseInt(typeReader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
