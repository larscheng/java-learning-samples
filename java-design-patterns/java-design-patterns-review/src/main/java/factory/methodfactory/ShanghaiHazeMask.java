package factory.methodfactory;

import factory.traditional.BaseMask;

/**
 * @author ：LarsCheng
 * @date ：2020/10/9 18:34
 * @desc ：杭州产的防霾口罩
 */
public class ShanghaiHazeMask extends BaseMask {

    @Override
    public void prepare() {
        setName("上海-防霾口罩");
        System.out.println(name +" 开始备料...");
    }
}
