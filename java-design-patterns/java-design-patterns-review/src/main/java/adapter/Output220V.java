package adapter;

/**
 * @author ：LarsCheng
 * @date ：2020/11/9 15:01
 * @desc ：被适配类
 */
public class Output220V {
    public int output220(){
        int src = 220;
        System.out.println("电源输出电压：220V");
        return src;
    }
}
