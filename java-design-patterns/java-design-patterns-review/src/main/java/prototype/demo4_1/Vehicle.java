package prototype.demo4_1;

/**
 * @author ：LarsCheng
 * @date ：2020/10/15 16:33
 * @desc ：车
 */
public class Vehicle implements Cloneable {

    private String name;
    private double price;
    private Company company;

    public String getName() {
        return name;
    }

    public Vehicle setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Vehicle setPrice(double price) {
        this.price = price;
        return this;
    }

    public Company getCompany() {
        return company;
    }

    public Vehicle setCompany(Company company) {
        this.company = company;
        return this;
    }

    public Vehicle(String name, double price, Company company) {
        this.name = name;
        this.price = price;
        this.company = company;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Vehicle vehicle = (Vehicle) super.clone();
        vehicle.setCompany((Company) this.company.clone());
        return vehicle;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", company=" + company +
                '}';
    }
}
