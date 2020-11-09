package prototype.demo1;

/**
 * @author ：LarsCheng
 * @date ：2020/10/16 14:16
 * @desc ：复指车辆对象->重新创建
 */
public class Client {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("哈啰单车", 2.0);
        Vehicle vehicle1 = new Vehicle(vehicle.getName(),vehicle.getPrice());
        Vehicle vehicle2 = new Vehicle(vehicle.getName(),vehicle.getPrice());
        System.out.println(vehicle.hashCode());
        System.out.println(vehicle1.hashCode());
        System.out.println(vehicle2.hashCode());
    }
}
