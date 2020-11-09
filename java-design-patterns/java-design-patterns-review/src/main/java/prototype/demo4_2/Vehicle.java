package prototype.demo4_2;

import java.io.*;

/**
 * @author ：LarsCheng
 * @date ：2020/10/15 16:33
 * @desc ：车
 */
public class Vehicle implements Serializable {

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

    protected Object deepClone()  {
        Vehicle vehicle = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            //以流的方式将该对象写入输出流
            oos.writeObject(this);
            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            vehicle = (Vehicle)ois.readObject();
            return vehicle;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                ois.close();
                bis.close();
                oos.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

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
