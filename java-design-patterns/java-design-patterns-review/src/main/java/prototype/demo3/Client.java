package prototype.demo3;

/**
 * @author ：LarsCheng
 * @date ：2020/10/16 14:16
 * @desc ：复制车辆对象
 *
 * 对象浅拷贝，只能复制本对象，该类的对象属性则无法被复制，只是引用传递
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Vehicle vehicle = new Vehicle("美团单车", 2.0, new Company("美团点评"));

        Vehicle vehicle1 = (Vehicle) vehicle.clone();
        Vehicle vehicle2 = (Vehicle) vehicle.clone();
        System.out.println("vehicle.hashCode(): "+vehicle.hashCode()+" company.hashCode(): "+ vehicle.getCompany().hashCode());
        System.out.println("vehicle1.hashCode(): "+vehicle1.hashCode()+" company.hashCode(): "+ vehicle1.getCompany().hashCode());
        System.out.println("vehicle2.hashCode(): "+vehicle2.hashCode()+" company.hashCode(): "+ vehicle2.getCompany().hashCode());
    }
}
