package Learning.Collection_.Set;

import java.util.*;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class HashSetTest01 {
    public static void main(String[] args) {
//        HashSet实现了Set接口
//        底层实际上是HashMap，可以存放null，但只能有一个
//        HashSet不保证元素是有序的，这取决于hash后，再确定索引的结果
        Set hashSet = new HashSet();
//        Iterator iterator = hashSet.iterator();
        hashSet.add(null);
        hashSet.add(null);//再次添加null
        System.out.println(hashSet);//只有一个null,即元素不能重复
        //执行add方法后会返回一个布尔值，成功为true，否则为false
        System.out.println(hashSet.add(null));//添加失败
        hashSet.add(new Dog("tom"));
        hashSet.add(new Dog("tom"));//添加成功，因为是不同的对象，只是名字相同
        System.out.println(hashSet);
        hashSet.add("abc");
        hashSet.add(new String("abc"));//添加失败
        System.out.println(hashSet);
    }
}
class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}