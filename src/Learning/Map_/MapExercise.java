package Learning.Map_;

import org.junit.Test;

import java.util.*;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class MapExercise {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("123" , new Employee("john", "123", 10000));
        map.put("456" , new Employee("mike", "456", 20000));
        map.put("789" , new Employee("smith", "789", 30000));
        //遍历工资大于18000的员工对象
        //方式一：通过keySet
        Set keys = map.keySet();
        for (Object key : keys) {
            Employee employee = (Employee) map.get(key);//获取employee对象
            if (employee.getSalary() > 18000) {
                System.out.println(key + "-" + map.get(key));
            }
        }
        System.out.println();
        //方式二：通过entrySet
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
//            Object next =  iterator.next();
//            //向下转型
//            Map.Entry entry = (Map.Entry) next;
            Map.Entry entry = (Map.Entry) iterator.next();//运行类型是hashmap内部类node
            Employee employee = (Employee) entry.getValue();
            if (employee.getSalary() > 18000) {
                System.out.println(entry.getKey() + "-" + entry.getValue());
            }
        }
    }
    @Test
    public void f1() {
        System.out.println("123");
    }
}

class Employee {
    private String name;
    private String id;
    private double salary;

    public double getSalary() {
        return salary;
    }

    public Employee(String name, String id, int salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", salary=" + salary +
                '}';
    }
}
