package adapter.interfacemode;

/**
 * @author ：LarsCheng
 * @date ：2020/11/9 17:00
 * @desc ：目标接口
 */
public interface IOutput {
    //转换为5v输出
    int output5();
    //转换为20v输出
    int output20();
    //转换为60v输出
    int output60();
}
