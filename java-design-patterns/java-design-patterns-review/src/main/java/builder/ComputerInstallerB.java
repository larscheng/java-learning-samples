package builder;

/**
 * @author ：LarsCheng
 * @date ：2020/11/9 11:25
 * @desc ：安装员A
 */
public class ComputerInstallerB extends ComputerBuilder {

    @Override
    public void cpu() {
        computer.setCpu("高端cpu");
    }

    @Override
    public void ram() {
        computer.setRam("16G内存");
    }

    @Override
    public void disk() {
        computer.setDisk("500G固态硬盘");
    }

    @Override
    public void graphics() {
        computer.setGraphics("GTX2080Ti显卡");
    }

    @Override
    public void power() {
        computer.setPower("金标550W电源");
    }
}
