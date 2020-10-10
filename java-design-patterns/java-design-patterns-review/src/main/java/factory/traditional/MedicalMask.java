package factory.traditional;

/**
 * @author Larscheng
 * 医用一次性口罩
 */
public class MedicalMask extends BaseMask {
    public MedicalMask() {
        setName("医用一次性口罩");
    }

    @Override
    public void prepare() {
        System.out.println(name+"开始备料...");
    }
}
