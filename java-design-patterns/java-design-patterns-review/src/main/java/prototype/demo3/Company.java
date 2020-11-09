package prototype.demo3;

/**
 * @author ：LarsCheng
 * @date ：2020/10/16 14:44
 * @desc ：公司
 */
public class Company {
    private String name;

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public Company(String name) {
        this.name = name;
    }
}
