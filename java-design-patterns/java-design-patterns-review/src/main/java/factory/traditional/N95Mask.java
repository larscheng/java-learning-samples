package factory.traditional;

/**
 * @author Larscheng
 * N95口罩
 */
public class N95Mask extends BaseMask {
    public N95Mask() {
        setName("N95口罩");
    }

    @Override
    public void prepare() {
        System.out.println(name+"开始备料...");
    }
}
