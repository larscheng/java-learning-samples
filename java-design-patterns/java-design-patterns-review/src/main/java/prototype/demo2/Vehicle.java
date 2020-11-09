package prototype.demo2;

/**
 * @author ：LarsCheng
 * @date ：2020/10/15 16:33
 * @desc ：车
 */
public class Vehicle implements Cloneable {

    private String name;
    private double price;

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

    public Vehicle(String name, double price) {
        this.name = name;
        this.price = price;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
