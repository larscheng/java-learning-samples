package observer.demo;

import prototype.demo1.Vehicle;

import java.util.HashMap;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/16 15:55
 */
public class Client {
    public static void main(String[] args) {
        Subject subject  = new ConcreteSubject();

        Observer observer1 = new ConcreteObserver1();
        Observer observer2 = new ConcreteObserver2();

        subject.add(observer1);
        subject.add(observer2);

        subject.notifyObserver();

        final HashMap<String, Integer> objectObjectHashMap1 = new HashMap<>();
        for (int i = 1; i < 15; i++) {
            objectObjectHashMap1.put(String.valueOf(i), i);
        }
        final Integer put = objectObjectHashMap1.put("1", 1);
        final Integer put2 = objectObjectHashMap1.put("1", 11);
        System.out.println(put);
        System.out.println(put2);
        System.out.println(objectObjectHashMap1.get("1"));
        final HashMap<Object, Object> objectObjectHashMap2 = new HashMap<>(13);
        final HashMap<Object, Object> objectObjectHashMap3 = new HashMap<>(16);
        final HashMap<Object, Object> objectObjectHashMap4 = new HashMap<>(17);
        final Vehicle vehicle1 = new Vehicle("123", 123);
        final Vehicle vehicle2 = new Vehicle("123", 123);
        System.out.println(vehicle1.hashCode());
        System.out.println(vehicle2.hashCode());
    }
}
