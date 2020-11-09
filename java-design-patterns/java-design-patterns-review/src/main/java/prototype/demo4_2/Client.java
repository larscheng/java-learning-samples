package prototype.demo4_2;

/**
 * @author ：LarsCheng
 * @date ：2020/10/16 14:16
 * @desc ：复制车辆对象
 *
 * 利用序列化和反序列化实现深拷贝
 */
public class Client {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("青桔", 2.0, new Company("滴滴"));

        Vehicle vehicle1 = (Vehicle) vehicle.deepClone();
        Vehicle vehicle2 = (Vehicle) vehicle.deepClone();

        System.out.println("vehicle.hashCode(): "+vehicle.hashCode()+" company.hashCode(): "+ vehicle.getCompany().hashCode());
        System.out.println("vehicle1.hashCode(): "+vehicle1.hashCode()+" company.hashCode(): "+ vehicle1.getCompany().hashCode());
        System.out.println("vehicle2.hashCode(): "+vehicle2.hashCode()+" company.hashCode(): "+ vehicle2.getCompany().hashCode());
    }
}
