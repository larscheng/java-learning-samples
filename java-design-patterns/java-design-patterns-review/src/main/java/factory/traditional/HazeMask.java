package factory.traditional;

/**
 * @author Larscheng
 * 防霾口罩
 */
public class HazeMask extends BaseMask {
    public HazeMask() {
        setName("防霾口罩");
    }

    @Override
    public void prepare() {
        System.out.println(name+"开始备料...");
    }
}
