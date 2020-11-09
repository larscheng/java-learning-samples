package prototype.demo4_1;

/**
 * @author ：LarsCheng
 * @date ：2020/10/16 14:16
 * @desc ：复制车辆对象
 *
 * 使用重写多个clone对象进行对象深拷贝
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Vehicle vehicle = new Vehicle("摩拜", 2.0, new Company("美团"));

        Vehicle vehicle1 = (Vehicle) vehicle.clone();
        Vehicle vehicle2 = (Vehicle) vehicle.clone();

        System.out.println("vehicle.hashCode(): "+vehicle.hashCode()+" company.hashCode(): "+ vehicle.getCompany().hashCode());
        System.out.println("vehicle1.hashCode(): "+vehicle1.hashCode()+" company.hashCode(): "+ vehicle1.getCompany().hashCode());
        System.out.println("vehicle2.hashCode(): "+vehicle2.hashCode()+" company.hashCode(): "+ vehicle2.getCompany().hashCode());
    }
}
