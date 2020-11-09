package builder.traditional;

/**
 * @author ：LarsCheng
 * @date ：2020/10/30 16:17
 * @desc ：抽象电脑类
 */
public abstract class AbstractComputer {
    /**安装cpu*/
    public abstract void cpu();
    /**安装内存*/
    public abstract void ram();
    /**安装硬盘*/
    public abstract void disk();
    /**安装显卡*/
    public abstract void graphics();
    /**安装电源*/
    public abstract void power();

    public void build(){
        this.cpu();
        this.ram();
        this.disk();
        this.graphics();
        this.power();
    }
}
