package generic_;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class GenericExercise01 {
    public static void main(String[] args) {
        ArrayList<Employee> arrayList = new ArrayList<>();
        arrayList.add(new Employee("john", 18000, new MyDate(2000, 10, 1)));
        arrayList.add(new Employee("smith", 15000, new MyDate(2001, 10, 1)));
        arrayList.add(new Employee("jack", 12000, new MyDate(1992, 10, 1)));
        arrayList.add(new Employee("jack", 12000, new MyDate(1998, 10, 1)));
        //Comparator接口为比较器接口，相当于外部比较器
        arrayList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (!(o1 != null && o2 != null)) {
                    return 0;//不比较了
                }
                MyDate myDate1 = o1.getBirthday();
                MyDate myDate2 = o2.getBirthday();
                int i = o2.getName().compareTo(o1.getName());
                if (i != 0) {
                    return i;//后减前->降序
                }
                //下面是对myDate的比较，因此放在myDate类中最好
//                name相同
//                if (myDate1.getYear() == myDate2.getYear()) {year相同
//                    if (myDate1.getMonth() == myDate2.getMonth()) {//month相同
//                        return myDate1.getDay() - myDate2.getDay();//升序
//                    }
//                    return myDate1.getMonth() - myDate2.getMonth();
//                }
//                return myDate1.getYear() - myDate2.getYear();
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });
        for (Employee employee : arrayList) {
            System.out.println(employee);
        }

    }
}

class Employee {
    private String name;
    private int sal;
    private MyDate birthday;

    public Employee(String name, int sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}
//Comparable为排序接口，实现类它意味着该类支持排序
class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }

    @Override
    public int compareTo(MyDate o) {
        //name相同
        if (year == o.year) {//year相同
            if (month == o.month) {//month相同
                return day - o.day;//升序
            }
            return month - o.month;
        }
        return year - o.year;
    }
}