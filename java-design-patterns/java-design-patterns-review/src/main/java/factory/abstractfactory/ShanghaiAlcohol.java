package factory.abstractfactory;

/**
 * @author ：LarsCheng
 * @date ：2020/10/10 11:08
 * @desc ：上海制造酒精
 */
public class ShanghaiAlcohol extends BaseAlcohol{
    @Override
    public void prepare() {
        setName("上海-医用酒精");
        System.out.println(name+" 开始备料...");
    }
}
