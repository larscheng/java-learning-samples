package factory.traditional;

/**
 * @author Larscheng
 */
public abstract class BaseMask {
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
