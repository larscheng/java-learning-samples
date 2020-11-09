package builder;

/**
 * @author ：LarsCheng
 * @date ：2020/11/9 11:23
 * @desc ：
 */
public class Computer {
    private String cpu;
    private String ram;
    private String disk;
    private String graphics;
    private String power;


    public String getCpu() {
        return cpu;
    }

    public Computer setCpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    public String getRam() {
        return ram;
    }

    public Computer setRam(String ram) {
        this.ram = ram;
        return this;
    }

    public String getDisk() {
        return disk;
    }

    public Computer setDisk(String disk) {
        this.disk = disk;
        return this;
    }

    public String getGraphics() {
        return graphics;
    }

    public Computer setGraphics(String graphics) {
        this.graphics = graphics;
        return this;
    }

    public String getPower() {
        return power;
    }

    public Computer setPower(String power) {
        this.power = power;
        return this;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", disk='" + disk + '\'' +
                ", graphics='" + graphics + '\'' +
                ", power='" + power + '\'' +
                '}';
    }
}
