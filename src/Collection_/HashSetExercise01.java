package Collection_;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class HashSetExercise01 {
    public static void main(String[] args) {
        //name和birthday相同时，认为是相同的员工，不能加入到集合中
        HashSet hashSet = new HashSet();
        Employee john = new Employee("john", 18, new MyDate(2001, 6, 7));
        Employee john2 = new Employee("john", 18, new MyDate(2000, 6, 7));
        Employee Mike = new Employee("mike", 18, new MyDate(2001, 6, 7));
//        System.out.println(john.equals(john2));
        hashSet.add(john);
        hashSet.add(Mike);
        System.out.println(hashSet.add(john2));//加入失败
        System.out.println(hashSet);
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return  month == myDate.month && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, day);
    }
}

class Employee {
    private String name;
    private int age;
    private MyDate birthday;

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        //o为null或者o和该对象不属于同一个类
        if (o == null || getClass() != o.getClass())
            return false;
        Employee employee = (Employee) o;
        MyDate myDate = employee.birthday;
//        return (age == employee.age) && Objects.equals(name, employee.name);
        return (age == employee.age) &&
                    (birthday.equals(myDate));
    }

    @Override
    //name和birthday相同则返回相同的哈希值
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}