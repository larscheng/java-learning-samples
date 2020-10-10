package factory.abstractfactory;

/**
 * @author ：LarsCheng
 * @date ：2020/10/10 11:06
 * @desc ：抽象酒精类
 */
public abstract class BaseAlcohol {
    protected String name;
    public abstract void prepare();
    public void processing(){
        System.out.println(name+" 开始加工...");
    }
    public void bale(){
        System.out.println(name+" 打包完成...");
    }
    public void setName(String name) {
        this.name = name;
    }
}
