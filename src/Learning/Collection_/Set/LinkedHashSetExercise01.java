package Learning.Collection_.Set;

import java.util.LinkedHashSet;
import java.util.Objects;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class LinkedHashSetExercise01 {
    public static void main(String[] args) {
        LinkedHashSet L = new LinkedHashSet();
        L.add(new Car(1000, "奥拓"));
        L.add(new Car(1000, "奥拓"));//添加失败
        L.add(new Car(10000,"奥拓"));
        L.add(new Car(30000000, "保时捷"));
        System.out.println("L=" + L);
    }

}

class Car {
    private int price;
    private String name;

    public Car(int price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nCar{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return price == car.price && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }
}
