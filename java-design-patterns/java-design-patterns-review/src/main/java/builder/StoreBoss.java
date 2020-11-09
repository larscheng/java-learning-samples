package builder;

/**
 * @author ：LarsCheng
 * @date ：2020/11/9 11:31
 * @desc ：指挥者-装机店老板
 */
public class StoreBoss {
    ComputerBuilder builder = null;

    public StoreBoss setBuilder(ComputerBuilder builder) {
        this.builder = builder;
        return this;
    }

    public void builder(){
        Computer computer = builder.build();
        System.out.println(computer.toString());
    }
}
