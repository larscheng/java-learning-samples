package observer.example;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/16 16:29
 */
public class PddLive implements Live {
    public List<Fans> fans = new ArrayList<>();

    @Override
    public void add(Fans... fan) {
        for (Fans f:fan){
            System.out.println(f.getClass().getSimpleName()+"关注成功");
            fans.add(f);
        }
    }

    @Override
    public void remove(Fans... fan) {
        for (Fans f:fan){
            System.out.println(f.getClass().getSimpleName()+"取关成功");
            fans.remove(f);
        }
    }

    @Override
    public void notifyFans() {
        System.out.println("Pdd开直播了大家快来围观啊~~");
        fans.forEach(Fans::openApp);
    }
}
