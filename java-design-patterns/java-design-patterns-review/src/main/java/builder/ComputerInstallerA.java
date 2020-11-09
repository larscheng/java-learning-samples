package builder;

/**
 * @author ：LarsCheng
 * @date ：2020/11/9 11:25
 * @desc ：安装员A
 */
public class ComputerInstallerA extends ComputerBuilder {

    @Override
    public void cpu() {
        computer.setCpu("普通cpu");
    }

    @Override
    public void ram() {
        computer.setRam("4G内存");
    }

    @Override
    public void disk() {
        computer.setDisk("500G机械硬盘");
    }

    @Override
    public void graphics() {
        computer.setGraphics("集成显卡");
    }

    @Override
    public void power() {
        computer.setPower("普通电源");
    }
}
