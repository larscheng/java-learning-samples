package factory.abstractfactory;

/**
 * @author ：LarsCheng
 * @date ：2020/10/10 11:08
 * @desc ：杭州制造酒精
 */
public class HangzhouAlcohol  extends BaseAlcohol{
    @Override
    public void prepare() {
        setName("杭州-医用酒精");
        System.out.println(name+" 开始备料...");
    }
}
