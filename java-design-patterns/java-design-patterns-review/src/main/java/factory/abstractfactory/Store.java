package factory.abstractfactory;

import factory.traditional.BaseMask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * @author ：LarsCheng
 * @date ：2020/10/10 10:30
 * @desc ：口罩销售点
 */
public class Store {
    private AbstractFactory factory;

    public Store(AbstractFactory factory) {
        this.factory = factory;
    }

    public void orderMask() {
        BaseMask mask = null;
        mask = factory.createMask();
        if (!Objects.isNull(mask)) {
            mask.prepare();
            mask.processing();
            mask.bale();
        } else {
            System.out.println("不支持的产品类型...");
        }
    }

    public void orderAlcohol() {
        BaseAlcohol alcohol = null;
        alcohol = factory.createAlcohol();
        if (!Objects.isNull(alcohol)) {
            alcohol.prepare();
            alcohol.processing();
            alcohol.bale();
        } else {
            System.out.println("不支持的产品类型...");
        }
    }
}
