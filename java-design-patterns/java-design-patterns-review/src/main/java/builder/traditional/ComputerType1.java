package builder.traditional;

import java.io.Serializable;

/**
 * @author ：LarsCheng
 * @date ：2020/10/30 16:26
 * @desc ：3000配置的电脑
 */
public class ComputerType1 extends AbstractComputer implements Serializable {

    @Override
    public void cpu() {
        System.out.println("安装普通cpu");
    }

    @Override
    public void ram() {
        System.out.println("安装8g内存");
    }

    @Override
    public void disk() {
        System.out.println("安装500g机械硬盘");
    }

    @Override
    public void graphics() {
        System.out.println("安装低配显卡");
    }

    @Override
    public void power() {
        System.out.println("安装普通电源");
    }
}
