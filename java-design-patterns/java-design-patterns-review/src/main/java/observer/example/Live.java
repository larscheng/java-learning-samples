package observer.example;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/16 16:25
 */
public  interface Live {

    /**粉丝关注主播*/
    void add(Fans... fan);

    /**粉丝取关*/
    void remove(Fans... fan);

    /**通知粉丝开播了*/
    void notifyFans();
}
