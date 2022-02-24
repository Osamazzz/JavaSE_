package Collection_.List;

import java.util.ArrayList;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class ArrayListTest01 {
    public static void main(String[] args) {
//        1.ArrayList是由数组实现数据存储的,可以加入多个null
//        2.ArrayList基本等同于Vector，除了ArrayList是线程不安全的(执行效率高)
//        3.多线程情况下不推荐用ArrayList
        ArrayList arrayList = new ArrayList();
        arrayList.add(null);
        arrayList.add("tom");
        arrayList.add(1,"zzz");//还可以在指定位置添加
        System.out.println(arrayList);
        System.out.println(arrayList.size());
//        ArrayList中维护了一个Object类型的数组elementData
//        transient Object[] elementData;transient 表示短暂瞬间的，该属性不会被序列化
//        当创建ArrayList时，如果使用的是无参构造器，则初始的elementData容量为0
//        会调用grow方法，第一次添加则扩容为10，再次扩容为1.5倍
//        如果使用指定大小的构造器，则数组大小初始容量为指定大小，再次扩容为1.5倍

    }
}
