package factory.methodfactory;

import factory.traditional.BaseMask;

/**
 * @author ：LarsCheng
 * @date ：2020/10/9 18:38
 * @desc ：杭州-医用口罩
 */
public class ShanghaiMedicalMask extends BaseMask {
    @Override
    public void prepare() {
        setName("上海-医用口罩");
        System.out.println(name+" 开始备料...");
    }
}
