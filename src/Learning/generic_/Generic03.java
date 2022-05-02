package Learning.generic_;

import java.util.*;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class Generic03 {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        set.add(new Student("john", 12));
        set.add(new Student("smith", 18));
        set.add(new Student("jack", 15));
//        set.add(100);
        Iterator<Student> iterator = set.iterator();
        while (iterator.hasNext()) {
            Student student =  iterator.next();
            System.out.println(student);

        }
        HashMap<String, Student> hashMap = new HashMap<>();

        hashMap.put("john", new Student("john", 12));
        hashMap.put("smith", new Student("smith", 18));
        hashMap.put("jack", new Student("jack", 15));
        System.out.println();
        //for
        Set<Map.Entry<String,Student>> set1 = hashMap.entrySet();
        for (Object o : set1) {
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        System.out.println();
        //迭代器
        Iterator<Map.Entry<String, Student>> iterator1 = set1.iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String, Student> next =  iterator1.next();
            System.out.println(next.getKey() + "-" + next.getValue());
        }

    }
}

class Student {
    private String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}