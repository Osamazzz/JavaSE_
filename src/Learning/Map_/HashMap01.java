package Learning.Map_;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class HashMap01 {
    public static void main(String[] args) {
        // 在hashmap中存放了一个table数组
        // table数组中的元素是HashMap$Node类型，它实现了Map.Entry这个接口
        // 当添加K-V时，通过key的hash值得到它在table表的索引，然后判断索引处是否存在元素
        // 若没有则直接添加，否则继续判断该元素key和要加入的key是否相等(equals方法)
        // 如果相等则直接替换value，不相等则需要判断是树结构还是链表，作出相应的处理
        HashMap hashMap = new HashMap();
        hashMap.put("java", 123);
        hashMap.put("php", 456);
        hashMap.put("java", 456);
        System.out.println(hashMap);

        Animal animal = new Cat();
        if (animal instanceof Animal) {
            System.out.printf("123");
        }
    }
}

class Animal {

}

class Cat extends Animal {

}
