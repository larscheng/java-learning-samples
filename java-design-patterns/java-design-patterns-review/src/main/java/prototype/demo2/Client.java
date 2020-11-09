package prototype.demo2;

/**
 * @author ：LarsCheng
 * @date ：2020/10/16 14:16
 * @desc ：复指车辆对象-clone方法
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Vehicle vehicle = new Vehicle("哈啰单车", 2.0);
        Vehicle vehicle1 = (Vehicle) vehicle.clone();
        Vehicle vehicle2 = (Vehicle) vehicle.clone();
        System.out.println(vehicle.hashCode());
        System.out.println(vehicle1.hashCode());
        System.out.println(vehicle2.hashCode());
    }
}
